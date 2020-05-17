package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_DEPARTAMENTO")
public class Departamento extends BaseEntity<Long> {

    public static final String COD_ID = "COD_DEPARTAMENTO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_DEPARTAMENTO")
    private String departamento;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "COD_DIRETORIA")
    private Diretoria diretoria;


}
