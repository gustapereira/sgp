package br.com.ponta.mapper;

import br.com.ponta.domain.UF;
import br.com.ponta.domain.Usuario;
import br.com.ponta.dto.UFDTO;
import br.com.ponta.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

}
