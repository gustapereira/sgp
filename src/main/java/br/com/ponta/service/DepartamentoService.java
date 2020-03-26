package br.com.ponta.service;

import br.com.ponta.dto.DepartamentoDTO;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.DepartamentoRepository;
import br.com.ponta.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final MessageSource messageSource;

    public DepartamentoService(DepartamentoRepository departamentoRepository, MessageSource messageSource) {
        this.departamentoRepository = departamentoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public DepartamentoDTO salvar(final DepartamentoDTO departamentoDTO) {
        return departamentoRepository.save(departamentoDTO);
    }

    public List<DepartamentoDTO> findAll() {
        return departamentoRepository.findAll();
    }

    @Transactional
    public DepartamentoDTO atualizar(DepartamentoDTO departamentoDTO) throws OperacaoException {
        if (departamentoDTO.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<DepartamentoDTO> optionalDepartamento = departamentoRepository.findById(departamentoDTO.getId());
        if (!optionalDepartamento.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        departamentoDTO = atualizaCard(departamentoDTO, optionalDepartamento.get());
        return departamentoRepository.save(departamentoDTO);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<DepartamentoDTO> optionalCard = departamentoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        departamentoRepository.delete(optionalCard.get());
    }

    public DepartamentoDTO atualizaCard(DepartamentoDTO departamentoDTO, DepartamentoDTO saved) {

        String nome = departamentoDTO.getNome() != null ? departamentoDTO.getNome() : saved.getNome();
        String descricao = departamentoDTO.getDescricao() != null ? departamentoDTO.getDescricao() : saved.getDescricao();

        departamentoDTO.setDescricao(descricao);
        departamentoDTO.setNome(nome);

        return departamentoDTO;
    }

}
