package br.com.sgp.mapper;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.FuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FuncionarioMapper extends BaseMapper<Funcionario, FuncionarioDTO> {

}
