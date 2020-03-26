package br.com.ponta.mapper;

import br.com.ponta.domain.Endereco;
import br.com.ponta.domain.FolhaDePonto;
import br.com.ponta.dto.EnderecoDTO;
import br.com.ponta.dto.FolhaDePontoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FolhaDePontoMapper extends BaseMapper<FolhaDePonto, FolhaDePontoDTO> {

}
