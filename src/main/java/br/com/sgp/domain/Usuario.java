package br.com.sgp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {

    public static final String cod_id = "COD_USUARIO";

    @Id
    @Column(name = cod_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String Nome;

    @ManyToOne
    @JoinColumn(name = "COD_PERMISSOES_ACESSO")
    private PermissoesAcesso permissoesAcessoList;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO")
    private Funcionario funcionario;




}