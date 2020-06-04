package br.com.sgp.service;

import br.com.sgp.domain.FaixaFator;
import br.com.sgp.dto.FaixaFatorDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.FaixaFatorMapper;
import br.com.sgp.repository.FaixaFatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FaixaFatorService {

    private final FaixaFatorRepository repository;
    private final FaixaFatorMapper mapper;


    public List<FaixaFator> listarTodos() {
        return repository.findAll();
    }

    public FaixaFator buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Salário não localizado pelo id: " + id)
        );
    }

    public FaixaFator salvar(FaixaFatorDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public FaixaFator editar(FaixaFatorDTO dto) {
        return repository.save(atualizarDados(buscarPeloId(dto.getId()), dto));
    }


    private FaixaFator atualizarDados(FaixaFator fator, FaixaFatorDTO dto) {
        fator.setNome(dto.getNome() != null ? dto.getNome() : fator.getNome());
        fator.setPontos(dto.getPontos() != null ? dto.getPontos() : fator.getPontos());
        return fator;
    }


}
