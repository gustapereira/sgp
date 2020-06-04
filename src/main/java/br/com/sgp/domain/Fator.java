package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_FATOR")
public class Fator {

    public static final String cod_id = "COD_FATOR";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "TBL_FATOR_FAIXA_FATORES",
            joinColumns = @JoinColumn(name = "COD_FATOR"),
            inverseJoinColumns = @JoinColumn(name = "COD_FAIXA_FATOR")
    )
    private List<FaixaFator> faixaFatores = new ArrayList<>();


}