package br.com.ponta.mapper;

import br.com.ponta.domain.Empresa;
import br.com.ponta.domain.Secao;
import br.com.ponta.dto.EmpresaDTO;
import br.com.ponta.dto.SecaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SecaoMapper extends BaseMapper<Secao, SecaoDTO> {

}
