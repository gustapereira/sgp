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
@Table(name = "TBL_UF")
public class UF extends BaseEntity<Long> {

    public static final String COD_ID = "COD_UF";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_NOME", length = 40, nullable = false)
    private String nome;

    @Column(name = "TX_SIGLA", length = 2, nullable = false)
    private String sigla;

}
