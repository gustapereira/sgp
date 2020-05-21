package br.com.sgp.service;

import br.com.sgp.domain.RegistroEletronico;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.RegistroEletronicoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class RegistroEletronicoService {

    private final RegistroEletronicoRepository registroEletronicoRepository;
    private final MessageSource messageSource;

    public RegistroEletronicoService(RegistroEletronicoRepository registroEletronicoRepository, MessageSource messageSource) {
        this.registroEletronicoRepository = registroEletronicoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public RegistroEletronico salvar(final RegistroEletronico registroEletronico) {
        return registroEletronicoRepository.save(registroEletronico);
    }


    public List<RegistroEletronico> findAll() {
        return registroEletronicoRepository.findAll();
    }


    @Transactional
    public RegistroEletronico atualizar(RegistroEletronico registroEletronico) throws OperacaoException {
        if (registroEletronico.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<RegistroEletronico> optionalRegistroEletronico = registroEletronicoRepository.findById(registroEletronico.getId());
        if (!optionalRegistroEletronico.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        registroEletronico = atualizaCard(registroEletronico, optionalRegistroEletronico.get());
        return registroEletronicoRepository.save(registroEletronico);
    }


    public RegistroEletronico atualizaCard(RegistroEletronico registroEletronico, RegistroEletronico saved) {

        String nome = registroEletronico.getNome() != null ? registroEletronico.getNome() : saved.getNome();
        String tipo = registroEletronico.getTipo() != null ? registroEletronico.getNome() : saved.getNome();

        registroEletronico.setNome(nome);
        registroEletronico.setTipo(tipo);

        return registroEletronico;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<RegistroEletronico> optionalCard = registroEletronicoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        registroEletronicoRepository.delete(optionalCard.get());
    }

}
