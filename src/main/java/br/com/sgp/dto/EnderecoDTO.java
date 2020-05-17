package br.com.sgp.dto;

import br.com.sgp.domain.UF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class EnderecoDTO {

    private Long id;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String numero;
    private String complemento;
    private String eMail;
    private String codigoMunicipio;
    private UF uf;
}
