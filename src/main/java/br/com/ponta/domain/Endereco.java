package br.com.ponta.domain;

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

    @Column(name = "TX_CNPJ")
    private String logradouro;

    @Column(name = "TX_CNPJ")
    private String numero;

    @Column(name = "TX_CNPJ")
    private String complemento;

    @Column(name = "TX_CNPJ")
    private String bairro;

    @Column(name = "TX_CNPJ")
    private String cidade;

    @Column(name = "TX_CNPJ")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "COD_UF")
    private UF uf;


}