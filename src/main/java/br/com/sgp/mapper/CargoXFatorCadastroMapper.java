package br.com.sgp.mapper;

import br.com.sgp.domain.CargoXFator;
import br.com.sgp.dto.CargoXFatorCadastroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoXFatorCadastroMapper extends BaseMapper<CargoXFator, CargoXFatorCadastroDTO> {

}
