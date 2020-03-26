package br.com.ponta.dto;

import br.com.ponta.domain.CentroCusto;
import br.com.ponta.domain.Endereco;
import br.com.ponta.domain.TypeStatus;
import br.com.ponta.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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
