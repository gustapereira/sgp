package br.com.sgp.mapper;

import br.com.sgp.domain.Empresa;
import br.com.sgp.dto.EmpresaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmpresaMapper extends BaseMapper<Empresa, EmpresaDTO> {

}
