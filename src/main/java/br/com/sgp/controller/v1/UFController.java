package br.com.sgp.controller.v1;

import br.com.sgp.dto.UFDTO;
import br.com.sgp.service.UFService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uf")
@Api("Endpoint de UF")
public class UFController {

    @Autowired
    private UFService ufService;

    @GetMapping
    @ApiOperation("Lista todos os UFes")
    public ResponseEntity<List<UFDTO>> listar() {
        return ResponseEntity.ok(ufService.findAll());
    }




}
