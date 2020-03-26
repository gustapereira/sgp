package br.com.ponta.service;

import br.com.ponta.domain.Cargo;
import br.com.ponta.dto.CargoDTO;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.CargoRepository;
import br.com.ponta.util.MensagemConstant;
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

    public CargoDTO salvar(final CargoDTO cargoDTO) {
        return cargoRepository.save(cargoDTO);
    }

    public List<CargoDTO> findAll() {
        return cargoRepository.findAll();
    }

    @Transactional
    public CargoDTO atualizar(CargoDTO cargoDTO) throws OperacaoException {
        if (cargoDTO.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<CargoDTO> optionalCargo = cargoRepository.findById(cargoDTO.getId());
        if (!optionalCargo.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        cargoDTO = atualizaCard(cargoDTO, optionalCargo.get());
        return cargoRepository.save(cargoDTO);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<CargoDTO> optionalCard = cargoRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        cargoRepository.delete(optionalCard.get());
    }

    public CargoDTO atualizaCard(CargoDTO cargoDTO, CargoDTO saved) {

        String nome = cargoDTO.getNome() != null ? cargoDTO.getNome() : saved.getNome();
        String descricao = cargoDTO.getDescricao() != null ? cargoDTO.getDescricao() : saved.getDescricao();

        cargoDTO.setDescricao(descricao);
        cargoDTO.setNome(nome);

        return cargoDTO;
    }

}
