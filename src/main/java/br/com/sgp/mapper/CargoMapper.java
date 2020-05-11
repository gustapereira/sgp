package br.com.sgp.mapper;

import br.com.sgp.domain.Cargo;
import br.com.sgp.dto.CargoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoMapper extends BaseMapper<Cargo, CargoDTO> {

}
