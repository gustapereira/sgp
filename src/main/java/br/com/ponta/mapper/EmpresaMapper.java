package br.com.ponta.mapper;

import br.com.ponta.domain.Empresa;
import br.com.ponta.dto.EmpresaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmpresaMapper extends BaseMapper<Empresa, EmpresaDTO> {

}
