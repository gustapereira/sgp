package br.com.ponta.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TBL_FOLHA_DE_PONTO")
public class FolhaDePonto extends BaseEntity<Long> {

    public static final String COD_ID = "COD_FOLHA_DE_PONTO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO")
    private Usuario usuario;

    @Column(name = "DT_ENTRADA")
    private Date entrada;

    @Column(name = "DT_ALMOCO")
    private Date almoco;

    @Column(name = "DT_RETORNO")
    private Date retorno;

    @Column(name = "DT_SAIDA")
    private Date saida;

    @Column(name = "DT_INICIO_HORA_EXTRA")
    private Date inicioHoraExtra;

    @Column(name = "DT_FINAL_HORA_EXTRA")
    private Date finalHoraExtra;

    @Column(name = "TX_JUSTIFICATIVA")
    private String justificativa;
}
