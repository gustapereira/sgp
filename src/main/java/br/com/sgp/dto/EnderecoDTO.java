package br.com.sgp.dto;

import br.com.sgp.domain.UF;
import lombok.Getter;
import lombok.Setter;


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
