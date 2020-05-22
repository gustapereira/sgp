package br.com.sgp.service;

import br.com.sgp.domain.Diretoria;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.DiretoriaCadastroDTO;
import br.com.sgp.dto.DiretoriaDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.DiretoriaCadastroMapper;
import br.com.sgp.repository.DiretoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DiretoriaService {

    private final DiretoriaRepository repository;
    private final DiretoriaCadastroMapper cadastroMapper;
    private final EmpresaService empresaService;


    public List<Diretoria> listarTodos() {
        return repository.findAll();
    }

    public Diretoria buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Funcionário não localizado pelo id: " + id)
        );
    }

    public Diretoria salvar(DiretoriaCadastroDTO dto) {
        Diretoria diretoria = cadastroMapper.toEntity(dto);
        diretoria.setEmpresa(empresaService.buscarPeloId(dto.getIdEmpresa()));
        return repository.save(diretoria);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public Diretoria editar(DiretoriaDTO dto) {
        return repository.save(atualizarDadosDoDiretoria(buscarPeloId(dto.getId()), dto));
    }

    public Diretoria adicionarFuncionarios(Long idDiretoria, List<Funcionario> funcionarios) {
        Diretoria diretoria = buscarPeloId(idDiretoria);
        for (Funcionario funcionario : funcionarios) {
            if (!diretoria.getFuncionarios().contains(funcionario)) {
                diretoria.getFuncionarios().add(funcionario);
            }
        }
        return repository.save(diretoria);
    }

    public Diretoria removerFuncionarios(Long idDiretoria, List<Funcionario> funcionarios) {
        Diretoria diretoria = buscarPeloId(idDiretoria);
        for (Funcionario funcionario : funcionarios) {
            diretoria.getFuncionarios().removeIf(f -> (f.getId().equals(funcionario.getId())));
        }
        return repository.save(diretoria);
    }

    private Diretoria atualizarDadosDoDiretoria(Diretoria diretoria, DiretoriaDTO dto) {
        diretoria.setEmpresa(dto.getEmpresa()!=null? dto.getEmpresa(): diretoria.getEmpresa());
        diretoria.setDiretoria(dto.getDiretoria()!=null? dto.getDiretoria(): diretoria.getDiretoria());
        return diretoria;
    }


}
