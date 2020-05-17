package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "TBL_FUNCIONARIO_DIRETORIA",
            joinColumns = @JoinColumn(name = "COD_DIRETORIA"),
            inverseJoinColumns = @JoinColumn(name = "COD_FUNCIONARIO")
    )
    private List<Funcionario> funcionario = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA")
    private Empresa empresa;


}

