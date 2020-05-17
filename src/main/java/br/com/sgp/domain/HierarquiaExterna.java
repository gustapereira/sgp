package br.com.sgp.domain;

import br.com.sgp.enums.TypeEmpresa;
import br.com.sgp.enums.TypeSubordinacao;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_HIERARQUIA_EXTERNA")
public class HierarquiaExterna extends BaseEntity<Long> {

    public static final String COD_ID = "COD_HIERARQUIA_EXTERNA";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "BO_PESSOA")
    private Boolean isPessoa;

    @Column(name = "BO_EMPRESA")
    private Boolean isEmpresa;

    @Column(name = "TX_NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO")
    private Funcionario funcionario;

    @Column(name = "TYPE_SUBORDINACAO")
    private TypeSubordinacao typeSubordinacao;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA")
    private Empresa empresa;

}
