package br.com.sgp.dto;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.domain.Setor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SecaoFuncionarioDTO {

    private Long id;
    private String secao;
    private List<Funcionario> funcionarios;
    private Setor setor;
}
