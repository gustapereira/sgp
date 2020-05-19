package br.com.sgp.controller.v1;

import br.com.sgp.domain.CBO;
import br.com.sgp.dto.CBODTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.CBOMapper;
import br.com.sgp.service.CBOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cbo")
@Api(value = "cbo", description = "Operaçôes sobre cbo", tags = "CBO")
public class CBOController {

    @Autowired
    private CBOService cboService;

    @Autowired
    private CBOMapper cboMapper;

    @PostMapping
    public ResponseEntity<CBODTO> save(@Validated @RequestBody final CBODTO cboDTO) throws OperacaoException {
        CBO cbo = cboMapper.toEntity(cboDTO);
        cbo = cboService.salvar(cbo);
        return ResponseEntity.ok(cboMapper.toDto(cbo));
    }


    @GetMapping
    public ResponseEntity<List<CBODTO>> list() {
        List<CBO> list = cboService.findAll();
        return ResponseEntity.ok(cboMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um cbo.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        cboService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar cbos")
    public ResponseEntity editarCard(@Validated @RequestBody final CBODTO cboDTO) throws OperacaoException {
        return ResponseEntity.ok(cboMapper.toDto(cboService.atualizar(cboMapper.toEntity(cboDTO))));
    }



}
