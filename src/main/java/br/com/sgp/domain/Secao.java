package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_SECAO")
public class Secao extends BaseEntity<Long> {

    public static final String COD_ID = "COD_SECAO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_SECAO")
    private String secao;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "TBL_FUNCIONARIO_SECAO",
            joinColumns = @JoinColumn(name = "COD_SECAO"),
            inverseJoinColumns = @JoinColumn(name = "COD_FUNCIONARIO")
    )
    private List<Funcionario> funcionarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "COD_SETOR")
    private Setor setor;
}
