package br.com.ponta.dto;

import br.com.ponta.domain.Departamento;
import br.com.ponta.domain.Setor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class SetorDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Departamento departamento;
}
