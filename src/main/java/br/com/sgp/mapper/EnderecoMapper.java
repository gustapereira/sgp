package br.com.sgp.mapper;

import br.com.sgp.domain.Endereco;
import br.com.sgp.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {

}
