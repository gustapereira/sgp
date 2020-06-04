package br.com.sgp.controller.v1;

import br.com.sgp.domain.QuadroFuncionario;
import br.com.sgp.dto.QuadroFuncionarioCadastroDTO;
import br.com.sgp.dto.QuadroFuncionarioDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.QuadroFuncionarioMapper;
import br.com.sgp.service.QuadroFuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quadro-funcionarios")
@Api(value = "Quadro de Funcionários", description = "Operaçôes sobre Quadro de Funcionários", tags = "Quadro de Funcionários")
@RequiredArgsConstructor
public class QuadroFuncionarioController {


    private final QuadroFuncionarioService setorService;
    private final QuadroFuncionarioMapper setorMapper;


    @PostMapping
    @ApiOperation("Salva um novo QuadroFuncionario")
    public ResponseEntity<QuadroFuncionarioDTO> save(@Validated @RequestBody final QuadroFuncionarioCadastroDTO dto) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os QuadroFuncionarios")
    public ResponseEntity<List<QuadroFuncionarioDTO>> list() {
        List<QuadroFuncionario> list = setorService.listarTodos();
        return ResponseEntity.ok(setorMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um setor pelo id")
    public ResponseEntity<QuadroFuncionarioDTO> buscarPeloId(@PathVariable("id") Long id) {
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
    public ResponseEntity<QuadroFuncionarioDTO> editar(@Validated @RequestBody final QuadroFuncionarioDTO setorDTO) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.editar(setorDTO)));
    }


}
