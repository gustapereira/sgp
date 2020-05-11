package br.com.sgp.mapper;

import br.com.sgp.domain.Secao;
import br.com.sgp.dto.SecaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SecaoMapper extends BaseMapper<Secao, SecaoDTO> {

}
