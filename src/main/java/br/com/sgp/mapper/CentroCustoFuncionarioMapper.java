package br.com.sgp.mapper;

import br.com.sgp.domain.CentroCusto;
import br.com.sgp.dto.CentroCustoFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CentroCustoFuncionarioMapper extends BaseMapper<CentroCusto, CentroCustoFuncionarioDTO> {

}
