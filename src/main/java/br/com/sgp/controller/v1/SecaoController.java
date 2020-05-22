package br.com.sgp.controller.v1;

import br.com.sgp.domain.Secao;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.dto.SecaoCadastroDTO;
import br.com.sgp.dto.SecaoDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FuncionarioMapper;
import br.com.sgp.mapper.SecaoMapper;
import br.com.sgp.service.SecaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secoes")
@Api(value = "Seção", description = "Operaçôes sobre Seção", tags = "Seção")
@RequiredArgsConstructor
public class SecaoController {


    private final SecaoService secaoService;
    private final SecaoMapper secaoMapper;
    private final FuncionarioMapper funcionarioMapper;

    @PostMapping
    @ApiOperation("Salva um novo Secao")
    public ResponseEntity<SecaoDTO> save(@Validated @RequestBody final SecaoCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(secaoMapper.toDto(secaoService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os Secaos")
    public ResponseEntity<List<SecaoDTO>> list() {
        List<Secao> list = secaoService.listarTodos();
        return ResponseEntity.ok(secaoMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um secao pelo id")
    public ResponseEntity<SecaoDTO> buscarPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(secaoMapper.toDto(secaoService.buscarPeloId(id)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um secao pelo id.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        secaoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar secaos")
    public ResponseEntity<SecaoDTO> editar(@Validated @RequestBody final SecaoDTO secaoDTO) throws OperacaoException {
        return ResponseEntity.ok(secaoMapper.toDto(secaoService.editar(secaoDTO)));
    }

    @PostMapping("/{idSecao}/add-funcionarios")
    @ApiOperation("Adiciona funcionários através do id do secao, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<SecaoDTO> adicionarFuncionarios(@PathVariable("idSecao") Long idSecao, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                secaoMapper.toDto(secaoService.adicionarFuncionarios(idSecao, funcionarioMapper.toEntity(funcionarios)))
        );
    }

    @PostMapping("/{idSecao}/remover-funcionarios")
    @ApiOperation("Remove funcionários através do id do secao, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<SecaoDTO> removerFuncionarios(@PathVariable("idSecao") Long idSecao, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                secaoMapper.toDto(secaoService.removerFuncionarios(idSecao, funcionarioMapper.toEntity(funcionarios)))
        );
    }


}
