package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_CARGO_X_FATOR")
public class CargoXFator {

    public static final String cod_id = "COD_CARGO_X_FATOR";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "COD_CARGO")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "COD_FATOR")
    private Fator fator;

    @ManyToOne
    @JoinColumn(name = "COD_FAIXA_FATOR")
    private FaixaFator faixaFator;


}