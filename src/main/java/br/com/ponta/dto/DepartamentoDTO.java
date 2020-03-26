package br.com.ponta.dto;

import br.com.ponta.domain.CentroCusto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DepartamentoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private CentroCusto centroCusto;
}
