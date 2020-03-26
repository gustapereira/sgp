package br.com.ponta.controller.v1;

import br.com.ponta.dto.CentroCustoDTO;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.service.CentroCustoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centroCustoes")
@Api("Endpoint de centroCustoes")
public class CentroCustoController {

    @Autowired
    private CentroCustoService centroCustoService;

    @PostMapping
    @ApiOperation("Salvar CentroCusto.")
    public ResponseEntity<CentroCustoDTO> save(@Validated @RequestBody final CentroCustoDTO centroCustoDTO) throws OperacaoException {
        return ResponseEntity.ok(centroCustoService.salvar(centroCustoDTO));
    }

    @PutMapping
    @ApiOperation("Editar CentroCusto.")
    public ResponseEntity<CentroCustoDTO> editar(@Validated @RequestBody final CentroCustoDTO centroCustoDTO) throws OperacaoException {
        return ResponseEntity.ok(centroCustoService.atualizar(centroCustoDTO));
    }

    @GetMapping
    @ApiOperation("Lista todos os CentroCustoes")
    public ResponseEntity<List<CentroCustoDTO>> listar() {
        return ResponseEntity.ok(centroCustoService.findAll());
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) throws OperacaoException {
        centroCustoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
