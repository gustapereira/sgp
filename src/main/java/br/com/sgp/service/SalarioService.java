package br.com.sgp.service;

import br.com.sgp.domain.Salario;
import br.com.sgp.dto.SalarioDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.SalarioMapper;
import br.com.sgp.repository.SalarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SalarioService {

    private final SalarioRepository repository;
    private final SalarioMapper mapper;


    public List<Salario> listarTodos() {
        return repository.findAll();
    }

    public Salario buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Salário não localizado pelo id: " + id)
        );
    }

    public Salario salvar(SalarioDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public void deletar(Long id) {
        buscarPeloId(id);
        deletar(id);
    }

    public Salario editar(SalarioDTO dto) {
        return repository.save(atualizarDados(buscarPeloId(dto.getId()), dto));
    }


    private Salario atualizarDados(Salario salario, SalarioDTO dto) {
        salario.setValor(dto.getValor() != null ? dto.getValor() : salario.getValor());
        salario.setUsuario(dto.getUsuario() != null ? dto.getUsuario() : salario.getUsuario());
        return salario;
    }


}
