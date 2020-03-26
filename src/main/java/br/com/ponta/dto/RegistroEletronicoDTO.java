package br.com.ponta.dto;

import br.com.ponta.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;


@Getter
@Setter
public class RegistroEletronicoDTO {

    private Long id;
    private String tipo;
    private String nome;
}
