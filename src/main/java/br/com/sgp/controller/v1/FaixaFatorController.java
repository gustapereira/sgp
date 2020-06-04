package br.com.sgp.controller.v1;

import br.com.sgp.domain.FaixaFator;
import br.com.sgp.dto.FaixaFatorDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FaixaFatorMapper;
import br.com.sgp.service.FaixaFatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faixa-fatores")
@Api(value = "Faixa de Fatores", description = "Operaçôes sobre Faixa de Fatores", tags = "Faixa de Fatores")
@RequiredArgsConstructor
public class FaixaFatorController {


    private final FaixaFatorService setorService;
    private final FaixaFatorMapper setorMapper;


    @PostMapping
    @ApiOperation("Salva um novo FaixaFator")
    public ResponseEntity<FaixaFatorDTO> save(@Validated @RequestBody final FaixaFatorDTO dto) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todos os FaixaFators")
    public ResponseEntity<List<FaixaFatorDTO>> list() {
        List<FaixaFator> list = setorService.listarTodos();
        return ResponseEntity.ok(setorMapper.toDto(list));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um setor pelo id")
    public ResponseEntity<FaixaFatorDTO> buscarPeloId(@PathVariable("id") Long id) {
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
    public ResponseEntity<FaixaFatorDTO> editar(@Validated @RequestBody final FaixaFatorDTO setorDTO) throws OperacaoException {
        return ResponseEntity.ok(setorMapper.toDto(setorService.editar(setorDTO)));
    }


}
