package br.com.sgp.mapper;

import br.com.sgp.domain.HierarquiaExterna;
import br.com.sgp.domain.Horario;
import br.com.sgp.dto.HierarquiaExternaDTO;
import br.com.sgp.dto.HorarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HorarioMapper extends BaseMapper<Horario, HorarioDTO> {

}
