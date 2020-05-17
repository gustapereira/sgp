package br.com.sgp.domain;

import br.com.sgp.enums.TypeAfastamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TBL_AFASTAMENTO")
public class Afastamento extends BaseEntity<Long> {

    public static final String COD_ID = "COD_AFASTAMENTO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "DT_AFASTAMENTO")
    private Date dtAfastamento;

    @Column(name = "TYPE_AFASTAMENTO")
    private TypeAfastamento typeAfastamento;

}
