package br.com.sgp.controller.v1;

import br.com.sgp.domain.FolhaDePonto;
import br.com.sgp.dto.FolhaDePontoDTO;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FolhaDePontoMapper;
import br.com.sgp.mapper.FuncionarioMapper;
import br.com.sgp.service.FolhaDePontoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folhas-de-ponto")
@Api(value = "Folhas de Ponto", description = "Operaçôes sobre Folhas de Ponto", tags = "Folhas de Ponto")
@RequiredArgsConstructor
public class FolhaDePontoController {


    private final FolhaDePontoService folhaDePontoService;
    private final FolhaDePontoMapper folhaDePontoMapper;
    private final FuncionarioMapper funcionarioMapper;

    @PostMapping
    @ApiOperation("Salva um novo FolhaDePonto")
    public ResponseEntity<FolhaDePontoDTO> save(@Validated @RequestBody final FolhaDePontoDTO dto) throws OperacaoException {
        return ResponseEntity.ok(folhaDePontoMapper.toDto(folhaDePontoService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os FolhaDePontos")
    public ResponseEntity<List<FolhaDePontoDTO>> list() {
        List<FolhaDePonto> list = folhaDePontoService.listarTodos();
        return ResponseEntity.ok(folhaDePontoMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um folhaDePonto pelo id")
    public ResponseEntity<FolhaDePontoDTO> buscarPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(folhaDePontoMapper.toDto(folhaDePontoService.buscarPeloId(id)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um folhaDePonto pelo id.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        folhaDePontoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar folhaDePontos")
    public ResponseEntity<FolhaDePontoDTO> editar(@Validated @RequestBody final FolhaDePontoDTO folhaDePontoDTO) throws OperacaoException {
        return ResponseEntity.ok(folhaDePontoMapper.toDto(folhaDePontoService.editar(folhaDePontoDTO)));
    }

    @PostMapping("/{idFolhaDePonto}/add-funcionarios")
    @ApiOperation("Adiciona funcionários através do id do folhaDePonto, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<FolhaDePontoDTO> adicionarFuncionarios(@PathVariable("idFolhaDePonto") Long idFolhaDePonto, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                folhaDePontoMapper.toDto(folhaDePontoService.adicionarFuncionarios(idFolhaDePonto, funcionarioMapper.toEntity(funcionarios)))
        );
    }

    @PostMapping("/{idFolhaDePonto}/remover-funcionarios")
    @ApiOperation("Remove funcionários através do id do folhaDePonto, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<FolhaDePontoDTO> removerFuncionarios(@PathVariable("idFolhaDePonto") Long idFolhaDePonto, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                folhaDePontoMapper.toDto(folhaDePontoService.removerFuncionarios(idFolhaDePonto, funcionarioMapper.toEntity(funcionarios)))
        );
    }


}
