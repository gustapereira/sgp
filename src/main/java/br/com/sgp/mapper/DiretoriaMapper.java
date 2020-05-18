package br.com.sgp.mapper;

import br.com.sgp.domain.Departamento;
import br.com.sgp.domain.Diretoria;
import br.com.sgp.dto.DepartamentoDTO;
import br.com.sgp.dto.DiretoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiretoriaMapper extends BaseMapper<Diretoria, DiretoriaDTO> {

}
