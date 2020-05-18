package br.com.sgp.dto;

import br.com.sgp.domain.Departamento;
import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SetorFuncionarioDTO {

    private Long id;
    private String setor;
    private List<Funcionario> funcionarios;
    private Departamento departamento;
}
