package br.com.sgp.controller.v1;

import br.com.sgp.domain.Departamento;
import br.com.sgp.dto.DepartamentoCadastroDTO;
import br.com.sgp.dto.DepartamentoDTO;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.DepartamentoMapper;
import br.com.sgp.mapper.FuncionarioMapper;
import br.com.sgp.service.DepartamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departamentos")
@Api(value = "Departamentos", description = "Operaçôes sobre Departamentos", tags = "Departamentos")
@RequiredArgsConstructor
public class DepartamentoController {


    private final DepartamentoService departamentoService;
    private final DepartamentoMapper departamentoMapper;
    private final FuncionarioMapper funcionarioMapper;

    @PostMapping
    @ApiOperation("Salva um novo Departamento")
    public ResponseEntity<DepartamentoDTO> save(@Validated @RequestBody final DepartamentoCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(departamentoMapper.toDto(departamentoService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os Departamentos")
    public ResponseEntity<List<DepartamentoDTO>> list() {
        List<Departamento> list = departamentoService.listarTodos();
        return ResponseEntity.ok(departamentoMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um departamento pelo id")
    public ResponseEntity<DepartamentoDTO> buscarPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departamentoMapper.toDto(departamentoService.buscarPeloId(id)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um departamento pelo id.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        departamentoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar departamentos")
    public ResponseEntity<DepartamentoDTO> editar(@Validated @RequestBody final DepartamentoDTO departamentoDTO) throws OperacaoException {
        return ResponseEntity.ok(departamentoMapper.toDto(departamentoService.editar(departamentoDTO)));
    }

    @PostMapping("/{idDepartamento}/add-funcionarios")
    @ApiOperation("Adiciona funcionários através do id da empresa, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<DepartamentoDTO> adicionarFuncionarios(@PathVariable("idDepartamento") Long idDepartamento, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                departamentoMapper.toDto(departamentoService.adicionarFuncionarios(idDepartamento, funcionarioMapper.toEntity(funcionarios)))
        );
    }

    @PostMapping("/{idDepartamento}/remover-funcionarios")
    @ApiOperation("Remove funcionários através do id da empresa, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<DepartamentoDTO> removerFuncionarios(@PathVariable("idDepartamento") Long idDepartamento, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                departamentoMapper.toDto(departamentoService.removerFuncionarios(idDepartamento, funcionarioMapper.toEntity(funcionarios)))
        );
    }


}
