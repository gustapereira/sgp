package br.com.sgp.mapper;

import br.com.sgp.domain.Setor;
import br.com.sgp.dto.SetorFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SetorFuncionarioMapper extends BaseMapper<Setor, SetorFuncionarioDTO> {

}
