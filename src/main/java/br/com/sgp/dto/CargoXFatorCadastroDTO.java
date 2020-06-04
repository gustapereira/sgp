package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoXFatorCadastroDTO {

    private Long id;
    private String nome;
    private Long idCargo;
    private Long idFator;
    private Long idFaixaFator;


}