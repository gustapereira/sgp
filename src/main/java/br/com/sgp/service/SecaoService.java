package br.com.sgp.service;

import br.com.sgp.domain.Setor;
import br.com.sgp.dto.SecaoDTO;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.SecaoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class SecaoService {

    private final SecaoRepository secaoRepository;
    private final MessageSource messageSource;

    public SecaoService(SecaoRepository secaoRepository, MessageSource messageSource) {
        this.secaoRepository = secaoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public SecaoDTO salvar(final SecaoDTO secao) {
        return secaoRepository.save(secao);
    }

    public List<SecaoDTO> findAll() {
        return secaoRepository.findAll();
    }

    @Transactional
    public SecaoDTO atualizar(SecaoDTO secao) throws OperacaoException {
        if (secao.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<SecaoDTO> optionalSecao = secaoRepository.findById(secao.getId());
        if (!optionalSecao.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        secao = atualizaCard(secao, optionalSecao.get());
        return secaoRepository.save(secao);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<SecaoDTO> optionalCard = secaoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        secaoRepository.delete(optionalCard.get());
    }

    public SecaoDTO atualizaCard(SecaoDTO secao, SecaoDTO saved) {

        String nome = secao.getNome() != null ? secao.getNome() : saved.getNome();
        String descricao = secao.getDescricao() != null ? secao.getDescricao() : saved.getDescricao();
        Setor setor = secao.getSetor() != null ? secao.getSetor() : saved.getSetor();

        secao.setNome(nome);
        secao.setDescricao(descricao);
        secao.setSetor(setor);

        return secao;
    }

}
