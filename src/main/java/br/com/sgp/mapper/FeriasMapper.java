package br.com.sgp.mapper;

import br.com.sgp.domain.Ferias;
import br.com.sgp.dto.FeriasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeriasMapper extends BaseMapper<Ferias, FeriasDTO> {

}
