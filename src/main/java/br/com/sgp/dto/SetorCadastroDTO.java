package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SetorCadastroDTO {

    private Long id;
    private String setor;
    private Long idDepartamento;
}
