package br.com.sgp.dto;

import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CentroCustoFuncionarioDTO {

    private Long id;
    private String descricao;
    private List<Funcionario> funcionarios;

}
