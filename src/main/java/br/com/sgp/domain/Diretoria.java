package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_DIRETORIA")
public class Diretoria extends BaseEntity<Long> {

    public static final String COD_ID = "COD_DIRETORIA";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_DIRETORIA")
    private String diretoria;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA")
    private Empresa empresa;


}

