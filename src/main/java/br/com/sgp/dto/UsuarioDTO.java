package br.com.sgp.dto;

import br.com.sgp.domain.Cargo;
import br.com.sgp.domain.Secao;
import lombok.Getter;
import lombok.Setter;


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
