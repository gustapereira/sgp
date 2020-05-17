package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "TX_SETOR")
    private String setor;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "TBL_FUNCIONARIO_SETOR",
            joinColumns = @JoinColumn(name = "COD_SETOR"),
            inverseJoinColumns = @JoinColumn(name = "COD_FUNCIONARIO")
    )
    private List<Funcionario> funcionario = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "COD_DEPARTAMENTO")
    private Departamento departamento;

}
