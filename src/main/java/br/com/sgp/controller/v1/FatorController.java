package br.com.sgp.controller.v1;

import br.com.sgp.domain.Fator;
import br.com.sgp.dto.FatorDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FatorMapper;
import br.com.sgp.service.FatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatores")
@Api(value = "Fatores", description = "Operaçôes sobre  Fatores", tags = "Fatores")
@RequiredArgsConstructor
public class FatorController {


    private final FatorService setorService;
    private final FatorMapper setorMapper;


    @PostMapping
    @ApiOperation("Salva um novo Fator")
    public ResponseEntity<FatorDTO> save(@Validated @RequestBody final FatorDTO dto) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os Fators")
    public ResponseEntity<List<FatorDTO>> list() {
        List<Fator> list = setorService.listarTodos();
        return ResponseEntity.ok(setorMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um setor pelo id")
    public ResponseEntity<FatorDTO> buscarPeloId(@PathVariable("id") Long id) {
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
    public ResponseEntity<FatorDTO> editar(@Validated @RequestBody final FatorDTO setorDTO) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.editar(setorDTO)));
    }


}
