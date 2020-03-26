package br.com.ponta.dto;

import br.com.ponta.domain.Cargo;
import br.com.ponta.domain.Secao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String Nome;
    private String dtNascimento;
    private String admissao;
    private String ctps;
    private String serieCTPS;
    private String pis;
    private String sexo;
    private Cargo cargo;
    private Secao secao;
}
