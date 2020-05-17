package br.com.sgp.dto;

import br.com.sgp.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


@Getter
@Setter
public class FolhaDePontoDTO {

    private Long id;
    private Usuario usuario;
    private Date entrada;
    private Date almoco;
    private Date saida;
    private Date inicioHoraExtra;
    private Date finalHoraExtra;
    private String justificativa;
}
