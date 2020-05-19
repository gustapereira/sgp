package br.com.sgp.controller.v1;

import br.com.sgp.domain.Empresa;
import br.com.sgp.dto.EmpresaDTO;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.mapper.EmpresaMapper;
import br.com.sgp.service.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empresa")
@Api(value = "empresa", description = "Operaçôes sobre empresa", tags = "Empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaMapper empresaMapper;

    @PostMapping
    public ResponseEntity<EmpresaDTO> save(@Validated @RequestBody final EmpresaDTO empresaDTO) throws OperacaoException {
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        empresa = empresaService.salvar(empresa);
        return ResponseEntity.ok(empresaMapper.toDto(empresa));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> list() {
        List<Empresa> list = empresaService.findAll();
        return ResponseEntity.ok(empresaMapper.toDto(list));
    }

    @DeleteMapping("/deletar/{id}")
    @ApiOperation("Endpoint para excluir um empresa.")
    public ResponseEntity deleterCard(@PathVariable("id") Long id) throws OperacaoException {
        empresaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("Editar empresas")
    public ResponseEntity editarCard(@Validated @RequestBody final EmpresaDTO empresaDTO) throws OperacaoException {
        return ResponseEntity.ok(empresaMapper.toDto(empresaService.atualizar(empresaMapper.toEntity(empresaDTO))));
    }



}
