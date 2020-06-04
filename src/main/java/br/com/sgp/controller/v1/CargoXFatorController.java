package br.com.sgp.controller.v1;

import br.com.sgp.domain.CargoXFator;
import br.com.sgp.dto.CargoXFatorCadastroDTO;
import br.com.sgp.dto.CargoXFatorDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.CargoXFatorMapper;
import br.com.sgp.service.CargoXFatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo-fatores")
@Api(value = "Cargo X Fatores", description = "Operaçôes sobre Cargo X Fatores", tags = "Cargo X Fatores")
@RequiredArgsConstructor
public class CargoXFatorController {


    private final CargoXFatorService setorService;
    private final CargoXFatorMapper setorMapper;


    @PostMapping
    @ApiOperation("Salva um novo CargoXFator")
    public ResponseEntity<CargoXFatorDTO> save(@Validated @RequestBody final CargoXFatorCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os CargoXFators")
    public ResponseEntity<List<CargoXFatorDTO>> list() {
        List<CargoXFator> list = setorService.listarTodos();
        return ResponseEntity.ok(setorMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um setor pelo id")
    public ResponseEntity<CargoXFatorDTO> buscarPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(setorMapper.toDto(setorService.buscarPeloId(id)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um setor pelo id.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        setorService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar setors")
    public ResponseEntity<CargoXFatorDTO> editar(@Validated @RequestBody final CargoXFatorDTO setorDTO) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.editar(setorDTO)));
    }


}
