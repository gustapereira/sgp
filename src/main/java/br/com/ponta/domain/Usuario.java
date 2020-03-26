package br.com.ponta.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {

    public static final String cod_id = "COD_USUARIO";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_CNPJ")
    private String Nome;

    @Column(name = "TX_CNPJ")
    private String dtNascimento;

    @Column(name = "TX_CNPJ")
    private String admissao;

    @Column(name = "TX_CNPJ")
    private String ctps;

    @Column(name = "TX_CNPJ")
    private String serieCTPS;

    @Column(name = "TX_CNPJ")
    private String pis;

    @Column(name = "TX_CNPJ")
    private String sexo;

    @ManyToOne
    @Column(name = "COD_CARGO")
    private Cargo cargo;

    @ManyToOne
    @Column(name = "COD_SECAO")
    private Secao secao;




}