package br.com.sgp.mapper;

import br.com.sgp.domain.CBO;
import br.com.sgp.dto.CBODTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CBOMapper extends BaseMapper<CBO, CBODTO> {

}
