package br.com.ponta.dto;

import br.com.ponta.domain.Endereco;
import br.com.ponta.domain.TypeStatus;
import br.com.ponta.domain.UF;
import br.com.ponta.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private UF uf;
}
