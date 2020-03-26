package br.com.ponta.mapper;

import br.com.ponta.domain.FolhaDePonto;
import br.com.ponta.domain.RegistroEletronico;
import br.com.ponta.dto.FolhaDePontoDTO;
import br.com.ponta.dto.RegistroEletronicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegistroEletronicoMapper extends BaseMapper<RegistroEletronico, RegistroEletronicoDTO> {

}
