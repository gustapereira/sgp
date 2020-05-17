package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TBL_NACIONALIDADE")
public class Nacionalidade extends BaseEntity<Long> {

    public static final String COD_ID = "COD_NACIONALIDADE";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_PAIS")
    private String pais;

    @Column(name = "TX_NACIONALIDADE")
    private String nacionalidade;

}
