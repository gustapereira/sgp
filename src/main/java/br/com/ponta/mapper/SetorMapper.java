package br.com.ponta.mapper;

import br.com.ponta.domain.Secao;
import br.com.ponta.domain.Setor;
import br.com.ponta.dto.SecaoDTO;
import br.com.ponta.dto.SetorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SetorMapper extends BaseMapper<Setor, SetorDTO> {

}
