package br.com.sgp.dto;

import br.com.sgp.enums.TypeSubordinacao;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class HierarquiaExternaCadastroDTO {

    private Long id;
    private Boolean isPessoa;
    private Boolean isEmpresa;
    private String nome;
    private TypeSubordinacao typeSubordinacao;
    private Long idEmpresa;
}
