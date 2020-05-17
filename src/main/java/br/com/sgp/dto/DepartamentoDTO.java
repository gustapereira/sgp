package br.com.sgp.dto;

import br.com.sgp.domain.CentroCusto;
import br.com.sgp.domain.Diretoria;
import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class DepartamentoDTO {

    private Long id;
    private String departamento;
    private Funcionario funcionario;
    private Diretoria diretoria;
}
