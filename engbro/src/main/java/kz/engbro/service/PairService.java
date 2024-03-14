package kz.engbro.service;


import kz.engbro.entity.model.Pair;
import kz.engbro.repository.PairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PairService {

    private final PairRepository pairRepository;

    @Autowired
    public PairService(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }


    public List<Pair> findAll() {
        return pairRepository.findAll();
    }
}
