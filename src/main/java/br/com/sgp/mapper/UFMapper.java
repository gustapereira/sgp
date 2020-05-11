package br.com.sgp.mapper;

import br.com.sgp.domain.UF;
import br.com.sgp.dto.UFDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UFMapper extends BaseMapper<UF, UFDTO> {

}
