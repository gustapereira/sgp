package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_ENDERECO")
public class Endereco {

    public static final String cod_id = "COD_ENDERECO";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_CEP")
    private String cep;

    @Column(name = "TX_ENDERECO")
    private String endereco;

    @Column(name = "TX_BAIRRO")
    private String bairro;

    @Column(name = "TX_CIDADE")
    private String cidade;

    @Column(name = "TX_NUMERO")
    private String numero;

    @Column(name = "TX_COMPLEMENTO")
    private String complemento;

    @Column(name = "TX_EMAIL")
    private String eMail;

    @Column(name = "TX_CODIGO_MUNICIPIO")
    private String codigoMunicipio;

    @ManyToOne
    @JoinColumn(name = "COD_UF")
    private UF uf;


}