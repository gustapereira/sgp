package br.com.ponta.service;

import br.com.ponta.domain.Endereco;
import br.com.ponta.domain.TypeStatus;
import br.com.ponta.domain.Usuario;
import br.com.ponta.dto.EmpresaDTO;
import br.com.ponta.exception.CampoObrigatorioException;
import br.com.ponta.exception.NaoEncontradoException;
import br.com.ponta.exception.OperacaoException;
import br.com.ponta.repository.EmpresaRepository;
import br.com.ponta.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final MessageSource messageSource;

    public EmpresaService(EmpresaRepository empresaRepository, MessageSource messageSource) {
        this.empresaRepository = empresaRepository;
        this.messageSource = messageSource;
    }

    protected String getMessage(String key, String... values) {
        return messageSource.getMessage(key, values, Locale.getDefault());
    }

    public EmpresaDTO salvar(final EmpresaDTO empresa) {
        return empresaRepository.save(empresa);
    }

    public List<EmpresaDTO> findAll() {
        return empresaRepository.findAll();
    }

    @Transactional
    public EmpresaDTO atualizar(EmpresaDTO empresa) throws OperacaoException {
        if (empresa.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<EmpresaDTO> optionalEmpresa = empresaRepository.findById(empresa.getId());
        if (!optionalEmpresa.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        empresa = atualizaCard(empresa, optionalEmpresa.get());
        return empresaRepository.save(empresa);
    }

    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<EmpresaDTO> optionalCard = empresaRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        empresaRepository.delete(optionalCard.get());
    }

    public EmpresaDTO atualizaCard(EmpresaDTO empresa, EmpresaDTO saved) {

        String nomeFantasia = empresa.getNomeFantasia() != null ? empresa.getNomeFantasia() : saved.getNomeFantasia();
        String cnae = empresa.getCNAE() != null ? empresa.getCNAE() : saved.getCNAE();
        String cnpj = empresa.getCnpj() != null ? empresa.getCnpj() : saved.getCnpj();
        String razaoSocial = empresa.getRazaoSocial() != null ? empresa.getRazaoSocial() : saved.getRazaoSocial();
        Endereco endereco = empresa.getEndereco() != null ? empresa.getEndereco() : saved.getEndereco();
        Usuario responsavel = empresa.getResponsavel() != null ? empresa.getResponsavel() : saved.getResponsavel();
        TypeStatus typeStatus = empresa.getTypeStatus() != null ? empresa.getTypeStatus() : saved.getTypeStatus();

        empresa.setCNAE(cnae);
        empresa.setNomeFantasia(nomeFantasia);
        empresa.setCnpj(cnpj);
        empresa.setRazaoSocial(razaoSocial);
        empresa.setEndereco(endereco);
        empresa.setResponsavel(responsavel);
        empresa.setTypeStatus(typeStatus);

        return empresa;
    }

}
