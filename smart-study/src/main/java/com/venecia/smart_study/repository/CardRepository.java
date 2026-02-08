package com.venecia.smart_study.repository;

import com.venecia.smart_study.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface Repository for Card
 * THIS PROJECT IS AI-ASSISTED
 * @author Michael Venecia
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    /**
     * Finds all cards that belong to a specific deck
     * @param deckId to search for
     * @return the cards that belong to the specified deck
     */
    List<Card> findByDeckId(Long deckId);
}
