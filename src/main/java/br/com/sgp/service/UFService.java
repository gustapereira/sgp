package br.com.sgp.service;

import br.com.sgp.dto.UFDTO;
import br.com.sgp.repository.UFRepository;
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
