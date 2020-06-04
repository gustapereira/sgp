package br.com.sgp.dto;

import br.com.sgp.domain.Cargo;
import br.com.sgp.domain.FaixaFator;
import br.com.sgp.domain.Fator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoXFatorDTO {

    private Long id;
    private String descricao;
    private Cargo cargo;
    private Fator fator;
    private FaixaFator faixaFator;


}