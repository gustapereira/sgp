package br.com.sgp.dto;

import br.com.sgp.domain.PontoFacultativo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;


@Getter
@Setter
public class NacionalidadeDTO {

    private Long id;
    private String pais;
    private String nacionalidade;
}
