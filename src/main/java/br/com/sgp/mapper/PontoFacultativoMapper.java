package br.com.sgp.mapper;

import br.com.sgp.domain.PontoFacultativo;
import br.com.sgp.dto.PontoFacultativoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PontoFacultativoMapper extends BaseMapper<PontoFacultativo, PontoFacultativoDTO> {

}
