package com.venecia.smart_study.repository;

import com.venecia.smart_study.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository for each deck
 * THIS PROJECT IS AI ASSISTED
 * @author Michael Veneica
 */
@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {
}
