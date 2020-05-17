package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
public class PermissoesAcessoDTO {

    private Long id;
    private String nome;
}
