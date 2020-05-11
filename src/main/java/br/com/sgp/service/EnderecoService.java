package br.com.sgp.service;

import br.com.sgp.domain.UF;
import br.com.sgp.dto.EnderecoDTO;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.EnderecoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final MessageSource messageSource;

    public EnderecoService(EnderecoRepository enderecoRepository, MessageSource messageSource) {
        this.enderecoRepository = enderecoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public EnderecoDTO salvar(final EnderecoDTO endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<EnderecoDTO> findAll() {
        return enderecoRepository.findAll();
    }

    @Transactional
    public EnderecoDTO atualizar(EnderecoDTO endereco) throws OperacaoException {
        if (endereco.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<EnderecoDTO> optionalEndereco = enderecoRepository.findById(endereco.getId());
        if (!optionalEndereco.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        endereco = atualizaCard(endereco, optionalEndereco.get());
        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<EnderecoDTO> optionalCard = enderecoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        enderecoRepository.delete(optionalCard.get());
    }

    public EnderecoDTO atualizaCard(EnderecoDTO endereco, EnderecoDTO saved) {

        String bairro = endereco.getBairro() != null ? endereco.getBairro() : saved.getBairro();
        String cep = endereco.getCep() != null ? endereco.getCep() : saved.getCep();
        String cidade = endereco.getCidade() != null ? endereco.getCidade() : saved.getCidade();
        String complemento = endereco.getComplemento() != null ? endereco.getComplemento() : saved.getComplemento();
        String logradouro = endereco.getLogradouro() != null ? endereco.getLogradouro() : saved.getLogradouro();
        String numero = endereco.getNumero() != null ? endereco.getNumero() : saved.getNumero();
        UF uf = endereco.getUf() != null ? endereco.getUf() : saved.getUf();

        endereco.setBairro(bairro);
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setComplemento(complemento);
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setUf(uf);

        return endereco;
    }

}
