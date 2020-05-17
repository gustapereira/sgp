package br.com.sgp.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TBL_HORARIO")
public class Horario extends BaseEntity<Long> {

    public static final String COD_ID = "COD_HORARIO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "DT_BASE")
    private Date dtBase;

    @Column(name = "TX_CICLO_REPETICAO")
    private String cicloRepeticao;

    @Column(name = "TX_TIPO_TABELA")
    private String tipoTabela;

    @Column(name = "BO_REVEZAMENTO")
    private Boolean revezamento;

    @Column(name = "TX_EXPEDIENTE_NORMAL")
    private String expedienteNormal;

    @Column(name = "TX_EXPEDIENTE_FOLGA")
    private String expedienteFolga;

    @Column(name = "TX_EXPEDIENTE_DSR")
    private String expedienteDSR;

    @Column(name = "TX_EXPEDIENTE_FERIADO")
    private String expedienteFeriado;

    @Column(name = "TX_EXPEDIENTE_FERIAS")
    private String expedienteFerias;

    @Column(name = "TX_EXPEDIENTE_SUSPENSAO")
    private String expedienteSuspensao;

    @ManyToOne
    @JoinColumn(name = "COD_PONTO_FACULTATIVO")
    private PontoFacultativo pontoFacultativo;



}
