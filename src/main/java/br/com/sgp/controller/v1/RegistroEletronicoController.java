package br.com.sgp.controller.v1;

import br.com.sgp.domain.RegistroEletronico;
import br.com.sgp.dto.RegistroEletronicoDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.RegistroEletronicoMapper;
import br.com.sgp.service.RegistroEletronicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/registroEletronico")
@Api(value = "registroEletronico", description = "Operaçôes sobre registroEletronico", tags = "RegistroEletronico")
public class RegistroEletronicoController {

    @Autowired
    private RegistroEletronicoService registroEletronicoService;

    @Autowired
    private RegistroEletronicoMapper registroEletronicoMapper;

    @PostMapping
    public ResponseEntity<RegistroEletronicoDTO> save(@Validated @RequestBody final RegistroEletronicoDTO registroEletronicoDTO) throws OperacaoException {
        RegistroEletronico registroEletronico = registroEletronicoMapper.toEntity(registroEletronicoDTO);
        registroEletronico = registroEletronicoService.salvar(registroEletronico);
        return ResponseEntity.ok(registroEletronicoMapper.toDto(registroEletronico));
    }


    @GetMapping
    public ResponseEntity<List<RegistroEletronicoDTO>> list() {
        List<RegistroEletronico> list = registroEletronicoService.findAll();
        return ResponseEntity.ok(registroEletronicoMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um registroEletronico.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        registroEletronicoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar registroEletronicos")
    public ResponseEntity editarCard(@Validated @RequestBody final RegistroEletronicoDTO registroEletronicoDTO) throws OperacaoException {
        return ResponseEntity.ok(registroEletronicoMapper.toDto(registroEletronicoService.atualizar(registroEletronicoMapper.toEntity(registroEletronicoDTO))));
    }



}
