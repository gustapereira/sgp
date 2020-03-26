package br.com.ponta.mapper;

import br.com.ponta.domain.Empresa;
import br.com.ponta.domain.Endereco;
import br.com.ponta.dto.EmpresaDTO;
import br.com.ponta.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {

}
