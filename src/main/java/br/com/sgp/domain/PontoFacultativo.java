package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_PONTO_FACULTATIVO")
public class PontoFacultativo {

    public static final String cod_id = "COD_PONTO_FACULTATIVO";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_DESCRICAO")
    private String descricao;



}