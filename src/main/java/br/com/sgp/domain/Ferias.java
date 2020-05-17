package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TBL_FERIAS")
public class Ferias extends BaseEntity<Long> {

    public static final String COD_ID = "COD_FERIAS";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "DT_FERIAS")
    private Date dtFerias;


}
