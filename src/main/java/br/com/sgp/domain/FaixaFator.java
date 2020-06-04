package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_FAIXA_FATOR")
public class FaixaFator {

    public static final String cod_id = "COD_FAIXA_FATOR";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_PONTOS")
    private String pontos;

}