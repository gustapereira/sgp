package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_CENTRO_CUSTO")
public class CentroCusto extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CENTRO_CUSTO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "TBL_FUNCIONARIO_CENTRO_CUSTO",
            joinColumns = @JoinColumn(name = "COD_CENTRO_CUSTO"),
            inverseJoinColumns = @JoinColumn(name = "COD_FUNCIONARIO")
    )
    private List<Funcionario> funcionarios = new ArrayList<>();

}
