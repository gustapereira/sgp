package br.com.sgp.mapper;

import br.com.sgp.domain.Nacionalidade;
import br.com.sgp.dto.NacionalidadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NacionalidadeMapper extends BaseMapper<Nacionalidade, NacionalidadeDTO> {

}
