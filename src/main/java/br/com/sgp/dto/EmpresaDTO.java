package br.com.sgp.dto;

import br.com.sgp.domain.Endereco;
import br.com.sgp.domain.TypeStatus;
import br.com.sgp.domain.Usuario;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmpresaDTO {

    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String CNAE;
    private Endereco endereco;
    private Usuario responsavel;
    private TypeStatus typeStatus;
}
