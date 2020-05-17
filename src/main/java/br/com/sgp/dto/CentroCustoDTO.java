package br.com.sgp.dto;

import br.com.sgp.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class CentroCustoDTO {

    private Long id;
    private String descricao;
    private Funcionario funcionario;

}
