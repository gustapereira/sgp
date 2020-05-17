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
@Table(name = "TBL_PERMISSOES_ACESSO")
public class PermissoesAcesso extends BaseEntity<Long> {

    public static final String COD_ID = "COD_PERMISSOES_ACESSO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;


}
