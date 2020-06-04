package br.com.sgp.dto;

import br.com.sgp.domain.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class QuadroFuncionarioDTO {

    private Long id;
    private String previsto;
    private String real;
    private String reservado;
    private String vago;
    private Empresa empresa;
    private Diretoria diretoria;
    private Departamento departamento;
    private Setor setor;
    private Secao secao;
    private CentroCusto centroCusto;
    private Cargo cargo;



}