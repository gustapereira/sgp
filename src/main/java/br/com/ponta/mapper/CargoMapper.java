package br.com.ponta.mapper;

import br.com.ponta.domain.Cargo;
import br.com.ponta.dto.CargoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoMapper extends BaseMapper<Cargo, CargoDTO> {

}
