package br.com.sgp.dto;

import br.com.sgp.domain.Departamento;
import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class SetorDTO {

    private Long id;
    private String setor;
    private Funcionario funcionario;
    private Departamento departamento;
}
