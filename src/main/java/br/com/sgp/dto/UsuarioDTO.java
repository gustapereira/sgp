package br.com.sgp.dto;

import br.com.sgp.domain.Cargo;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.domain.PermissoesAcesso;
import br.com.sgp.domain.Secao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.List;


@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String Nome;
    private PermissoesAcesso permissoesAcessoList;
    private Funcionario funcionario;
}
