package br.com.sgp.service;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.FuncionarioCadastroDTO;
import br.com.sgp.dto.FuncionarioDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.FuncionarioCadastroMapper;
import br.com.sgp.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioCadastroMapper cadastroMapper;
    private final EmpresaService empresaService;
    private final AfastamentoService afastamentoService;

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Funcionário não localizado pelo id: " + id)
        );
    }

    public Funcionario salvar(FuncionarioCadastroDTO dto) {
        Funcionario funcionario = cadastroMapper.toEntity(dto);
        funcionario.setEmpresa(empresaService.buscarPeloId(dto.getIdEmpresa()));
        funcionario.setAfastamento(afastamentoService.buscarPeloId(dto.getIdAfastamento()));
        return repository.save(funcionario);
    }

    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        deletarPeloId(id);
    }

    public Funcionario editar(FuncionarioDTO dto) {
        return repository.save(atualizarDadosDoFuncionario(buscarPeloId(dto.getId()), dto));
    }

    private Funcionario atualizarDadosDoFuncionario(Funcionario funcionario, FuncionarioDTO dto) {
        funcionario.setAdmissao(dto.getAdmissao() != null ? dto.getAdmissao() : funcionario.getAdmissao());
        funcionario.setAfastamento(dto.getAfastamento() != null ? dto.getAfastamento() : funcionario.getAfastamento());
        funcionario.setAposentado(dto.getAposentado() != null ? dto.getAposentado() : funcionario.getAposentado());
        funcionario.setAposEspecial(dto.getAposEspecial() != null ? dto.getAposEspecial() : funcionario.getAposEspecial());
        funcionario.setArea(dto.getArea() != null ? dto.getArea() : funcionario.getArea());
        funcionario.setAposentado(dto.getBeneficiarios() != null ? dto.getBeneficiarios() : funcionario.getBeneficiarios());
        funcionario.setCargo(dto.getCargo() != null ? dto.getCargo() : funcionario.getCargo());
        funcionario.setCategoria(dto.getCategoria() != null ? dto.getCategoria() : funcionario.getCategoria());
        funcionario.setCbo(dto.getCbo() != null ? dto.getCbo() : funcionario.getCbo());
        funcionario.setCidadeRIC(dto.getCidadeRIC() != null ? dto.getCidadeRIC() : funcionario.getCidadeRIC());
        funcionario.setClasseINSS(dto.getClasseINSS() != null ? dto.getClasseINSS() : funcionario.getClasseINSS());
        funcionario.setCNH(dto.getCNH() != null ? dto.getCNH() : funcionario.getCNH());
        funcionario.setCPF(dto.getCPF() != null ? dto.getCPF() : funcionario.getCPF());
        funcionario.setCracha(dto.getCracha() != null ? dto.getCracha() : funcionario.getCracha());
        funcionario.setCsmReservista(dto.getCsmReservista() != null ? dto.getCsmReservista() : funcionario.getCsmReservista());
        funcionario.setData(dto.getData() != null ? dto.getData() : funcionario.getData());
        funcionario.setDiasExperiencia(dto.getDiasExperiencia() != null ? dto.getDiasExperiencia() : funcionario.getDiasExperiencia());
        funcionario.setDiasPorrogacao(dto.getDiasPorrogacao() != null ? dto.getDiasPorrogacao() : funcionario.getDiasPorrogacao());
        funcionario.setDtCTPS(dto.getDtCTPS() != null ? dto.getDtCTPS() : funcionario.getDtCTPS());
        funcionario.setDtEmissaoCNH(dto.getDtEmissaoCNH() != null ? dto.getDtEmissaoCNH() : funcionario.getDtValidadeCNH());
        funcionario.setDtEmissaoPIS(dto.getDtEmissaoPIS() != null ? dto.getDtEmissaoPIS() : funcionario.getDtEmissaoPIS());
        funcionario.setDtEmissaoRIC(dto.getDtEmissaoRIC() != null ? dto.getDtEmissaoRIC() : funcionario.getDtEmissaoRIC());
        funcionario.setDtNascimento(dto.getDtNascimento() != null ? dto.getDtNascimento() : funcionario.getDtNascimento());
        funcionario.setDtReservista(dto.getDtReservista() != null ? dto.getDtReservista() : funcionario.getDtReservista());
        funcionario.setDtRGExpedicao(dto.getDtRGExpedicao() != null ? dto.getDtRGExpedicao() : funcionario.getDtRGExpedicao());
        funcionario.setDtTituloEleitor(dto.getDtTituloEleitor() != null ? dto.getDtTituloEleitor() : funcionario.getDtTituloEleitor());
        funcionario.setIsDeficiente(dto.getIsDeficiente() != null ? dto.getIsDeficiente() : funcionario.getIsDeficiente());
        funcionario.setTypeDeficiencia(dto.getTypeDeficiencia() != null ? dto.getTypeDeficiencia() : funcionario.getTypeDeficiencia());
        funcionario.setFerias(dto.getFerias() != null ? dto.getFerias() : funcionario.getFerias());
        funcionario.setEnderecoFuncionario(dto.getEnderecoFuncionario() != null ? dto.getEnderecoFuncionario() : funcionario.getEnderecoFuncionario());
        funcionario.setEMail(dto.getEMail() != null ? dto.getEMail() : funcionario.getEMail());
        funcionario.setEmpresa(dto.getEmpresa() != null ? dto.getEmpresa() : funcionario.getEmpresa());
        funcionario.setEscolaridade(dto.getEscolaridade() != null ? dto.getEscolaridade() : funcionario.getEscolaridade());
        funcionario.setTelefone(dto.getTelefone() != null ? dto.getTelefone() : funcionario.getTelefone());
        funcionario.setHorario(dto.getHorario() != null ? dto.getHorario() : funcionario.getHorario());
        funcionario.setHorasBase(dto.getHorasBase() != null ? dto.getHorasBase() : funcionario.getHorasBase());
        funcionario.setGrupoAvalDesempenho(dto.getGrupoAvalDesempenho() != null ? dto.getGrupoAvalDesempenho() : funcionario.getGrupoAvalDesempenho());
        funcionario.setGrupoAvalExperiencia(dto.getGrupoAvalExperiencia() != null ? dto.getGrupoAvalExperiencia() : funcionario.getGrupoAvalExperiencia());
        funcionario.setGrupoProfissiografico(dto.getGrupoProfissiografico() != null ? dto.getGrupoProfissiografico() : funcionario.getGrupoProfissiografico());
        funcionario.setNacionalidade(dto.getNacionalidade() != null ? dto.getNacionalidade() : funcionario.getNacionalidade());
        funcionario.setNaturalidade(dto.getNaturalidade() != null ? dto.getNaturalidade() : funcionario.getNaturalidade());
        funcionario.setNome(dto.getNome() != null ? dto.getNome() : funcionario.getNome());
        funcionario.setNomeCompleto(dto.getNomeCompleto() != null ? dto.getNomeCompleto() : funcionario.getNomeCompleto());
        funcionario.setNomeMae(dto.getNomeMae() != null ? dto.getNomeMae() : funcionario.getNomeMae());
        funcionario.setNomePai(dto.getNomePai() != null ? dto.getNomePai() : funcionario.getNomePai());
        funcionario.setNumINSS(dto.getNumINSS() != null ? dto.getNumINSS() : funcionario.getNumPIS());
        funcionario.setNumReservista(dto.getNumReservista() != null ? dto.getNumReservista() : funcionario.getNumReservista());
        funcionario.setNumRIC(dto.getNumRIC() != null ? dto.getNumRIC() : funcionario.getNumRIC());
        funcionario.setNumPIS(dto.getNumPIS() != null ? dto.getNumPIS() : funcionario.getNumPIS());
        funcionario.setNumTituloEleitor(dto.getNumTituloEleitor() != null ? dto.getNumTituloEleitor() : funcionario.getNumTituloEleitor());
        funcionario.setNumSecaoTituloEleitor(dto.getNumSecaoTituloEleitor() != null ? dto.getNumSecaoTituloEleitor() : funcionario.getNumSecaoTituloEleitor());
        funcionario.setNumZonaTituloEleitor(dto.getNumZonaTituloEleitor() != null ? dto.getNumZonaTituloEleitor() : funcionario.getNumZonaTituloEleitor());
        funcionario.setObservacoesPPP(dto.getObservacoesPPP() != null ? dto.getObservacoesPPP() : funcionario.getObservacoesPPP());
        funcionario.setOrgaoRIC(dto.getOrgaoRIC() != null ? dto.getOrgaoRIC() : funcionario.getOrgaoRIC());
        funcionario.setRgOrgao(dto.getRgOrgao() != null ? dto.getRgOrgao() : funcionario.getRgOrgao());
        funcionario.setProximoExame(dto.getProximoExame() != null ? dto.getProximoExame() : funcionario.getProximoExame());
        funcionario.setRaReservista(dto.getRaReservista() != null ? dto.getRaReservista() : funcionario.getRaReservista());
        funcionario.setRevezamento(dto.getRevezamento() != null ? dto.getRevezamento() : funcionario.getRevezamento());
        funcionario.setSalario(dto.getSalario() != null ? dto.getSalario() : funcionario.getSalario());
        funcionario.setSerieCTPS(dto.getSerieCTPS() != null ? dto.getSerieCTPS() : funcionario.getCTPS());
        funcionario.setSerieReservista(dto.getSerieReservista() != null ? dto.getSerieReservista() : funcionario.getSerieReservista());
        funcionario.setTypeCatTrabalhador(dto.getTypeCatTrabalhador() != null ? dto.getTypeCatTrabalhador() : funcionario.getTypeCatTrabalhador());
        funcionario.setTypeEstadoCivil(dto.getTypeEstadoCivil() != null ? dto.getTypeEstadoCivil() : funcionario.getTypeEstadoCivil());
        funcionario.setTypeRaca(dto.getTypeRaca() != null ? dto.getTypeRaca() : funcionario.getTypeRaca());
        funcionario.setTypeSalario(dto.getTypeSalario() != null ? dto.getTypeSalario() : funcionario.getTypeSalario());
        funcionario.setTypeSexo(dto.getTypeSexo() != null ? dto.getTypeSexo() : funcionario.getTypeSexo());
        funcionario.setUfCTPS(dto.getUfCTPS() != null ? dto.getUfCTPS() : funcionario.getUfCTPS());
        funcionario.setUfNascimento(dto.getUfNascimento() != null ? dto.getUfNascimento() : funcionario.getUfNascimento());
        funcionario.setUfRG(dto.getUfRG() != null ? dto.getUfRG() : funcionario.getUfRG());
        funcionario.setUfRIC(dto.getUfRIC() != null ? dto.getUfRIC() : funcionario.getUfRIC());
        funcionario.setUfTituloEleitor(dto.getUfTituloEleitor() != null ? dto.getUfTituloEleitor() : funcionario.getUfTituloEleitor());
        funcionario.setDtValidadeCNH(dto.getDtValidadeCNH() != null ? dto.getDtValidadeCNH() : funcionario.getDtValidadeCNH());
        funcionario.setDtValidadeRIC(dto.getDtValidadeRIC() != null ? dto.getDtValidadeRIC() : funcionario.getDtValidadeRIC());
        return funcionario;
    }


}
