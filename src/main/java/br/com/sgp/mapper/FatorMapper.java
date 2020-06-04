package br.com.sgp.mapper;

import br.com.sgp.domain.Fator;
import br.com.sgp.dto.FatorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FatorMapper extends BaseMapper<Fator, FatorDTO> {

}
