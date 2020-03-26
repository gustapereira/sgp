package br.com.ponta.dto;

import br.com.ponta.domain.Departamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
public class UFDTO {

    private Long id;
    private String nome;
    private String sigla;
}
