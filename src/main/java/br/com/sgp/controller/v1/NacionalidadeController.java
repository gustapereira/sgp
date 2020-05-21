package br.com.sgp.controller.v1;

import br.com.sgp.domain.Nacionalidade;
import br.com.sgp.dto.NacionalidadeDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.NacionalidadeMapper;
import br.com.sgp.service.NacionalidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/nacionalidade")
@Api(value = "nacionalidade", description = "Operaçôes sobre nacionalidade", tags = "Nacionalidade")
public class NacionalidadeController {

    @Autowired
    private NacionalidadeService nacionalidadeService;

    @Autowired
    private NacionalidadeMapper nacionalidadeMapper;

    @PostMapping
    public ResponseEntity<NacionalidadeDTO> save(@Validated @RequestBody final NacionalidadeDTO nacionalidadeDTO) throws OperacaoException {
        Nacionalidade nacionalidade = nacionalidadeMapper.toEntity(nacionalidadeDTO);
        nacionalidade = nacionalidadeService.salvar(nacionalidade);
        return ResponseEntity.ok(nacionalidadeMapper.toDto(nacionalidade));
    }


    @GetMapping
    public ResponseEntity<List<NacionalidadeDTO>> list() {
        List<Nacionalidade> list = nacionalidadeService.findAll();
        return ResponseEntity.ok(nacionalidadeMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um nacionalidade.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        nacionalidadeService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar nacionalidades")
    public ResponseEntity editarCard(@Validated @RequestBody final NacionalidadeDTO nacionalidadeDTO) throws OperacaoException {
        return ResponseEntity.ok(nacionalidadeMapper.toDto(nacionalidadeService.atualizar(nacionalidadeMapper.toEntity(nacionalidadeDTO))));
    }



}
