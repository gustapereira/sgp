package br.com.sgp.controller.v1;

import br.com.sgp.domain.PermissoesAcesso;
import br.com.sgp.dto.PermissoesAcessoDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.PermissoesAcessoMapper;
import br.com.sgp.service.PermissoesAcessoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/permissoesAcesso")
@Api(value = "permissoesAcesso", description = "Operaçôes sobre permissoesAcesso", tags = "PermissoesAcesso")
public class PermissoesAcessoController {

    @Autowired
    private PermissoesAcessoService permissoesAcessoService;

    @Autowired
    private PermissoesAcessoMapper permissoesAcessoMapper;

    @PostMapping
    public ResponseEntity<PermissoesAcessoDTO> save(@Validated @RequestBody final PermissoesAcessoDTO permissoesAcessoDTO) throws OperacaoException {
        PermissoesAcesso permissoesAcesso = permissoesAcessoMapper.toEntity(permissoesAcessoDTO);
        permissoesAcesso = permissoesAcessoService.salvar(permissoesAcesso);
        return ResponseEntity.ok(permissoesAcessoMapper.toDto(permissoesAcesso));
    }


    @GetMapping
    public ResponseEntity<List<PermissoesAcessoDTO>> list() {
        List<PermissoesAcesso> list = permissoesAcessoService.findAll();
        return ResponseEntity.ok(permissoesAcessoMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um permissoesAcesso.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        permissoesAcessoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar permissoesAcessos")
    public ResponseEntity editarCard(@Validated @RequestBody final PermissoesAcessoDTO permissoesAcessoDTO) throws OperacaoException {
        return ResponseEntity.ok(permissoesAcessoMapper.toDto(permissoesAcessoService.atualizar(permissoesAcessoMapper.toEntity(permissoesAcessoDTO))));
    }



}
