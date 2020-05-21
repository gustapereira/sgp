package br.com.sgp.mapper;

import br.com.sgp.domain.Departamento;
import br.com.sgp.dto.DepartamentoCadastroDTO;
import br.com.sgp.dto.DepartamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartamentoCadastroMapper extends BaseMapper<Departamento, DepartamentoCadastroDTO> {

}
