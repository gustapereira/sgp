package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class GrupoSalarialDTO {

    private Long id;
    private String descricao;
    private String pontoInicial;
    private String pontoFinal;
    private String observacao;
    private List<SalarioDTO> salarios = new ArrayList<>();


}