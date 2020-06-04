package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_GRUPO_SALARIAL")
public class GrupoSalarial {

    public static final String cod_id = "COD_GRUPO_SALARIAL";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "TX_PONTO_INICIAL")
    private String pontoInicial;

    @Column(name = "TX_PONTO_FINAL")
    private String pontoFinal;

    @Column(name = "TX_OBSERVACAO")
    private String observacao;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "TBL_GRUPO_SALARIAL_SALARIO",
            joinColumns = @JoinColumn(name = "COD_GRUPO_SALARIAL"),
            inverseJoinColumns = @JoinColumn(name = "COD_SALARIO")
    )
    private List<Salario> salarios = new ArrayList<>();


}