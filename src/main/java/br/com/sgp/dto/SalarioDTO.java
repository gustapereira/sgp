package br.com.sgp.dto;

import br.com.sgp.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
public class SalarioDTO {

    private Long id;
    private BigDecimal valor;
    private Usuario usuario;

}