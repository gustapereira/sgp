package br.com.sgp.service;

import br.com.sgp.domain.Ferias;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.FeriasRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class FeriasService {

    private final FeriasRepository feriasRepository;
    private final MessageSource messageSource;

    public FeriasService(FeriasRepository feriasRepository, MessageSource messageSource) {
        this.feriasRepository = feriasRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public Ferias salvar(final Ferias ferias) {
        return feriasRepository.save(ferias);
    }


    public List<Ferias> findAll() {
        return feriasRepository.findAll();
    }


    @Transactional
    public Ferias atualizar(Ferias ferias) throws OperacaoException {
        if (ferias.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<Ferias> optionalFerias = feriasRepository.findById(ferias.getId());
        if (!optionalFerias.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        ferias = atualizaCard(ferias, optionalFerias.get());
        return feriasRepository.save(ferias);
    }


    public Ferias atualizaCard(Ferias ferias, Ferias saved) {

        Date dtFerias = ferias.getDtFerias() != null ? ferias.getDtFerias() : saved.getDtFerias();

        ferias.setDtFerias(dtFerias);

        return ferias;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<Ferias> optionalCard = feriasRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        feriasRepository.delete(optionalCard.get());
    }

}
