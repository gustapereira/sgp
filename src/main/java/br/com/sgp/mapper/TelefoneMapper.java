package br.com.sgp.mapper;

import br.com.sgp.domain.Telefone;
import br.com.sgp.dto.TelefoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TelefoneMapper extends BaseMapper<Telefone, TelefoneDTO> {

}
