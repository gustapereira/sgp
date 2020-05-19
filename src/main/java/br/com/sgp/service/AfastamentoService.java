package br.com.sgp.service;

import br.com.sgp.domain.Afastamento;
import br.com.sgp.enums.TypeAfastamento;
import br.com.sgp.enums.TypeStatus;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.AfastamentoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class AfastamentoService {

    private final AfastamentoRepository afastamentoRepository;
    private final MessageSource messageSource;

    public AfastamentoService(AfastamentoRepository afastamentoRepository, MessageSource messageSource) {
        this.afastamentoRepository = afastamentoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public Afastamento salvar(final Afastamento afastamento) {
        return afastamentoRepository.save(afastamento);
    }


    public List<Afastamento> findAll() {
        return afastamentoRepository.findAll();
    }


    @Transactional
    public Afastamento atualizar(Afastamento afastamento) throws OperacaoException {
        if (afastamento.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<Afastamento> optionalAfastamento = afastamentoRepository.findById(afastamento.getId());
        if (!optionalAfastamento.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        afastamento = atualizaCard(afastamento, optionalAfastamento.get());
        return afastamentoRepository.save(afastamento);
    }


    public Afastamento atualizaCard(Afastamento afastamento, Afastamento saved) {

        Date date = afastamento.getDtAfastamento() != null ? afastamento.getDtAfastamento() : saved.getDtAfastamento();
        TypeAfastamento typeAfastamento = afastamento.getTypeAfastamento() != null ? afastamento.getTypeAfastamento() : saved.getTypeAfastamento();

        afastamento.setDtAfastamento(date);
        afastamento.setTypeAfastamento(typeAfastamento);

        return afastamento;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<Afastamento> optionalCard = afastamentoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        afastamentoRepository.delete(optionalCard.get());
    }

}
