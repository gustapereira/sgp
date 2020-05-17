package br.com.sgp.domain;

import br.com.sgp.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TBL_FUNCIONARIOS")
public class Funcionario {

    public static final String cod_id = "COD_FUNCIONARIOS";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FT_AVATAR")
    private String avatar;

    @Column(name = "TX_CRACHA")
    private String cracha;

    @Column(name = "TX_NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA")
    private Empresa empresa;

    @Column(name = "TX_NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "TX_NATURALIDADE")
    private String naturalidade;

    @ManyToOne
    @JoinColumn(name = "COD_UF_NASCIMENTO")
    private String ufNascimento;;

    @ManyToOne
    @JoinColumn(name = "COD_ENDERECO")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "COD_TELEFONE")
    private Telefone telefone;

    @Column(name = "DT_NASCIMENTO")
    private Date dtNascimento;

    @Column(name = "TX_NOME_MAE")
    private String nomeMae;

    @Column(name = "TX_NOME_PAI")
    private String nomePai;

    @Column(name = "TYPE_SEXO")
    @Enumerated(EnumType.STRING)
    private TypeSexo typeSexo;

    @Column(name = "DT_PROXIMO_EXAME")
    private Date proximoExame;

    @Column(name = "DT_ADMISSAO")
    private Date admissao;

    @ManyToOne
    @JoinColumn(name = "COD_FERIAS")
    private Ferias ferias;

    @ManyToOne
    @JoinColumn(name = "COD_AFASTAMENTO")
    private Afastamento afastamento;

    @Column(name = "TYPE_ESTADO_CIVIL")
    @Enumerated(EnumType.STRING)
    private TypeEstadoCivil typeEstadoCivil;

    @Column(name = "TYPE_RACA")
    @Enumerated(EnumType.STRING)
    private TypeRaca typeRaca;

    @ManyToOne
    @JoinColumn(name = "COD_NACIONALIDADE")
    private Nacionalidade nacionalidade;

    @Column(name = "BO_DEFICIENTE")
    private Boolean isDeficiente;

    @Column(name = "TYPE_DEFICIENCIA")
    @Enumerated(EnumType.STRING)
    private TypeDeficiencia typeDeficiencia;

    @Column(name = "DB_SALARIO")
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "COD_CARGO")
    private Cargo cargo;

    @Column(name = "TYPE_SALARIO")
    @Enumerated(EnumType.STRING)
    private TypeSalario typeSalario;

    @Column(name = "LG_HORAS_BASE")
    private Long horasBase;

    @Column(name = "DT_DATA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "COD_CBO")
    private CBO cbo;

    @ManyToOne
    @JoinColumn(name = "COD_CENTRO_CUSTO")
    private CentroCusto centroCusto;

    @Column(name = "TX_GRUPO_AVAL_DESEMPENHO")
    private String grupoAvalDesempenho;

    @Column(name = "TX_GRUPO_PROFISSIOGRAFICO")
    private String grupoProfissiografico;

    @Column(name = "TX_GRUPO_AVAL_EXPERIENCIA")
    private String grupoAvalExperiencia;


    //DOCUMENTACAO
    @Column(name = "TX_CPF")
    private String CPF;

    @Column(name = "TX_RG")
    private String RG;

    @Column(name = "DT_RG_EXPEDICAO")
    private Date dtRGExpedicao;

    @Column(name = "TX_RG_ORGAO")
    private String rgOrgao;

    @ManyToOne
    @JoinColumn(name = "COD_UF_RG")
    private String ufRG;;

    @Column(name = "TX_NUM_INSS")
    private String numINSS;

    @Column(name = "TX_CLASSE_INSS")
    private String classeINSS;

    @Column(name = "TX_NUM_PIS")
    private String numPIS;

    @Column(name = "DT_EMISSAO_PIS")
    private Date dtEmissaoPIS;

    @Column(name = "TX_CTPS")
    private String CTPS;

    @Column(name = "TX_SERIE_CTPS")
    private String serieCTPS;

    @Column(name = "DT_CTPS")
    private Date dtCTPS;

    @Column(name = "COD_UF_CTPS")
    private String ufCTPS;;

    @Column(name = "TX_CNH")
    private String CNH;

    @Column(name = "TX_CATEGORIA")
    private String categoria;

    @Column(name = "DT_EMISSAO_CNH")
    private Date dtEmissaoCNH;

    @Column(name = "DT_VALIDADE_CNH")
    private Date dtValidadeCNH;

    @Column(name = "TX_NUM_RIC")
    private String numRIC;

    @Column(name = "DT_EMISSAO_RIC")
    private Date dtEmissaoRIC;

    @Column(name = "DT_VALIDADE_RIC")
    private Date dtValidadeRIC;

    @Column(name = "TX_ORGAO_RIC")
    private String orgaoRIC;

    @Column(name = "TX_CIDADE_RIC")
    private String cidadeRIC;

    @ManyToOne
    @JoinColumn(name = "COD_UF_RIC")
    private String ufRIC;;

    @Column(name = "TX_NUM_TITULO_ELEITOR")
    private String numTituloEleitor;

    @Column(name = "TX_NUM_ZONA_TITULO_ELEITOR")
    private String numZonaTituloEleitor;

    @Column(name = "TX_NUM_SECAO_TITULO_ELEITOR")
    private String numSecaoTituloEleitor;

    @Column(name = "DT_TITULO_ELEITOR")
    private Date dtTituloEleitor;

    @ManyToOne
    @JoinColumn(name = "COD_UF_TITULO_ELEITOR")
    private String ufTituloEleitor;;

    @Column(name = "TX_NUM_RESERVISTA")
    private String numReservista;

    @Column(name = "TX_SERIE_RESERVISTA")
    private String serieReservista;

    @Column(name = "DT_RESERVISTA")
    private Date dtReservista;

    @Column(name = "TX_RA_RESERVISTA")
    private String raReservista;

    @Column(name = "TX_CSM_RESERVISTA")
    private String csmReservista;

    //OUTRAS INFORMACOES
    @Column(name = "TYPE_CAT_TRABALHADOR")
    @Enumerated(EnumType.STRING)
    private TypeCatTrabalhador typeCatTrabalhador;

    @Column(name = "TX_APOSENTADO")
    private String aposentado;

    @Column(name = "TX_AREA")
    private String area;

    @Column(name = "TX_ESCOLARIDADE")
    private String escolaridade;

    @Column(name = "TX_EMAIL")
    private String eMail;

    @Column(name = "LG_DIAS_EXPERIENCIA")
    private Long diasExperiencia;

    @Column(name = "LG_DIAS_PORROGACAO")
    private Long diasPorrogacao;

    @ManyToOne
    @JoinColumn(name = "COD_HORARIO")
    private Horario horario;

    @Column(name = "TX_REVEZAMENTO")
    private String revezamento;

    @Column(name = "TX_BENEFICIARIOS")
    private String beneficiarios;

    @Column(name = "TX_APOS_ESPECIAL")
    private String aposEspecial;

    @Column(name = "TX_OBSERVACOES_PPP")
    private String observacoesPPP;

}