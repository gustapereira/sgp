package br.com.sgp.service;

import br.com.sgp.domain.Funcionario;
import br.com.sgp.domain.Secao;
import br.com.sgp.dto.SecaoCadastroDTO;
import br.com.sgp.dto.SecaoDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.SecaoCadastroMapper;
import br.com.sgp.repository.SecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SecaoService {

    private final SecaoRepository repository;
    private final SecaoCadastroMapper cadastroMapper;
    private final SetorService setorService;


    public List<Secao> listarTodos() {
        return repository.findAll();
    }

    public Secao buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Funcionário não localizado pelo id: " + id)
        );
    }

    public Secao salvar(SecaoCadastroDTO dto) {
        Secao secao = cadastroMapper.toEntity(dto);
        secao.setSetor(setorService.buscarPeloId(dto.getIdSetor()));
        return repository.save(secao);
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public Secao editar(SecaoDTO dto) {
        return repository.save(atualizarDadosDoSecao(buscarPeloId(dto.getId()), dto));
    }

    public Secao adicionarFuncionarios(Long idSecao, List<Funcionario> funcionarios) {
        Secao secao = buscarPeloId(idSecao);
        for (Funcionario funcionario : funcionarios) {
            if (!secao.getFuncionarios().contains(funcionario)) {
                secao.getFuncionarios().add(funcionario);
            }
        }
        return repository.save(secao);
    }

    public Secao removerFuncionarios(Long idSecao, List<Funcionario> funcionarios) {
        Secao secao = buscarPeloId(idSecao);
        for (Funcionario funcionario : funcionarios) {
            secao.getFuncionarios().removeIf(f -> (f.getId().equals(funcionario.getId())));
        }
        return repository.save(secao);
    }

    private Secao atualizarDadosDoSecao(Secao secao, SecaoDTO dto) {
        secao.setSetor(dto.getSetor()!=null? dto.getSetor(): secao.getSetor());
        secao.setSecao(dto.getSecao()!=null? dto.getSecao():secao.getSecao());
        return secao;
    }


}
