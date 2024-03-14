package kz.engbro.repository;

import kz.engbro.entity.enumuration.GuessLevel;
import kz.engbro.entity.model.Guess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Long> {

    List<Guess> findAllByType(GuessLevel level);
}
