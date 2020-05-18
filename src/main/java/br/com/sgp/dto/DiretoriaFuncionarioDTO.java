package br.com.sgp.dto;

import br.com.sgp.domain.Empresa;
import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DiretoriaFuncionarioDTO {

    private Long id;
    private String diretoria;
    private List<Funcionario> funcionarios;
    private Empresa empresa;
}
