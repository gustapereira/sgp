package br.com.sgp.service;


import br.com.sgp.domain.CentroCusto;
import br.com.sgp.domain.Funcionario;
import br.com.sgp.dto.CentroCustoFuncionarioDTO;
import br.com.sgp.exception.ObjectNotFoundException;
import br.com.sgp.mapper.CentroCustoFuncionarioMapper;
import br.com.sgp.mapper.CentroCustoMapper;
import br.com.sgp.repository.CentroCustoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CentroCustoService {

    private final CentroCustoRepository centroCustoRepository;
    private final CentroCustoMapper centroCustoMapper;
    private final CentroCustoFuncionarioMapper centroCustoFuncionarioMapper;


    public CentroCusto buscarPeloId(Long id) {
        Optional<CentroCusto> optionalCentroCusto = centroCustoRepository.findById(id);
        return optionalCentroCusto.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não econtrado pelo ID:" + id
        ));
    }

    @Transactional
    public CentroCusto salvar(final CentroCustoFuncionarioDTO dto) {
        CentroCusto centroCusto = centroCustoFuncionarioMapper.toEntity(dto);
        //Tem que ajustar quando tiver o metodo de buscar funcionario
        List<Funcionario> funcionarios = new ArrayList<>();
        centroCusto.setDescricao(centroCusto.getDescricao());
        centroCusto.setFuncionarios(funcionarios);
        return centroCustoRepository.save(centroCusto);
    }

    public CentroCusto editar(CentroCustoFuncionarioDTO dto) {
        CentroCusto centroCusto = buscarPeloId(dto.getId());
        centroCusto.setDescricao(dto.getDescricao());
        centroCusto.setFuncionarios(dto.getFuncionarios());
        return centroCustoRepository.save(centroCusto);
    }


    public List<CentroCusto> listarTudo() {
        List<CentroCusto> centroCustos = centroCustoRepository.findAll();
//        Collections.sort(centroCustos);
        return centroCustos;
    }

    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        centroCustoRepository.deleteById(id);
    }



}
