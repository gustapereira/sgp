package br.com.sgp.controller.v1;

import br.com.sgp.dto.UFDTO;
import br.com.sgp.mapper.UFMapper;
import br.com.sgp.service.UFService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uf")
@Api(value = "uf", description = "Operaçôes sobre UF", tags = "UF")
public class UFController {

    @Autowired
    private UFService ufService;

    @Autowired
    private UFMapper ufMapper;

    @GetMapping
    @ApiOperation("Endpoint para recuperar todas uf.")
    public ResponseEntity<List<UFDTO>> listar() {
        return ResponseEntity.ok(ufMapper.toDto(ufService.listar()));
    }
}

