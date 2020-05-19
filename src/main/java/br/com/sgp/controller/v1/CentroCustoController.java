package br.com.sgp.controller.v1;

import br.com.sgp.dto.CentroCustoDTO;
import br.com.sgp.dto.CentroCustoFuncionarioDTO;
import br.com.sgp.mapper.CentroCustoFuncionarioMapper;
import br.com.sgp.mapper.CentroCustoMapper;
import br.com.sgp.service.CentroCustoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centroCusto")
@Api(value = "centroCusto", description = "Operaçôes sobre CentroCustos", tags = "CentroCustos")
@RequiredArgsConstructor
public class CentroCustoController {

    private final CentroCustoService centroCustoService;
    private final CentroCustoMapper centroCustoMapper;
    private final CentroCustoFuncionarioMapper centroCustoFuncionarioMapper;

    @PostMapping
    @ApiOperation("Salvar CentroCusto.")
    public ResponseEntity<CentroCustoDTO> save(@Validated @RequestBody CentroCustoFuncionarioDTO dto) {
        return ResponseEntity.ok(centroCustoMapper.toDto(centroCustoService.salvar(dto)));
    }

    @PutMapping
    @ApiOperation("Editar CentroCusto.")
    public ResponseEntity<CentroCustoDTO> editar(@Validated @RequestBody final CentroCustoFuncionarioDTO dto) {
        return ResponseEntity.ok(centroCustoMapper.toDto(centroCustoService.editar(dto)));
    }


    @GetMapping
    @ApiOperation("Lista todos os CentroCustos")
    public ResponseEntity<List<CentroCustoFuncionarioDTO>> listar() {
        return ResponseEntity.ok(centroCustoFuncionarioMapper.toDto(centroCustoService.listarTudo()));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) {
        centroCustoService.deletarPeloId(id);
        return ResponseEntity.noContent().build();
    }
}
