package br.com.ponta.service;

import br.com.ponta.dto.UFDTO;
import br.com.ponta.repository.UFRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UFService {

    private final UFRepository ufRepository;

    public UFService(UFRepository ufRepository) {
        this.ufRepository = ufRepository;
    }

    public List<UFDTO> findAll() {
        return ufRepository.findAll();
    }


}
