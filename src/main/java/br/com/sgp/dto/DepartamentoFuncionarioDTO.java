package br.com.sgp.dto;

import br.com.sgp.domain.Diretoria;
import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DepartamentoFuncionarioDTO {

    private Long id;
    private String departamento;
    private List<Funcionario> funcionarios;
    private Diretoria diretoria;
}
