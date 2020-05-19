package br.com.sgp.controller.v1;

import br.com.sgp.domain.Cargo;
import br.com.sgp.dto.CargoDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.CargoMapper;
import br.com.sgp.service.CargoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cargo")
@Api(value = "cargo", description = "Operaçôes sobre cargo", tags = "Cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CargoMapper cargoMapper;

    @PostMapping
    public ResponseEntity<CargoDTO> save(@Validated @RequestBody final CargoDTO cargoDTO) throws OperacaoException {
        Cargo cargo = cargoMapper.toEntity(cargoDTO);
        cargo = cargoService.salvar(cargo);
        return ResponseEntity.ok(cargoMapper.toDto(cargo));
    }

    @GetMapping
    public ResponseEntity<List<CargoDTO>> list() {
        List<Cargo> list = cargoService.findAll();
        return ResponseEntity.ok(cargoMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um cargo.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        cargoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar cargos")
    public ResponseEntity editarCard(@Validated @RequestBody final CargoDTO cargoDTO) throws OperacaoException {
        return ResponseEntity.ok(cargoMapper.toDto(cargoService.atualizar(cargoMapper.toEntity(cargoDTO))));
    }



}
