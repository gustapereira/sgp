package br.com.sgp.dto;

import br.com.sgp.domain.Setor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SecaoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Setor setor;
}
