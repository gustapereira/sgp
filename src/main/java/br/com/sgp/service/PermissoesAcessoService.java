package br.com.sgp.service;

import br.com.sgp.domain.PermissoesAcesso;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.PermissoesAcessoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class PermissoesAcessoService {

    private final PermissoesAcessoRepository permissoesAcessoRepository;
    private final MessageSource messageSource;

    public PermissoesAcessoService(PermissoesAcessoRepository permissoesAcessoRepository, MessageSource messageSource) {
        this.permissoesAcessoRepository = permissoesAcessoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public PermissoesAcesso salvar(final PermissoesAcesso permissoesAcesso) {
        return permissoesAcessoRepository.save(permissoesAcesso);
    }


    public List<PermissoesAcesso> findAll() {
        return permissoesAcessoRepository.findAll();
    }


    @Transactional
    public PermissoesAcesso atualizar(PermissoesAcesso permissoesAcesso) throws OperacaoException {
        if (permissoesAcesso.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<PermissoesAcesso> optionalPermissoesAcesso = permissoesAcessoRepository.findById(permissoesAcesso.getId());
        if (!optionalPermissoesAcesso.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        permissoesAcesso = atualizaCard(permissoesAcesso, optionalPermissoesAcesso.get());
        return permissoesAcessoRepository.save(permissoesAcesso);
    }


    public PermissoesAcesso atualizaCard(PermissoesAcesso permissoesAcesso, PermissoesAcesso saved) {

        String nome = permissoesAcesso.getNome() != null ? permissoesAcesso.getNome() : saved.getNome();

        permissoesAcesso.setNome(nome);

        return permissoesAcesso;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<PermissoesAcesso> optionalCard = permissoesAcessoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        permissoesAcessoRepository.delete(optionalCard.get());
    }

}
