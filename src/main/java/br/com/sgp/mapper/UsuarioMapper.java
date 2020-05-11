package br.com.sgp.mapper;

import br.com.sgp.domain.Usuario;
import br.com.sgp.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

}
