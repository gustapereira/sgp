package br.com.sgp.service;

import br.com.sgp.domain.CargoXFator;
import br.com.sgp.dto.CargoXFatorCadastroDTO;
import br.com.sgp.dto.CargoXFatorDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.CargoXFatorCadastroMapper;
import br.com.sgp.repository.CargoXFatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CargoXFatorService {

    private final CargoXFatorRepository repository;
    private final CargoXFatorCadastroMapper cadastroMapper;
    private final FatorService fatorService;
    private final FaixaFatorService faixaFatorService;
    private final CargoService cargoService;


    public List<CargoXFator> listarTodos() {
        return repository.findAll();
    }

    public CargoXFator buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Salário não localizado pelo id: " + id)
        );
    }

    public CargoXFator salvar(CargoXFatorCadastroDTO dto) {
        CargoXFator cargoXFator = cadastroMapper.toEntity(dto);
        cargoXFator.setFator(fatorService.buscarPeloId(dto.getIdFator()));
        cargoXFator.setFaixaFator(faixaFatorService.buscarPeloId(dto.getIdFaixaFator()));
        cargoXFator.setCargo(cargoService.buscarPeloId(dto.getIdFator()));
        return repository.save(cargoXFator);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public CargoXFator editar(CargoXFatorDTO dto) {
        return repository.save(atualizarDados(buscarPeloId(dto.getId()), dto));
    }


    private CargoXFator atualizarDados(CargoXFator cargoXFator, CargoXFatorDTO dto) {
        cargoXFator.setDescricao(dto.getDescricao() != null ? dto.getDescricao() : cargoXFator.getDescricao());
        cargoXFator.setCargo(dto.getCargo() != null ? dto.getCargo() : cargoXFator.getCargo());
        cargoXFator.setFaixaFator(dto.getFaixaFator() != null ? dto.getFaixaFator() : cargoXFator.getFaixaFator());
        cargoXFator.setFator(dto.getFator() != null ? dto.getFator() : cargoXFator.getFator());
        return cargoXFator;
    }


}
