package br.com.sgp.dto;

import br.com.sgp.domain.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuadroFuncionarioCadastroDTO {

    private Long id;
    private String previsto;
    private String real;
    private String reservado;
    private String vago;
    private Long idEmpresa;
    private Long idDiretoria;
    private Long idDepartamento;
    private Long idSetor;
    private Long idSecao;
    private Long idCentroCusto;
    private Long idCargo;

}