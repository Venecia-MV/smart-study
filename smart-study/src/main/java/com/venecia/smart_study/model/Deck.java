package com.venecia.smart_study.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


/**
 * Deck Object used to store flashcards for a specific subject
 * Stores the description of the deck and the time the deck was created.
 * THIS PROJECT IS AI-ASSISTED
 * @author Michael Venecia
 */
@Entity
@Table(name = "decks")
public class Deck {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();

    /**
     * Default Constuctor for Deck Class
     */
    public Deck() {
        this.createdDate = LocalDateTime.now();
    }

    //Getters and Setters

    /**
     * Retrieves the id of the deck
     * @return id of the deck
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the deck
     * @param id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the deck
     * @return name of deck
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the deck
     * @param name of the deck
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the description of the deck
     * @return description of the deck
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the deck
     * @param description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the date the deck was created
     * @return createdDate time the deck was created
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the date the deck was created
     * @param createdDate time the deck was created
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Retrieves the flashcard in the deck
     * @return flashcards in the deck
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Allows the addition of flashcards in the deck storing them in a list
     * @return flashcards in the deck
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
