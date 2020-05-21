package br.com.sgp.service;

import br.com.sgp.domain.PontoFacultativo;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.PontoFacultativoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class PontoFacultativoService {

    private final PontoFacultativoRepository pontoFacultatvRepository;
    private final MessageSource messageSource;

    public PontoFacultativoService(PontoFacultativoRepository pontoFacultatvRepository, MessageSource messageSource) {
        this.pontoFacultatvRepository = pontoFacultatvRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public PontoFacultativo salvar(final PontoFacultativo pontoFacultatv) {
        return pontoFacultatvRepository.save(pontoFacultatv);
    }


    public List<PontoFacultativo> findAll() {
        return pontoFacultatvRepository.findAll();
    }


    @Transactional
    public PontoFacultativo atualizar(PontoFacultativo pontoFacultatv) throws OperacaoException {
        if (pontoFacultatv.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<PontoFacultativo> optionalPontoFacultativo = pontoFacultatvRepository.findById(pontoFacultatv.getId());
        if (!optionalPontoFacultativo.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        pontoFacultatv = atualizaCard(pontoFacultatv, optionalPontoFacultativo.get());
        return pontoFacultatvRepository.save(pontoFacultatv);
    }


    public PontoFacultativo atualizaCard(PontoFacultativo pontoFacultatv, PontoFacultativo saved) {

        String descricao = pontoFacultatv.getDescricao() != null ? pontoFacultatv.getDescricao() : saved.getDescricao();
        String nome = pontoFacultatv.getNome() != null ? pontoFacultatv.getNome() : saved.getNome();

        pontoFacultatv.setDescricao(descricao);
        pontoFacultatv.setNome(nome);

        return pontoFacultatv;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<PontoFacultativo> optionalCard = pontoFacultatvRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        pontoFacultatvRepository.delete(optionalCard.get());
    }

}
