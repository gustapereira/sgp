package br.com.sgp.controller.v1;

import br.com.sgp.dto.FuncionarioCadastroDTO;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FuncionarioMapper;
import br.com.sgp.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionarios")
@Api(value = "funcionario", description = "Operaçôes sobre funcionario", tags = "Funcionários")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;
    private final FuncionarioMapper mapper;

    @PostMapping
    @ApiOperation("Salva um novo Funcionário")
    public ResponseEntity<FuncionarioDTO> save(@Validated @RequestBody final FuncionarioCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(mapper.toDto(service.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os Funcionários")
    public ResponseEntity<List<FuncionarioDTO>> list() {
        return ResponseEntity.ok(mapper.toDto(service.listarTodos()));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Endpoint para excluir um funcionario.")
    public ResponseEntity deletar(@PathVariable("id") Long id) throws OperacaoException {
        service.deletarPeloId(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @ApiOperation("Endpoint para excluir um funcionario.")
    public ResponseEntity<FuncionarioDTO> buscarPeloId(@PathVariable("id") Long id) throws OperacaoException {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloId(id)));
    }

    @PutMapping
    @ApiOperation("Editar funcionarios")
    public ResponseEntity<FuncionarioDTO> editar(@Validated @RequestBody final FuncionarioDTO dto) throws OperacaoException {
        return ResponseEntity.ok(mapper.toDto(service.editar(dto)));
    }

}
