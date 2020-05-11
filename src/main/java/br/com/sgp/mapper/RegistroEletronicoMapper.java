package br.com.sgp.mapper;

import br.com.sgp.domain.RegistroEletronico;
import br.com.sgp.dto.RegistroEletronicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegistroEletronicoMapper extends BaseMapper<RegistroEletronico, RegistroEletronicoDTO> {

}
