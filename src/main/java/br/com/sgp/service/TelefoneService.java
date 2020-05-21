package br.com.sgp.service;

import br.com.sgp.domain.Telefone;
import br.com.sgp.enums.TypePhone;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.TelefoneRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;
    private final MessageSource messageSource;

    public TelefoneService(TelefoneRepository telefoneRepository, MessageSource messageSource) {
        this.telefoneRepository = telefoneRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public Telefone salvar(final Telefone telefone) {
        return telefoneRepository.save(telefone);
    }


    public List<Telefone> findAll() {
        return telefoneRepository.findAll();
    }


    @Transactional
    public Telefone atualizar(Telefone telefone) throws OperacaoException {
        if (telefone.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<Telefone> optionalTelefone = telefoneRepository.findById(telefone.getId());
        if (!optionalTelefone.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        telefone = atualizaCard(telefone, optionalTelefone.get());
        return telefoneRepository.save(telefone);
    }


    public Telefone atualizaCard(Telefone telefone, Telefone saved) {

        String numero = telefone.getNumero() != null ? telefone.getNumero() : saved.getNumero();
        TypePhone typePhone = telefone.getTipoPhone() != null ? telefone.getTipoPhone() : saved.getTipoPhone();

        telefone.setNumero(numero);
        telefone.setNumero(numero);

        return telefone;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<Telefone> optionalCard = telefoneRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        telefoneRepository.delete(optionalCard.get());
    }

}
