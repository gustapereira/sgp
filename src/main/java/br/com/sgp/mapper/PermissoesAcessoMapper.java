package br.com.sgp.mapper;

import br.com.sgp.domain.PermissoesAcesso;
import br.com.sgp.dto.PermissoesAcessoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissoesAcessoMapper extends BaseMapper<PermissoesAcesso, PermissoesAcessoDTO> {

}
