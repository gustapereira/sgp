package br.com.ponta.controller.v1;

import br.com.ponta.exception.OperacaoException;
import br.com.ponta.service.IndicadorService;
import br.com.sebrae.ponta.dto.IndicadorDTO;
import br.com.sebrae.ponta.dto.IndicadorUsuarioDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indicadores")
@Api("Endpoint de indicadores")
public class EmpresaController {

    @Autowired
    private IndicadorService indicadorService;

    @PostMapping
    @ApiOperation("Salvar Indicador.")
    public ResponseEntity<IndicadorDTO> save(@Validated @RequestBody final IndicadorDTO dto) throws OperacaoException {
        return ResponseEntity.ok(indicadorService.salvar(dto));
    }

    @PutMapping
    @ApiOperation("Editar Indicador.")
    public ResponseEntity<IndicadorDTO> editar(@Validated @RequestBody final IndicadorDTO dto) throws OperacaoException {
        return ResponseEntity.ok(indicadorService.editar(dto));
    }

    @GetMapping
    @ApiOperation("Lista todos os Indicadores")
    public ResponseEntity<List<IndicadorDTO>> listar() {
        return ResponseEntity.ok(indicadorService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Lista o Indicador Pelo ID ")
    public ResponseEntity<IndicadorDTO> buscarPeloId(@PathVariable(value = "id") Long id) throws OperacaoException {
        return ResponseEntity.ok(indicadorService.buscarPeloId(id).get());
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) throws OperacaoException {
        indicadorService.deletarPeloId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("associar/usuario")
    @ApiOperation("Associa um usuário a um indicador.")
    public ResponseEntity<IndicadorDTO> associar(@Validated @RequestBody IndicadorUsuarioDTO dto) throws OperacaoException {
        return ResponseEntity.ok(indicadorService.associar(dto));
    }

    @PutMapping("desassociar/usuario")
    @ApiOperation("Desassocia um usuário de um indicador.")
    public ResponseEntity<IndicadorDTO> desassociar(@Validated @RequestBody IndicadorUsuarioDTO dto) throws OperacaoException {
        return ResponseEntity.ok(indicadorService.desassociar(dto));
    }

}
