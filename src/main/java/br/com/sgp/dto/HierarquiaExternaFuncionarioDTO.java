package br.com.sgp.dto;

import br.com.sgp.domain.Empresa;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.enums.TypeSubordinacao;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class HierarquiaExternaFuncionarioDTO {

    private Long id;
    private Boolean isPessoa;
    private Boolean isEmpresa;
    private String nome;
    private List<Funcionario> funcionarios;
    private TypeSubordinacao typeSubordinacao;
    private Empresa empresa;
}
