package br.com.ponta.service;

import br.com.ponta.domain.Departamento;
import br.com.ponta.domain.Setor;
import br.com.ponta.domain.Setor;
import br.com.ponta.dto.SetorDTO;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.SetorRepository;
import br.com.ponta.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class SetorService {

    private final SetorRepository setorRepository;
    private final MessageSource messageSource;

    public SetorService(SetorRepository setorRepository, MessageSource messageSource) {
        this.setorRepository = setorRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public SetorDTO salvar(final SetorDTO setor) {
        return setorRepository.save(setor);
    }

    public List<SetorDTO> findAll() {
        return setorRepository.findAll();
    }

    @Transactional
    public SetorDTO atualizar(SetorDTO setor) throws OperacaoException {
        if (setor.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<SetorDTO> optionalSetor = setorRepository.findById(setor.getId());
        if (!optionalSetor.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        setor = atualizaCard(setor, optionalSetor.get());
        return setorRepository.save(setor);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<SetorDTO> optionalCard = setorRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        setorRepository.delete(optionalCard.get());
    }

    public SetorDTO atualizaCard(SetorDTO setor, SetorDTO saved) {

        String nome = setor.getNome() != null ? setor.getNome() : saved.getNome();
        String descricao = setor.getDescricao() != null ? setor.getDescricao() : saved.getDescricao();
        Departamento departamento = setor.getDepartamento() != null ? setor.getDepartamento() : saved.getDepartamento();

        setor.setNome(nome);
        setor.setDescricao(descricao);
        setor.setDepartamento(departamento);

        return setor;
    }

}
