package br.com.sgp.service;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.domain.Setor;
import br.com.sgp.dto.SetorCadastroDTO;
import br.com.sgp.dto.SetorDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.SetorCadastroMapper;
import br.com.sgp.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository repository;
    private final SetorCadastroMapper cadastroMapper;
    private final DepartamentoService departamentoService;


    public List<Setor> listarTodos() {
        return repository.findAll();
    }

    public Setor buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Funcionário não localizado pelo id: " + id)
        );
    }

    public Setor salvar(SetorCadastroDTO dto) {
        Setor setor = cadastroMapper.toEntity(dto);
        setor.setDepartamento(departamentoService.buscarPeloId(dto.getIdDepartamento()));
        return repository.save(setor);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public Setor editar(SetorDTO dto) {
        return repository.save(atualizarDadosDoSetor(buscarPeloId(dto.getId()), dto));
    }

    public Setor adicionarFuncionarios(Long idSetor, List<Funcionario> funcionarios) {
        Setor setor = buscarPeloId(idSetor);
        for (Funcionario funcionario : funcionarios) {
            if (!setor.getFuncionarios().contains(funcionario)) {
                setor.getFuncionarios().add(funcionario);
            }
        }
        return repository.save(setor);
    }

    public Setor removerFuncionarios(Long idSetor, List<Funcionario> funcionarios) {
        Setor setor = buscarPeloId(idSetor);
        for (Funcionario funcionario : funcionarios) {
            setor.getFuncionarios().removeIf(f -> (f.getId().equals(funcionario.getId())));
        }
        return repository.save(setor);
    }

    private Setor atualizarDadosDoSetor(Setor setor, SetorDTO dto) {
        setor.setSetor(dto.getSetor()!=null? dto.getSetor(): setor.getSetor());
        setor.setDepartamento(dto.getDepartamento()!=null? dto.getDepartamento(): setor.getDepartamento());
        return setor;
    }


}
