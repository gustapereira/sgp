package br.com.sgp.dto;

import br.com.sgp.domain.Departamento;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SetorDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Departamento departamento;
}
