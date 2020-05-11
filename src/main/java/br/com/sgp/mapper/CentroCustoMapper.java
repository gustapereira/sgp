package br.com.sgp.mapper;

import br.com.sgp.domain.CentroCusto;
import br.com.sgp.dto.CentroCustoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CentroCustoMapper extends BaseMapper<CentroCusto, CentroCustoDTO> {

}
