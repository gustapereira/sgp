package br.com.sgp.mapper;

import br.com.sgp.domain.Diretoria;
import br.com.sgp.dto.DiretoriaCadastroDTO;
import br.com.sgp.dto.DiretoriaFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DiretoriaCadastroMapper extends BaseMapper<Diretoria, DiretoriaCadastroDTO> {

}
