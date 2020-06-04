package br.com.sgp.mapper;

import br.com.sgp.domain.QuadroFuncionario;
import br.com.sgp.dto.QuadroFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuadroFuncionarioMapper extends BaseMapper<QuadroFuncionario, QuadroFuncionarioDTO> {

}
