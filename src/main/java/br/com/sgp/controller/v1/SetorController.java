package br.com.sgp.controller.v1;

import br.com.sgp.domain.Setor;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.dto.SetorCadastroDTO;
import br.com.sgp.dto.SetorDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FuncionarioMapper;
import br.com.sgp.mapper.SetorMapper;
import br.com.sgp.service.SetorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@Api(value = "Setores", description = "Operaçôes sobre Setores", tags = "Setores")
@RequiredArgsConstructor
public class SetorController {


    private final SetorService setorService;
    private final SetorMapper setorMapper;
    private final FuncionarioMapper funcionarioMapper;

    @PostMapping
    @ApiOperation("Salva um novo Setor")
    public ResponseEntity<SetorDTO> save(@Validated @RequestBody final SetorCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os Setors")
    public ResponseEntity<List<SetorDTO>> list() {
        List<Setor> list = setorService.listarTodos();
        return ResponseEntity.ok(setorMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um setor pelo id")
    public ResponseEntity<SetorDTO> buscarPeloId(@PathVariable("id") Long id) {
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
    public ResponseEntity<SetorDTO> editar(@Validated @RequestBody final SetorDTO setorDTO) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.editar(setorDTO)));
    }

    @PostMapping("/{idSetor}/add-funcionarios")
    @ApiOperation("Adiciona funcionários através do id do setor, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<SetorDTO> adicionarFuncionarios(@PathVariable("idSetor") Long idSetor, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                setorMapper.toDto(setorService.adicionarFuncionarios(idSetor, funcionarioMapper.toEntity(funcionarios)))
        );
    }

    @PostMapping("/{idSetor}/remover-funcionarios")
    @ApiOperation("Remove funcionários através do id do setor, e de uma lista de funcionários passada no corpo da requisição.")
    public ResponseEntity<SetorDTO> removerFuncionarios(@PathVariable("idSetor") Long idSetor, @RequestBody List<FuncionarioDTO> funcionarios) {
        return ResponseEntity.ok(
                setorMapper.toDto(setorService.removerFuncionarios(idSetor, funcionarioMapper.toEntity(funcionarios)))
        );
    }


}
