package br.com.ponta.mapper;

import br.com.ponta.domain.CentroCusto;
import br.com.ponta.dto.CentroCustoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CentroCustoMapper extends BaseMapper<CentroCusto, CentroCustoDTO> {

}
