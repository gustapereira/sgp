package br.com.sgp.controller.v1;

import br.com.sgp.domain.Ferias;
import br.com.sgp.dto.FeriasDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.FeriasMapper;
import br.com.sgp.service.FeriasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ferias")
@Api(value = "ferias", description = "Operaçôes sobre ferias", tags = "Ferias")
public class FeriasController {

    @Autowired
    private FeriasService feriasService;

    @Autowired
    private FeriasMapper feriasMapper;

    @PostMapping
    public ResponseEntity<FeriasDTO> save(@Validated @RequestBody final FeriasDTO feriasDTO) throws OperacaoException {
        Ferias ferias = feriasMapper.toEntity(feriasDTO);
        ferias = feriasService.salvar(ferias);
        return ResponseEntity.ok(feriasMapper.toDto(ferias));
    }


    @GetMapping
    public ResponseEntity<List<FeriasDTO>> list() {
        List<Ferias> list = feriasService.findAll();
        return ResponseEntity.ok(feriasMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um ferias.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        feriasService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar feriass")
    public ResponseEntity editarCard(@Validated @RequestBody final FeriasDTO feriasDTO) throws OperacaoException {
        return ResponseEntity.ok(feriasMapper.toDto(feriasService.atualizar(feriasMapper.toEntity(feriasDTO))));
    }



}
