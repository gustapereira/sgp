package br.com.sgp.mapper;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.FuncionarioCadastroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FuncionarioCadastroMapper extends BaseMapper<Funcionario, FuncionarioCadastroDTO> {

}
