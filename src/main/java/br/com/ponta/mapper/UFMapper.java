package br.com.ponta.mapper;

import br.com.ponta.domain.UF;
import br.com.ponta.dto.UFDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UFMapper extends BaseMapper<UF, UFDTO> {

}
