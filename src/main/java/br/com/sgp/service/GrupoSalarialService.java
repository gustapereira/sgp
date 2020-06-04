package br.com.sgp.service;

import br.com.sgp.domain.GrupoSalarial;
import br.com.sgp.dto.GrupoSalarialDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.GrupoSalarialMapper;
import br.com.sgp.repository.GrupoSalarialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GrupoSalarialService {

    private final GrupoSalarialRepository repository;
    private final GrupoSalarialMapper mapper;


    public List<GrupoSalarial> listarTodos() {
        return repository.findAll();
    }

    public GrupoSalarial buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Salário não localizado pelo id: " + id)
        );
    }

    public GrupoSalarial salvar(GrupoSalarialDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public GrupoSalarial editar(GrupoSalarialDTO dto) {
        return repository.save(atualizarDados(buscarPeloId(dto.getId()), dto));
    }


    private GrupoSalarial atualizarDados(GrupoSalarial grupoSalarial, GrupoSalarialDTO dto) {
        grupoSalarial.setDescricao(dto.getDescricao() != null ? dto.getDescricao() : grupoSalarial.getDescricao());
        grupoSalarial.setObservacao(dto.getObservacao() != null ? dto.getObservacao() : grupoSalarial.getObservacao());
        grupoSalarial.setPontoFinal(dto.getPontoFinal() != null ? dto.getPontoFinal() : grupoSalarial.getPontoFinal());
        grupoSalarial.setPontoInicial(dto.getPontoInicial() != null ? dto.getPontoInicial() : grupoSalarial.getPontoInicial());
        return grupoSalarial;
    }


}
