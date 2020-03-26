package br.com.ponta.controller.v1;

import br.com.ponta.domain.Cargo;
import br.com.ponta.dto.CargoDTO;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.service.CargoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargoes")
@Api("Endpoint de cargoes")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping
    @ApiOperation("Salvar Cargo.")
    public ResponseEntity<CargoDTO> save(@Validated @RequestBody final CargoDTO cargoDTO) throws OperacaoException {
        return ResponseEntity.ok(cargoService.salvar(cargoDTO));
    }

    @PutMapping
    @ApiOperation("Editar Cargo.")
    public ResponseEntity<CargoDTO> editar(@Validated @RequestBody final CargoDTO cargoDTO) throws OperacaoException {
        return ResponseEntity.ok(cargoService.atualizar(cargoDTO));
    }

    @GetMapping
    @ApiOperation("Lista todos os Cargoes")
    public ResponseEntity<List<CargoDTO>> listar() {
        return ResponseEntity.ok(cargoService.findAll());
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) throws OperacaoException {
        cargoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
