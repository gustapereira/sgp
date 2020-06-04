package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_QUADRO_FUNCIONARIO")
public class QuadroFuncionario {

    public static final String cod_id = "COD_QUADRO_FUNCIONARIO";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_PREVISTO")
    private String previsto;

    @Column(name = "TX_REAL")
    private String real;

    @Column(name = "TX_RESERVADO")
    private String reservado;

    @Column(name = "TX_VAGO")
    private String vago;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "COD_DIRETORIA")
    private Diretoria diretoria;

    @ManyToOne
    @JoinColumn(name = "COD_DEPARTAMENTO")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "COD_SETOR")
    private Setor setor;

    @ManyToOne
    @JoinColumn(name = "COD_SECAO")
    private Secao secao;

    @ManyToOne
    @JoinColumn(name = "COD_CENTRO_CUSTO")
    private CentroCusto centroCusto;

    @ManyToOne
    @JoinColumn(name = "COD_CARGO")
    private Cargo cargo;



}