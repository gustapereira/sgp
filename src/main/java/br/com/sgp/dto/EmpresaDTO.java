package br.com.sgp.dto;

import br.com.sgp.domain.Endereco;
import br.com.sgp.domain.Telefone;
import br.com.sgp.domain.UF;
import br.com.sgp.enums.*;
import br.com.sgp.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
public class EmpresaDTO {

    private Long id;
    private String logoMarca;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String CNAE;
    private String atividadePrincipal;
    private TypeIRRF typeIRRF;
    private TypeVinculo typeVinculo;
    private TypeDocumento typeDocumento;
    private String numeroDocumento;
    private TypeEmpresa typeEmpresa;
    private Endereco endereco;
    private Telefone telefone;
    private Usuario responsavel;
    private String codigoEncerramentoEmpresa;
    private Date dtInicioAtividade;
    private Date dtFinalAtividade;
    private String brPDH;
    private String direcaoGeral;
    private String CEO;
    private TypeStatus typeStatus;
}
