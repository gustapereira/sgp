package br.com.sgp.mapper;

import br.com.sgp.domain.GrupoSalarial;
import br.com.sgp.dto.GrupoSalarialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GrupoSalarialMapper extends BaseMapper<GrupoSalarial, GrupoSalarialDTO> {

}
