package br.com.sgp.mapper;

import br.com.sgp.domain.FaixaFator;
import br.com.sgp.dto.FaixaFatorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FaixaFatorMapper extends BaseMapper<FaixaFator, FaixaFatorDTO> {

}
