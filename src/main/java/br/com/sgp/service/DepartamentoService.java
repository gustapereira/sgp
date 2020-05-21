package br.com.sgp.service;

import br.com.sgp.domain.Departamento;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.DepartamentoCadastroDTO;
import br.com.sgp.dto.DepartamentoDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.DepartamentoCadastroMapper;
import br.com.sgp.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final DepartamentoCadastroMapper cadastroMapper;
    private final DiretoriaService diretoriaService;


    public List<Departamento> listarTodos() {
        return repository.findAll();
    }

    public Departamento buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Funcionário não localizado pelo id: " + id)
        );
    }

    public Departamento salvar(DepartamentoCadastroDTO dto) {
        Departamento departamento = cadastroMapper.toEntity(dto);
        departamento.setDiretoria(diretoriaService.buscarPeloId(dto.getIdDiretoria()));
        return repository.save(departamento);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public Departamento editar(DepartamentoDTO dto) {
        return repository.save(atualizarDadosDoDepartamento(buscarPeloId(dto.getId()), dto));
    }

    public Departamento adicionarFuncionarios(Long idDepartamento, List<Funcionario> funcionarios) {
        Departamento departamento = buscarPeloId(idDepartamento);
        for (Funcionario funcionario : funcionarios) {
            if (!departamento.getFuncionarios().contains(funcionario)) {
                departamento.getFuncionarios().add(funcionario);
            }
        }
        return repository.save(departamento);
    }

    public Departamento removerFuncionarios(Long idDepartamento, List<Funcionario> funcionarios) {
        Departamento departamento = buscarPeloId(idDepartamento);
        for (Funcionario funcionario : funcionarios) {
            departamento.getFuncionarios().removeIf(f -> (f.getId().equals(funcionario.getId())));
        }
        return repository.save(departamento);
    }

    private Departamento atualizarDadosDoDepartamento(Departamento departamento, DepartamentoDTO dto) {

        return departamento;
    }


}
