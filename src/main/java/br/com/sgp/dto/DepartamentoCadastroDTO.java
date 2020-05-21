package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DepartamentoCadastroDTO {

    private Long id;
    private String departamento;
    private Long idDiretoria;
}
