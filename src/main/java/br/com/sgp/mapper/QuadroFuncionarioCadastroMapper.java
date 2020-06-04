package br.com.sgp.mapper;

import br.com.sgp.domain.QuadroFuncionario;
import br.com.sgp.dto.QuadroFuncionarioCadastroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuadroFuncionarioCadastroMapper extends BaseMapper<QuadroFuncionario, QuadroFuncionarioCadastroDTO> {

}
