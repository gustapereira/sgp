package br.com.sgp.dto;

import br.com.sgp.domain.*;
import br.com.sgp.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class FuncionarioCadastroDTO {

    private Long id;
    private Long idEmpresa;
    private String avatar;
    private String cracha;
    private String nome;
    private String nomeCompleto;
    private String naturalidade;
    private UF ufNascimento;;
    private Endereco enderecoFuncionario;
    private Telefone telefone;
    private Date dtNascimento;
    private String nomeMae;
    private String nomePai;
    private TypeSexo typeSexo;
    private Date proximoExame;
    private Date admissao;
    private Ferias ferias;
    private Afastamento afastamento;
    private TypeEstadoCivil typeEstadoCivil;
    private TypeRaca typeRaca;
    private Nacionalidade nacionalidade;
    private Boolean isDeficiente;
    private TypeDeficiencia typeDeficiencia;
    private Double salario;
    private Cargo cargo;
    private TypeSalario typeSalario;
    private Long horasBase;
    private Date data;
    private CBO cbo;
    private String grupoAvalDesempenho;
    private String grupoProfissiografico;
    private String grupoAvalExperiencia;
    private String CPF;
    private String RG;
    private Date dtRGExpedicao;
    private String rgOrgao;
    private UF ufRG;
    private String numINSS;
    private String classeINSS;
    private String numPIS;
    private Date dtEmissaoPIS;
    private String CTPS;
    private String serieCTPS;
    private Date dtCTPS;
    private UF ufCTPS;
    private String CNH;
    private String categoria;
    private Date dtEmissaoCNH;
    private Date dtValidadeCNH;
    private String numRIC;
    private Date dtEmissaoRIC;
    private Date dtValidadeRIC;
    private String orgaoRIC;
    private String cidadeRIC;
    private UF ufRIC;
    private String numTituloEleitor;
    private String numZonaTituloEleitor;
    private String numSecaoTituloEleitor;
    private Date dtTituloEleitor;
    private UF ufTituloEleitor;
    private String numReservista;
    private String serieReservista;
    private Date dtReservista;
    private String raReservista;
    private String csmReservista;
    private TypeCatTrabalhador typeCatTrabalhador;
    private String aposentado;
    private String area;
    private String escolaridade;
    private String eMail;
    private Long diasExperiencia;
    private Long diasPorrogacao;
    private Horario horario;
    private String revezamento;
    private String beneficiarios;
    private String aposEspecial;
    private String observacoesPPP;
}
