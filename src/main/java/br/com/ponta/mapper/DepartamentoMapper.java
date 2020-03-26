package br.com.ponta.mapper;

import br.com.ponta.domain.Departamento;
import br.com.ponta.dto.DepartamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO> {

}
