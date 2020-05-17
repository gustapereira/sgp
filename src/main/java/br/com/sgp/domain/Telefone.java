package br.com.sgp.domain;

import br.com.sgp.enums.TypePhone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_TELEFONE")
public class Telefone extends BaseEntity<Long> {

    public static final String COD_ID = "COD_TELEFONE";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_NUMERO")
    private String numero;

    @Column(name = "TYPE_PHONE")
    @Enumerated(EnumType.STRING)
    private TypePhone tipoPhone;

}
