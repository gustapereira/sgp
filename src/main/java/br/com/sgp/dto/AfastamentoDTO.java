package br.com.sgp.dto;

import br.com.sgp.enums.TypeAfastamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;


@Getter
@Setter
public class AfastamentoDTO {

    private Long id;
    private Date dtAfastamento;
    private TypeAfastamento typeAfastamento;

}
