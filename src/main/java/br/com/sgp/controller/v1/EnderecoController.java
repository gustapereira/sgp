package br.com.sgp.controller.v1;

import br.com.sgp.domain.Endereco;
import br.com.sgp.dto.EnderecoDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.EnderecoMapper;
import br.com.sgp.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/endereco")
@Api(value = "endereco", description = "Operaçôes sobre enderexo", tags = "Endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@Validated @RequestBody final EnderecoDTO enderecoDTO) throws OperacaoException {
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoService.salvar(endereco);
        return ResponseEntity.ok(enderecoMapper.toDto(endereco));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        List<Endereco> list = enderecoService.findAll();
        return ResponseEntity.ok(enderecoMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um endereco.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        enderecoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar enderecos")
    public ResponseEntity editarCard(@Validated @RequestBody final EnderecoDTO enderecoDTO) throws OperacaoException {
        return ResponseEntity.ok(enderecoMapper.toDto(enderecoService.atualizar(enderecoMapper.toEntity(enderecoDTO))));
    }



}
