package br.com.sgp.service;

import br.com.sgp.domain.QuadroFuncionario;
import br.com.sgp.dto.QuadroFuncionarioCadastroDTO;
import br.com.sgp.dto.QuadroFuncionarioDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.QuadroFuncionarioCadastroMapper;
import br.com.sgp.mapper.QuadroFuncionarioMapper;
import br.com.sgp.repository.QuadroFuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class QuadroFuncionarioService {

    private final QuadroFuncionarioRepository repository;
    private final QuadroFuncionarioCadastroMapper cadastroMapper;
    private final CentroCustoService centroCustoService;
    private final DiretoriaService diretoriaService;
    private final EmpresaService empresaService;
    private final DepartamentoService departamentoService;
    private final SetorService setorService;
    private final SecaoService secaoService;


    public List<QuadroFuncionario> listarTodos() {
        return repository.findAll();
    }

    public QuadroFuncionario buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Salário não localizado pelo id: " + id)
        );
    }

    public QuadroFuncionario salvar(QuadroFuncionarioCadastroDTO dto) {
        QuadroFuncionario quadroFuncionario = cadastroMapper.toEntity(dto);
        quadroFuncionario.setCentroCusto(centroCustoService.buscarPeloId(dto.getIdCentroCusto()));
        quadroFuncionario.setDiretoria(diretoriaService.buscarPeloId(dto.getIdDiretoria()));
        quadroFuncionario.setEmpresa(empresaService.buscarPeloId(dto.getIdEmpresa()));
        quadroFuncionario.setDepartamento(departamentoService.buscarPeloId(dto.getIdDepartamento()));
        quadroFuncionario.setSetor(setorService.buscarPeloId(dto.getIdSetor()));
        quadroFuncionario.setSecao(secaoService.buscarPeloId(dto.getIdSecao()));

        return repository.save(quadroFuncionario);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public QuadroFuncionario editar(QuadroFuncionarioDTO dto) {
        return repository.save(atualizarDados(buscarPeloId(dto.getId()), dto));
    }


    private QuadroFuncionario atualizarDados(QuadroFuncionario quadroFuncionario, QuadroFuncionarioDTO dto) {
        quadroFuncionario.setCargo(dto.getCargo() != null ? dto.getCargo() : quadroFuncionario.getCargo());
        quadroFuncionario.setCentroCusto(dto.getCentroCusto() != null ? dto.getCentroCusto() : quadroFuncionario.getCentroCusto());
        quadroFuncionario.setDepartamento(dto.getDepartamento() != null ? dto.getDepartamento() : quadroFuncionario.getDepartamento());
        quadroFuncionario.setDiretoria(dto.getDiretoria() != null ? dto.getDiretoria() : quadroFuncionario.getDiretoria());
        quadroFuncionario.setEmpresa(dto.getEmpresa() != null ? dto.getEmpresa() : quadroFuncionario.getEmpresa());
        quadroFuncionario.setPrevisto(dto.getPrevisto() != null ? dto.getPrevisto() : quadroFuncionario.getPrevisto());
        quadroFuncionario.setDiretoria(dto.getDiretoria() != null ? dto.getDiretoria() : quadroFuncionario.getDiretoria());
        quadroFuncionario.setCentroCusto(dto.getCentroCusto() != null ? dto.getCentroCusto() : quadroFuncionario.getCentroCusto());
        quadroFuncionario.setReal(dto.getReal() != null ? dto.getReal() : quadroFuncionario.getReal());
        quadroFuncionario.setSecao(dto.getSecao() != null ? dto.getSecao() : quadroFuncionario.getSecao());
        quadroFuncionario.setVago(dto.getVago() != null ? dto.getVago() : quadroFuncionario.getVago());
        return quadroFuncionario;
    }


}
