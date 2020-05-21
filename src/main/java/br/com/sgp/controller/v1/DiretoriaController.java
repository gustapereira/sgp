package br.com.sgp.controller.v1;

import br.com.sgp.domain.Diretoria;
import br.com.sgp.dto.DiretoriaCadastroDTO;
import br.com.sgp.dto.DiretoriaDTO;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.DiretoriaMapper;
import br.com.sgp.mapper.FuncionarioMapper;
import br.com.sgp.service.DiretoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/diretorias")
@Api(value = "Diretorias", description = "Operaçôes sobre Diretorias", tags = "Diretorias")
@RequiredArgsConstructor
public class DiretoriaController {


    private final DiretoriaService diretoriaService;
    private final DiretoriaMapper diretoriaMapper;
    private final FuncionarioMapper funcionarioMapper;

    @PostMapping
    @ApiOperation("Salva uma nova Diretoria")
    public ResponseEntity<DiretoriaDTO> save(@Validated @RequestBody final DiretoriaCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(diretoriaMapper.toDto(diretoriaService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos as Diretorias")
    public ResponseEntity<List<DiretoriaDTO>> list() {
        List<Diretoria> list = diretoriaService.listarTodos();
        return ResponseEntity.ok(diretoriaMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca uma diretoria pelo id")
    public ResponseEntity<DiretoriaDTO> buscarPeloId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(diretoriaMapper.toDto(diretoriaService.buscarPeloId(id)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui uma diretoria pelo id.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        diretoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Edita a  diretoria")
    public ResponseEntity<DiretoriaDTO> editar(@Validated @RequestBody final DiretoriaDTO diretoriaDTO) throws OperacaoException {
        return ResponseEntity.ok(diretoriaMapper.toDto(diretoriaService.editar(diretoriaDTO)));
    }

    @PostMapping("/{idDiretoria}/add-funcionarios")
    @ApiOperation("Adiciona funcionários através do id da diretoria, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<DiretoriaDTO> adicionarFuncionarios(@PathVariable("idDiretoria") Long idDiretoria, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                diretoriaMapper.toDto(diretoriaService.adicionarFuncionarios(idDiretoria, funcionarioMapper.toEntity(funcionarios)))
        );
    }

    @PostMapping("/{idDiretoria}/remover-funcionarios")
    @ApiOperation("Remove funcionários através do id da diretoria, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<DiretoriaDTO> removerFuncionarios(@PathVariable("idDiretoria") Long idDiretoria, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                diretoriaMapper.toDto(diretoriaService.removerFuncionarios(idDiretoria, funcionarioMapper.toEntity(funcionarios)))
        );
    }


}
