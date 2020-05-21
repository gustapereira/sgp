package br.com.sgp.controller.v1;

import br.com.sgp.domain.HierarquiaExterna;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.dto.HierarquiaExternaCadastroDTO;
import br.com.sgp.dto.HierarquiaExternaDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FuncionarioMapper;
import br.com.sgp.mapper.HierarquiaExternaMapper;
import br.com.sgp.service.HierarquiaExternaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hierarquias")
@Api(value = "Hierarquias", description = "Operaçôes sobre Hierarquias", tags = "Hierarquias")
@RequiredArgsConstructor
public class HierarquiaExternaController {


    private final HierarquiaExternaService hierarquiaExternaService;
    private final HierarquiaExternaMapper hierarquiaExternaMapper;
    private final FuncionarioMapper funcionarioMapper;

    @PostMapping
    @ApiOperation("Salva um novo HierarquiaExterna")
    public ResponseEntity<HierarquiaExternaDTO> save(@Validated @RequestBody final HierarquiaExternaCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(hierarquiaExternaMapper.toDto(hierarquiaExternaService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os HierarquiaExternas")
    public ResponseEntity<List<HierarquiaExternaDTO>> list() {
        List<HierarquiaExterna> list = hierarquiaExternaService.listarTodos();
        return ResponseEntity.ok(hierarquiaExternaMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um hierarquiaExterna pelo id")
    public ResponseEntity<HierarquiaExternaDTO> buscarPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(hierarquiaExternaMapper.toDto(hierarquiaExternaService.buscarPeloId(id)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um hierarquiaExterna pelo id.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        hierarquiaExternaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar hierarquiaExternas")
    public ResponseEntity<HierarquiaExternaDTO> editar(@Validated @RequestBody final HierarquiaExternaDTO hierarquiaExternaDTO) throws OperacaoException {
        return ResponseEntity.ok(hierarquiaExternaMapper.toDto(hierarquiaExternaService.editar(hierarquiaExternaDTO)));
    }

    @PostMapping("/{idHierarquiaExterna}/add-funcionarios")
    @ApiOperation("Adiciona funcionários através do id do hierarquiaExterna, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<HierarquiaExternaDTO> adicionarFuncionarios(@PathVariable("idHierarquiaExterna") Long idHierarquiaExterna, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                hierarquiaExternaMapper.toDto(hierarquiaExternaService.adicionarFuncionarios(idHierarquiaExterna, funcionarioMapper.toEntity(funcionarios)))
        );
    }

    @PostMapping("/{idHierarquiaExterna}/remover-funcionarios")
    @ApiOperation("Remove funcionários através do id do hierarquiaExterna, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<HierarquiaExternaDTO> removerFuncionarios(@PathVariable("idHierarquiaExterna") Long idHierarquiaExterna, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                hierarquiaExternaMapper.toDto(hierarquiaExternaService.removerFuncionarios(idHierarquiaExterna, funcionarioMapper.toEntity(funcionarios)))
        );
    }


}
