package br.com.sgp.mapper;

import br.com.sgp.domain.Departamento;
import br.com.sgp.dto.DepartamentoFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartamentoFuncionarioMapper extends BaseMapper<Departamento, DepartamentoFuncionarioDTO> {

}
