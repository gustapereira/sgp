package br.com.sgp.dto;

import br.com.sgp.enums.TypePhone;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TelefoneDTO {

    private Long id;
    private String numero;
    private TypePhone tipoPhone;
}
