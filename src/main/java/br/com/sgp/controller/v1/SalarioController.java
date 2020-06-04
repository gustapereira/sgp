package br.com.sgp.controller.v1;

import br.com.sgp.domain.Salario;
import br.com.sgp.dto.SalarioDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.SalarioMapper;
import br.com.sgp.service.SalarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salarios")
@Api(value = "Salários", description = "Operaçôes sobre  Salários", tags = "Salários")
@RequiredArgsConstructor
public class SalarioController {


    private final SalarioService setorService;
    private final SalarioMapper setorMapper;


    @PostMapping
    @ApiOperation("Salva um novo Salario")
    public ResponseEntity<SalarioDTO> save(@Validated @RequestBody final SalarioDTO dto) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os Salarios")
    public ResponseEntity<List<SalarioDTO>> list() {
        List<Salario> list = setorService.listarTodos();
        return ResponseEntity.ok(setorMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um setor pelo id")
    public ResponseEntity<SalarioDTO> buscarPeloId(@PathVariable("id") Long id) {
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
    public ResponseEntity<SalarioDTO> editar(@Validated @RequestBody final SalarioDTO setorDTO) {
        return ResponseEntity.ok(setorMapper.toDto(setorService.editar(setorDTO)));
    }


}
