package br.com.sgp.service;

import br.com.sgp.domain.CBO;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.CBORepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class CBOService {

    private final CBORepository cboRepository;
    private final MessageSource messageSource;

    public CBOService(CBORepository cboRepository, MessageSource messageSource) {
        this.cboRepository = cboRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public CBO salvar(final CBO cbo) {
        return cboRepository.save(cbo);
    }


    public List<CBO> findAll() {
        return cboRepository.findAll();
    }


    @Transactional
    public CBO atualizar(CBO cbo) throws OperacaoException {
        if (cbo.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<CBO> optionalCBO = cboRepository.findById(cbo.getId());
        if (!optionalCBO.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        cbo = atualizaCard(cbo, optionalCBO.get());
        return cboRepository.save(cbo);
    }


    public CBO atualizaCard(CBO cbo, CBO saved) {

        String nome = cbo.getNome() != null ? cbo.getNome() : saved.getNome();

        cbo.setNome(nome);

        return cbo;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<CBO> optionalCard = cboRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        cboRepository.delete(optionalCard.get());
    }

}
