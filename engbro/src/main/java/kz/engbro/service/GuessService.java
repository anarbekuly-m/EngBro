package kz.engbro.service;

import kz.engbro.entity.enumuration.GuessLevel;
import kz.engbro.entity.model.Guess;
import kz.engbro.repository.GuessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GuessService {

    private final GuessRepository guessRepository;

    @Autowired
    public GuessService(GuessRepository guessRepository) {
        this.guessRepository = guessRepository;
    }

    public List<Guess> findAll(GuessLevel type) {
        List<Guess> allByType = guessRepository.findAllByType(type);
        return allByType;
    }
}
