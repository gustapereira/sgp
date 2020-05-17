package br.com.sgp.dto;

import br.com.sgp.domain.UF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;


@Getter
@Setter
public class FeriasDTO {

    private Long id;
    private Date dtFerias;
}
