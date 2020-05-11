package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_SETOR")
public class Setor extends BaseEntity<Long> {

    public static final String COD_ID = "COD_SETOR";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_NOME", length = 256, nullable = false)
    private String nome;

    @Column(name = "TX_DESCRICAO", length = 256, nullable = false)
    private String descricao;

    @ManyToOne
    @Column(name = "COD_DEPARTAMENTO")
    private Departamento departamento;

}
