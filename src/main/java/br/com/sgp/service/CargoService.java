package br.com.sgp.service;

import br.com.sgp.domain.Cargo;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.CargoRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class CargoService {

    private final CargoRepository cargoRepository;
    private final MessageSource messageSource;

    public CargoService(CargoRepository cargoRepository, MessageSource messageSource) {
        this.cargoRepository = cargoRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public Cargo salvar(final Cargo cargo) {
        return cargoRepository.save(cargo);
    }


    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }


    @Transactional
    public Cargo atualizar(Cargo cargo) throws OperacaoException {
        if (cargo.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<Cargo> optionalCargo = cargoRepository.findById(cargo.getId());
        if (!optionalCargo.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        cargo = atualizaCard(cargo, optionalCargo.get());
        return cargoRepository.save(cargo);
    }


    public Cargo atualizaCard(Cargo cargo, Cargo saved) {

        String descricao = cargo.getDescricao() != null ? cargo.getDescricao() : saved.getDescricao();
        String nome = cargo.getNome() != null ? cargo.getNome() : saved.getNome();

        cargo.setDescricao(descricao);
        cargo.setNome(nome);

        return cargo;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<Cargo> optionalCard = cargoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        cargoRepository.delete(optionalCard.get());
    }

    public Cargo buscarPeloId(Long id) {
        return cargoRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Salário não localizado pelo id: " + id)
        );
    }

}
