package br.com.sgp.service;

import br.com.sgp.domain.FolhaDePonto;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.FolhaDePontoDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.FolhaDePontoMapper;
import br.com.sgp.repository.FolhaDePontoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FolhaDePontoService {

    private final FolhaDePontoRepository repository;
    private final FolhaDePontoMapper mapper;

    public List<FolhaDePonto> listarTodos() {
        return repository.findAll();
    }

    public FolhaDePonto buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Funcionário não localizado pelo id: " + id)
        );
    }

    public FolhaDePonto salvar(FolhaDePontoDTO dto) {
        FolhaDePonto folhaDePonto = mapper.toEntity(dto);
        return repository.save(folhaDePonto);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public FolhaDePonto editar(FolhaDePontoDTO dto) {
        return repository.save(atualizarDadosDoFolhaDePonto(buscarPeloId(dto.getId()), dto));
    }

    public FolhaDePonto adicionarFuncionarios(Long idFolhaDePonto, List<Funcionario> funcionarios) {
        FolhaDePonto folhaDePonto = buscarPeloId(idFolhaDePonto);
        for (Funcionario funcionario : funcionarios) {
            if (!folhaDePonto.getFuncionarios().contains(funcionario)) {
                folhaDePonto.getFuncionarios().add(funcionario);
            }
        }
        return repository.save(folhaDePonto);
    }

    public FolhaDePonto removerFuncionarios(Long idFolhaDePonto, List<Funcionario> funcionarios) {
        FolhaDePonto folhaDePonto = buscarPeloId(idFolhaDePonto);
        for (Funcionario funcionario : funcionarios) {
            folhaDePonto.getFuncionarios().removeIf(f -> (f.getId().equals(funcionario.getId())));
        }
        return repository.save(folhaDePonto);
    }

    private FolhaDePonto atualizarDadosDoFolhaDePonto(FolhaDePonto folhaDePonto, FolhaDePontoDTO dto) {

        return folhaDePonto;
    }


}
