package br.com.sgp.service;

import br.com.sgp.domain.*;
import br.com.sgp.enums.*;
import br.com.sgp.exception.CampoObrigatorioException;
import br.com.sgp.exception.NaoEncontradoException;
import br.com.sgp.exception.OperacaoException;
import br.com.sgp.repository.EmpresaRepository;
import br.com.sgp.util.MensagemConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    public Empresa salvar(final Empresa empresa) {
        return empresaRepository.save(empresa);
    }


    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }


    @Transactional
    public Empresa atualizar(Empresa empresa) throws OperacaoException {
        if (empresa.getId() == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }

        Optional<Empresa> optionalEmpresa = empresaRepository.findById(empresa.getId());
        if (!optionalEmpresa.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }

        empresa = atualizaCard(empresa, optionalEmpresa.get());
        return empresaRepository.save(empresa);
    }


    public Empresa atualizaCard(Empresa empresa, Empresa saved) {

        String atividadePrincipal = empresa.getAtividadePrincipal() != null ? empresa.getAtividadePrincipal() : saved.getAtividadePrincipal();
        String brPDH = empresa.getBrPDH() != null ? empresa.getBrPDH() : saved.getBrPDH();
        String ceo = empresa.getCEO() != null ? empresa.getCEO() : saved.getCEO();
        String cnae = empresa.getCNAE() != null ? empresa.getCNAE() : saved.getCNAE();
        String cnpj = empresa.getCnpj() != null ? empresa.getCnpj() : saved.getCnpj();
        String codigoEncerramento = empresa.getCodigoEncerramentoEmpresa() != null ? empresa.getCodigoEncerramentoEmpresa() : saved.getCodigoEncerramentoEmpresa();
        String direcaoGeral = empresa.getDirecaoGeral() != null ? empresa.getDirecaoGeral() : saved.getDirecaoGeral();
        String logoMarca = empresa.getLogoMarca() != null ? empresa.getLogoMarca() : saved.getLogoMarca();
        String nomeFantasia = empresa.getNomeFantasia() != null ? empresa.getNomeFantasia() : saved.getNomeFantasia();
        String numeroDocumento = empresa.getNumeroDocumento() != null ? empresa.getNumeroDocumento() : saved.getNumeroDocumento();
        String razaoSocial = empresa.getRazaoSocial() != null ? empresa.getRazaoSocial() : saved.getRazaoSocial();
        Date dtFinalAtividade = empresa.getDtFinalAtividade() != null ? empresa.getDtFinalAtividade() : saved.getDtFinalAtividade();
        Date dtInicioAtividade = empresa.getDtInicioAtividade() != null ? empresa.getDtInicioAtividade() : saved.getDtInicioAtividade();
        Endereco end = empresa.getEndereco() != null ? empresa.getEndereco() : saved.getEndereco();
        Usuario usuario = empresa.getResponsavel() != null ? empresa.getResponsavel() : saved.getResponsavel();
        Telefone telefone = empresa.getTelefone() != null ? empresa.getTelefone() : saved.getTelefone();
        TypeDocumento typeDocumento = empresa.getTypeDocumento() != null ? empresa.getTypeDocumento() : saved.getTypeDocumento();
        TypeEmpresa typeEmpresa = empresa.getTypeEmpresa() != null ? empresa.getTypeEmpresa() : saved.getTypeEmpresa();
        TypeIRRF typeIRRF = empresa.getTypeIRRF() != null ? empresa.getTypeIRRF() : saved.getTypeIRRF();
        TypeVinculo typeVinculo = empresa.getTypeVinculo() != null ? empresa.getTypeVinculo() : saved.getTypeVinculo();
        TypeStatus typeStatus = empresa.getTypeStatus() != null ? empresa.getTypeStatus() : saved.getTypeStatus();


        empresa.setAtividadePrincipal(atividadePrincipal);
        empresa.setBrPDH(brPDH);
        empresa.setCEO(ceo);
        empresa.setCnpj(cnpj);
        empresa.setCNAE(cnae);
        empresa.setCodigoEncerramentoEmpresa(codigoEncerramento);
        empresa.setDirecaoGeral(direcaoGeral);
        empresa.setDtFinalAtividade(dtFinalAtividade);
        empresa.setDtInicioAtividade(dtInicioAtividade);
        empresa.setEndereco(end);
        empresa.setLogoMarca(logoMarca);
        empresa.setNomeFantasia(nomeFantasia);
        empresa.setRazaoSocial(razaoSocial);
        empresa.setResponsavel(usuario);
        empresa.setTelefone(telefone);
        empresa.setTypeDocumento(typeDocumento);
        empresa.setTypeEmpresa(typeEmpresa);
        empresa.setTypeIRRF(typeIRRF);
        empresa.setTypeStatus(typeStatus);
        empresa.setTypeVinculo(typeVinculo);
        empresa.setTypeVinculo(typeVinculo);


        return empresa;
    }


    public void deletar(Long id) throws OperacaoException {
        if (id == null) {
            throw new CampoObrigatorioException(getMessage(MensagemConstant.EXCEPTION_CAMPO_OBRIGATORIO, MensagemConstant.RESOURCE_CARD));
        }
        Optional<Empresa> optionalCard = empresaRepository.findById(id);
        if (!optionalCard.isPresent()) {
            throw new NaoEncontradoException(getMessage(MensagemConstant.EXCEPTION_NAO_ENCONTRADO, MensagemConstant.RESOURCE_CARD));
        }
        empresaRepository.delete(optionalCard.get());
    }

}
