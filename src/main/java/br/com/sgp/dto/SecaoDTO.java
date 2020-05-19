package br.com.sgp.dto;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.domain.Setor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class SecaoDTO {

    private Long id;
    private String secao;
    private Setor setor;
}
