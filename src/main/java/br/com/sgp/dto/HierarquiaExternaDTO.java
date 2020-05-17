package br.com.sgp.dto;

import br.com.sgp.domain.Empresa;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.enums.TypeSubordinacao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;


@Getter
@Setter
public class HierarquiaExternaDTO {

    private Long id;
    private Boolean isPessoa;
    private Boolean isEmpresa;
    private String nome;
    private Funcionario funcionario;
    private TypeSubordinacao typeSubordinacao;
    private Empresa empresa;
}
