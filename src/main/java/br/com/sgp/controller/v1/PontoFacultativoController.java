package br.com.sgp.controller.v1;

import br.com.sgp.domain.PontoFacultativo;
import br.com.sgp.dto.PontoFacultativoDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.PontoFacultativoMapper;
import br.com.sgp.service.PontoFacultativoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pontoFacultativo")
@Api(value = "pontoFacultativo", description = "Operaçôes sobre pontoFacultativo", tags = "PontoFacultativo")
public class PontoFacultativoController {

    @Autowired
    private PontoFacultativoService pontoFacultativoService;

    @Autowired
    private PontoFacultativoMapper pontoFacultativoMapper;

    @PostMapping
    public ResponseEntity<PontoFacultativoDTO> save(@Validated @RequestBody final PontoFacultativoDTO pontoFacultativoDTO) throws OperacaoException {
        PontoFacultativo pontoFacultativo = pontoFacultativoMapper.toEntity(pontoFacultativoDTO);
        pontoFacultativo = pontoFacultativoService.salvar(pontoFacultativo);
        return ResponseEntity.ok(pontoFacultativoMapper.toDto(pontoFacultativo));
    }


    @GetMapping
    public ResponseEntity<List<PontoFacultativoDTO>> list() {
        List<PontoFacultativo> list = pontoFacultativoService.findAll();
        return ResponseEntity.ok(pontoFacultativoMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um pontoFacultativo.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        pontoFacultativoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar pontoFacultativos")
    public ResponseEntity editarCard(@Validated @RequestBody final PontoFacultativoDTO pontoFacultativoDTO) throws OperacaoException {
        return ResponseEntity.ok(pontoFacultativoMapper.toDto(pontoFacultativoService.atualizar(pontoFacultativoMapper.toEntity(pontoFacultativoDTO))));
    }



}
