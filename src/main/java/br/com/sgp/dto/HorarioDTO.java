package br.com.sgp.dto;

import br.com.sgp.domain.Empresa;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.domain.PontoFacultativo;
import br.com.sgp.enums.TypeSubordinacao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;


@Getter
@Setter
public class HorarioDTO {

    private Long id;
    private String descricao;
    private Date dtBase;
    private String cicloRepeticao;
    private String tipoTabela;
    private Boolean revezamento;
    private String expedienteNormal;
    private String expedienteFolga;
    private String expedienteDSR;
    private String expedienteFeriado;
    private String expedienteFerias;
    private String expedienteSuspensao;
    private PontoFacultativo pontoFacultativo;
}
