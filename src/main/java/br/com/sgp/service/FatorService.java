package br.com.sgp.service;

import br.com.sgp.domain.Fator;
import br.com.sgp.dto.FatorDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.FatorMapper;
import br.com.sgp.repository.FatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FatorService {

    private final FatorRepository repository;
    private final FatorMapper mapper;


    public List<Fator> listarTodos() {
        return repository.findAll();
    }

    public Fator buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Salário não localizado pelo id: " + id)
        );
    }

    public Fator salvar(FatorDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public Fator editar(FatorDTO dto) {
        return repository.save(atualizarDados(buscarPeloId(dto.getId()), dto));
    }


    private Fator atualizarDados(Fator fator, FatorDTO dto) {
        fator.setDescricao(dto.getDescricao() != null ? dto.getDescricao() : fator.getDescricao());
        fator.setNome(dto.getNome() != null ? dto.getNome() : fator.getNome());
        return fator;
    }


}
