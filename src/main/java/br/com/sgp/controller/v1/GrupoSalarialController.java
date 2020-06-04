package br.com.sgp.controller.v1;

import br.com.sgp.domain.GrupoSalarial;
import br.com.sgp.dto.GrupoSalarialDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.GrupoSalarialMapper;
import br.com.sgp.service.GrupoSalarialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos-salariais")
@Api(value = "Grupos Salariais", description = "Operaçôes sobre  Grupos Salariais", tags = "Grupos Salariais")
@RequiredArgsConstructor
public class GrupoSalarialController {


    private final GrupoSalarialService setorService;
    private final GrupoSalarialMapper setorMapper;


    @PostMapping
    @ApiOperation("Salva um novo GrupoSalarial")
    public ResponseEntity<GrupoSalarialDTO> save(@Validated @RequestBody final GrupoSalarialDTO dto) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os GrupoSalarials")
    public ResponseEntity<List<GrupoSalarialDTO>> list() {
        List<GrupoSalarial> list = setorService.listarTodos();
        return ResponseEntity.ok(setorMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um setor pelo id")
    public ResponseEntity<GrupoSalarialDTO> buscarPeloId(@PathVariable("id") Long id) {
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
    public ResponseEntity<GrupoSalarialDTO> editar(@Validated @RequestBody final GrupoSalarialDTO setorDTO) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.editar(setorDTO)));
    }


}
