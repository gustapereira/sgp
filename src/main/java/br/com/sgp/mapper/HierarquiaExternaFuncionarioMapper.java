package br.com.sgp.mapper;

import br.com.sgp.domain.HierarquiaExterna;
import br.com.sgp.dto.HierarquiaExternaFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HierarquiaExternaFuncionarioMapper extends BaseMapper<HierarquiaExterna, HierarquiaExternaFuncionarioDTO> {

}
