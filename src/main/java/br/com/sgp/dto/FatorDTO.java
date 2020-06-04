package br.com.sgp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FatorDTO {

    private Long id;
    private String nome;
    private String descricao;
    private List<FaixaFatorDTO> faixaFatores = new ArrayList<>();


}