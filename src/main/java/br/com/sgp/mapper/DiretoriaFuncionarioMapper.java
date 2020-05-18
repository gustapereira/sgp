package br.com.sgp.mapper;

import br.com.sgp.domain.Diretoria;
import br.com.sgp.dto.DiretoriaFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiretoriaFuncionarioMapper extends BaseMapper<Diretoria, DiretoriaFuncionarioDTO> {

}
