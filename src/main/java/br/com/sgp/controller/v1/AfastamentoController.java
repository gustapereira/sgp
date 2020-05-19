package br.com.sgp.controller.v1;

import br.com.sgp.domain.Afastamento;
import br.com.sgp.dto.AfastamentoDTO;
import br.com.sgp.enums.TypeStatus;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.AfastamentoMapper;
import br.com.sgp.service.AfastamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/afastamento")
@Api(value = "afastamento", description = "Operaçôes sobre afastamento", tags = "Afastamento")
public class AfastamentoController {

    @Autowired
    private AfastamentoService afastamentoService;

    @Autowired
    private AfastamentoMapper afastamentoMapper;

    @PostMapping
    public ResponseEntity<AfastamentoDTO> save(@Validated @RequestBody final AfastamentoDTO afastamentoDTO) throws OperacaoException {
        Afastamento afastamento = afastamentoMapper.toEntity(afastamentoDTO);
        afastamento = afastamentoService.salvar(afastamento);
        return ResponseEntity.ok(afastamentoMapper.toDto(afastamento));
    }


    @GetMapping
    public ResponseEntity<List<AfastamentoDTO>> list() {
        List<Afastamento> list = afastamentoService.findAll();
        return ResponseEntity.ok(afastamentoMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um afastamento.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        afastamentoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar afastamentos")
    public ResponseEntity editarCard(@Validated @RequestBody final AfastamentoDTO afastamentoDTO) throws OperacaoException {
        return ResponseEntity.ok(afastamentoMapper.toDto(afastamentoService.atualizar(afastamentoMapper.toEntity(afastamentoDTO))));
    }



}
