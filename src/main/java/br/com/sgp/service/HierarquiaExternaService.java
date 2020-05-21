package br.com.sgp.service;

import br.com.sgp.domain.HierarquiaExterna;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.HierarquiaExternaCadastroDTO;
import br.com.sgp.dto.HierarquiaExternaDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.HierarquiaExternaCadastroMapper;
import br.com.sgp.repository.HierarquiaExternaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class HierarquiaExternaService {

    private final HierarquiaExternaRepository repository;
    private final HierarquiaExternaCadastroMapper cadastroMapper;
    private final EmpresaService empresaService;


    public List<HierarquiaExterna> listarTodos() {
        return repository.findAll();
    }

    public HierarquiaExterna buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Funcionário não localizado pelo id: " + id)
        );
    }

    public HierarquiaExterna salvar(HierarquiaExternaCadastroDTO dto) {
        HierarquiaExterna hierarquiaExterna = cadastroMapper.toEntity(dto);
        hierarquiaExterna.setEmpresa(empresaService.buscarPeloId(dto.getIdEmpresa()));
        return repository.save(hierarquiaExterna);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public HierarquiaExterna editar(HierarquiaExternaDTO dto) {
        return repository.save(atualizarDadosDoHierarquiaExterna(buscarPeloId(dto.getId()), dto));
    }

    public HierarquiaExterna adicionarFuncionarios(Long idHierarquiaExterna, List<Funcionario> funcionarios) {
        HierarquiaExterna hierarquiaExterna = buscarPeloId(idHierarquiaExterna);
        for (Funcionario funcionario : funcionarios) {
            if (!hierarquiaExterna.getFuncionarios().contains(funcionario)) {
                hierarquiaExterna.getFuncionarios().add(funcionario);
            }
        }
        return repository.save(hierarquiaExterna);
    }

    public HierarquiaExterna removerFuncionarios(Long idHierarquiaExterna, List<Funcionario> funcionarios) {
        HierarquiaExterna hierarquiaExterna = buscarPeloId(idHierarquiaExterna);
        for (Funcionario funcionario : funcionarios) {
            hierarquiaExterna.getFuncionarios().removeIf(f -> (f.getId().equals(funcionario.getId())));
        }
        return repository.save(hierarquiaExterna);
    }

    private HierarquiaExterna atualizarDadosDoHierarquiaExterna(HierarquiaExterna hierarquiaExterna, HierarquiaExternaDTO dto) {

        return hierarquiaExterna;
    }


}
