package br.com.sgp.mapper;

import br.com.sgp.domain.Afastamento;
import br.com.sgp.dto.AfastamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AfastamentoMapper extends BaseMapper<Afastamento, AfastamentoDTO> {

}
