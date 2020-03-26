package br.com.ponta.dto;

import br.com.ponta.domain.UF;
import br.com.ponta.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;


@Getter
@Setter
public class FolhaDePontoDTO {

    private Long id;
    private Usuario usuario;
    private Date entrada;
    private Date almoco;
    private Date retorno;
    private Date saida;
    private Date inicioHoraExtra;
    private Date finalHoraExtra;
    private String justificativa;
}
