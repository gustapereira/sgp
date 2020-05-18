package br.com.sgp.dto;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.domain.PermissoesAcesso;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioFuncionarioDTO {

    private Long id;
    private String Nome;
    private PermissoesAcesso permissoesAcessoList;
    private Funcionario funcionario;
}
