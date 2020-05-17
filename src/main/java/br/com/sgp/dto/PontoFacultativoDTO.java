package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
public class PontoFacultativoDTO {

    private Long id;
    private String nome;
    private String descricao;
}
