package br.com.sgp.dto;

import br.com.sgp.domain.Empresa;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DiretoriaDTO {

    private Long id;
    private String diretoria;
    private Empresa empresa;
}
