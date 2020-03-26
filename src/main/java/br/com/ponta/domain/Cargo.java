package br.com.ponta.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TBL_CARGO")
public class Cargo extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CARGO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_NOME", length = 256, nullable = false)
    private String nome;

    @Column(name = "TX_DESCRICAO", length = 256, nullable = false)
    private String descricao;

}
