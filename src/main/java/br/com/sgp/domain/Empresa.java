package br.com.sgp.domain;

import br.com.sgp.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "FT_LOGO_MARCA")
    private String logoMarca;

    @Column(name = "TX_CNPJ")
    private String cnpj;

    @Column(name = "TX_RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "TX_NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "TX_CNAE")
    private String CNAE;

    @Column(name = "TX_ATIVIDADE_PRINCIPAL")
    private String atividadePrincipal;

    @Column(name = "TYPE_IRRF")
    @Enumerated(EnumType.STRING)
    private TypeIRRF typeIRRF;

    @Column(name = "TYPE_VINCULO")
    @Enumerated(EnumType.STRING)
    private TypeVinculo typeVinculo;

    @Column(name = "TYPE_DOCUMENTO")
    @Enumerated(EnumType.STRING)
    private TypeDocumento typeDocumento;

    @Column(name = "TX_NUMERO_DOCUMENTO")
    private String numeroDocumento;

    @Column(name = "TYPE_EMPRESA")
    @Enumerated(EnumType.STRING)
    private TypeEmpresa typeEmpresa;

    @ManyToOne
    @JoinColumn(name = "COD_ENDERECO")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "COD_TELEFONE")
    private Telefone telefone;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO")
    private Usuario responsavel;

    @Column(name = "TX_CODIGO_ENCERRAMENTO_EMPRESA")
    private String codigoEncerramentoEmpresa;

    @Column(name = "DT_INICIO_ATIVIDADE")
    private Date dtInicioAtividade;

    @Column(name = "DT_FINAL_ATIVIDADE")
    private Date dtFinalAtividade;

    @Column(name = "TX_BR_PDH")
    private String brPDH;

    @Column(name = "TX_DIRECAO_GERAL")
    private String direcaoGeral;

    @Column(name = "TX_CEO")
    private String CEO;

    @Column(name = "TYPE_STATUS")
    @Enumerated(EnumType.STRING)
    private TypeStatus typeStatus;

}