package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_SALARIO")
public class Salario {

    public static final String cod_id = "COD_SALARIO";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO")
    private Usuario usuario;

}