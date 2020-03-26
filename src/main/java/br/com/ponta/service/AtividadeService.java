package br.com.ponta.service;

import br.com.ponta.domain.Empresa;
import br.com.ponta.domain.TypeStatus;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.AtividadeRepository;
import br.com.ponta.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;
    private final MessageSource messageSource;

    public AtividadeService(AtividadeRepository atividadeRepository, MessageSource messageSource) {
        this.atividadeRepository = atividadeRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public Empresa salvar(final Empresa atividade) {
        return atividadeRepository.save(atividade);
    }

    public List<Empresa> salvar(final List<Empresa> atividade) {
        return atividadeRepository.saveAll(atividade);
    }

    public List<Empresa> findAll() {
        return atividadeRepository.findAll();
    }

    public List<Empresa> findAllNews(Long id) {
        return atividadeRepository.findAllByNews(id);
    }

    public List<Empresa> findAllByProperty(Long id) {
        return atividadeRepository.findAllByProperty(id);
    }

    public List<Empresa> findAllByPraga(Long id) {
        return atividadeRepository.findAllByPraga(id);
    }

    public List<Empresa> findByTypeTags(TypeStatus typeStatus) {
        return atividadeRepository.findByTypeStatus(typeStatus);
    }

    @Transactional
    public Empresa atualizar(Empresa atividade) throws OperacaoException {
        if (atividade.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<Empresa> optionalAtividade = atividadeRepository.findById(atividade.getId());
        if (!optionalAtividade.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        atividade = atualizaCard(atividade, optionalAtividade.get());
        return atividadeRepository.save(atividade);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<Empresa> optionalCard = atividadeRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        atividadeRepository.delete(optionalCard.get());
    }

    public Empresa atualizaCard(Empresa atividade, Empresa saved) {

        String nome = atividade.getNome() != null ? atividade.getNome() : saved.getNome();
        String descricao = atividade.getDescricao() != null ? atividade.getDescricao() : saved.getDescricao();

        atividade.setDescricao(descricao);
        atividade.setNome(nome);

        return atividade;
    }

    public List<Empresa> findAllPush(Long id) {
        return this.atividadeRepository.findAllPush(id);
    }
}
