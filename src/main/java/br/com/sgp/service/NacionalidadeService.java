package br.com.sgp.service;

import br.com.sgp.domain.Nacionalidade;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.NacionalidadeRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class NacionalidadeService {

    private final NacionalidadeRepository nacionalidadeRepository;
    private final MessageSource messageSource;

    public NacionalidadeService(NacionalidadeRepository nacionalidadeRepository, MessageSource messageSource) {
        this.nacionalidadeRepository = nacionalidadeRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public Nacionalidade salvar(final Nacionalidade nacionalidade) {
        return nacionalidadeRepository.save(nacionalidade);
    }


    public List<Nacionalidade> findAll() {
        return nacionalidadeRepository.findAll();
    }


    @Transactional
    public Nacionalidade atualizar(Nacionalidade nacionalidade) throws OperacaoException {
        if (nacionalidade.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<Nacionalidade> optionalNacionalidade = nacionalidadeRepository.findById(nacionalidade.getId());
        if (!optionalNacionalidade.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        nacionalidade = atualizaCard(nacionalidade, optionalNacionalidade.get());
        return nacionalidadeRepository.save(nacionalidade);
    }


    public Nacionalidade atualizaCard(Nacionalidade nacionalidade, Nacionalidade saved) {

        String cidade = nacionalidade.getNacionalidade() != null ? nacionalidade.getNacionalidade() : saved.getNacionalidade();
        String pais = nacionalidade.getPais() != null ? nacionalidade.getPais() : saved.getPais();

        nacionalidade.setNacionalidade(cidade);
        nacionalidade.setPais(pais);

        return nacionalidade;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<Nacionalidade> optionalCard = nacionalidadeRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        nacionalidadeRepository.delete(optionalCard.get());
    }

}
