package br.com.sgp.mapper;

import br.com.sgp.domain.HierarquiaExterna;
import br.com.sgp.dto.HierarquiaExternaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HierarquiaExternaMapper extends BaseMapper<HierarquiaExterna, HierarquiaExternaDTO> {

}
