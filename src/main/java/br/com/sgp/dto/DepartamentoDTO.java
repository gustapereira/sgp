package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DepartamentoDTO {

    private Long id;
    private String departamento;
    private DiretoriaDTO diretoria;
}
