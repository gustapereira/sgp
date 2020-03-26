package br.com.ponta.service;

import br.com.ponta.dto.CentroCustoDTO;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.CentroCustoRepository;
import br.com.ponta.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class CentroCustoService {

    private final CentroCustoRepository centroCustoRepository;
    private final MessageSource messageSource;

    public CentroCustoService(CentroCustoRepository centroCustoRepository, MessageSource messageSource) {
        this.centroCustoRepository = centroCustoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public CentroCustoDTO salvar(final CentroCustoDTO centroCustoDTO) {
        return centroCustoRepository.save(centroCustoDTO);
    }

    public List<CentroCustoDTO> findAll() {
        return centroCustoRepository.findAll();
    }

    @Transactional
    public CentroCustoDTO atualizar(CentroCustoDTO centroCustoDTO) throws OperacaoException {
        if (centroCustoDTO.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<CentroCustoDTO> optionalCentroCusto = centroCustoRepository.findById(centroCustoDTO.getId());
        if (!optionalCentroCusto.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        centroCustoDTO = atualizaCard(centroCustoDTO, optionalCentroCusto.get());
        return centroCustoRepository.save(centroCustoDTO);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<CentroCustoDTO> optionalCard = centroCustoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        centroCustoRepository.delete(optionalCard.get());
    }

    public CentroCustoDTO atualizaCard(CentroCustoDTO centroCustoDTO, CentroCustoDTO saved) {

        String nome = centroCustoDTO.getNome() != null ? centroCustoDTO.getNome() : saved.getNome();
        String descricao = centroCustoDTO.getDescricao() != null ? centroCustoDTO.getDescricao() : saved.getDescricao();

        centroCustoDTO.setDescricao(descricao);
        centroCustoDTO.setNome(nome);

        return centroCustoDTO;
    }

}
