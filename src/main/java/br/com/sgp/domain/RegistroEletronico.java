package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_REGISTRO_ELETRONICO")
public class RegistroEletronico extends BaseEntity<Long> {

    public static final String COD_ID = "COD_REGISTRO_ELETRONICO";

    private static final long serialVersionUID = -8696372058553975124L;

    @Id
    @Column(name = COD_ID)
    private Long id;

    @Column(name = "TX_TIPO", length = 5, nullable = false)
    private String tipo;

    @Column(name = "TX_NOME", length = 256, nullable = false)
    private String nome;


}
