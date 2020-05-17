package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "TBL_FUNCIONARIO_FOLHA_PONTO",
            joinColumns = @JoinColumn(name = "COD_FOLHA_PONTO"),
            inverseJoinColumns = @JoinColumn(name = "COD_FUNCIONARIO")
    )
    private List<Funcionario> funcionario = new ArrayList<>();
}
