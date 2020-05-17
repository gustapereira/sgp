package br.com.sgp.dto;

import br.com.sgp.domain.Diretoria;
import br.com.sgp.domain.Empresa;
import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class DiretoriaDTO {

    private Long id;
    private String diretoria;
    private Funcionario funcionario;
    private Empresa empresa;
}
