package br.com.sgp.controller.v1;

import br.com.sgp.domain.Telefone;
import br.com.sgp.dto.TelefoneDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.TelefoneMapper;
import br.com.sgp.service.TelefoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/telefone")
@Api(value = "telefone", description = "Operaçôes sobre telefone", tags = "Telefone")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private TelefoneMapper telefoneMapper;

    @PostMapping
    public ResponseEntity<TelefoneDTO> save(@Validated @RequestBody final TelefoneDTO telefoneDTO) throws OperacaoException {
        Telefone telefone = telefoneMapper.toEntity(telefoneDTO);
        telefone = telefoneService.salvar(telefone);
        return ResponseEntity.ok(telefoneMapper.toDto(telefone));
    }


    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> list() {
        List<Telefone> list = telefoneService.findAll();
        return ResponseEntity.ok(telefoneMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um telefone.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        telefoneService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar telefones")
    public ResponseEntity editarCard(@Validated @RequestBody final TelefoneDTO telefoneDTO) throws OperacaoException {
        return ResponseEntity.ok(telefoneMapper.toDto(telefoneService.atualizar(telefoneMapper.toEntity(telefoneDTO))));
    }



}
