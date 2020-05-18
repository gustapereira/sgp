package br.com.sgp.mapper;

import br.com.sgp.domain.Usuario;
import br.com.sgp.dto.UsuarioFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioFuncionarioMapper extends BaseMapper<Usuario, UsuarioFuncionarioDTO> {

}
