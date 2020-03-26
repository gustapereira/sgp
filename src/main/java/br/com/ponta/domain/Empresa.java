package br.com.ponta.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_EMPRESA")
public class Empresa {

    public static final String cod_id = "COD_EMPRESA";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_CNPJ")
    private String cnpj;

    @Column(name = "TX_RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "TX_NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "TX_CNAE")
    private String CNAE;

    @ManyToOne
    @JoinColumn(name = "COD_ENDERECO")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO")
    private Usuario responsavel;

    @Column(name = "TYPE_STATUS")
    @Enumerated(EnumType.STRING)
    private TypeStatus typeStatus;

}