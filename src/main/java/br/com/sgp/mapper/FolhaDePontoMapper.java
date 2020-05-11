package br.com.sgp.mapper;

import br.com.sgp.domain.FolhaDePonto;
import br.com.sgp.dto.FolhaDePontoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FolhaDePontoMapper extends BaseMapper<FolhaDePonto, FolhaDePontoDTO> {

}
