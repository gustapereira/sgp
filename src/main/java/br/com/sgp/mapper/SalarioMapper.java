package br.com.sgp.mapper;

import br.com.sgp.domain.Salario;
import br.com.sgp.dto.SalarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalarioMapper extends BaseMapper<Salario, SalarioDTO> {

}
