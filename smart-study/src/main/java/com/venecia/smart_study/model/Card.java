package com.venecia.smart_study.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    /**
     * Default constructor for the card class
     * Sets the date the card was constructed
     */
    public Card() {
        this.createdDate = LocalDateTime.now();
    }

    /**
     * Retrieves the id of the card
     * @return id of the card
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the card
     * @param id of the card
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the question the card has stored
     * @return question the card has
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the question the card will store
     * @param question the card will store
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retrieves the answer the card has stored
     * @return answer the card has stored
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the answer the card has stored
     * @param answer the card will store
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Retrieves the deck the card is in
     * @return the deck the card is stored in
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Sets the deck the card is stored in
     * @param deck the card is stored in
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Retrieves the date the card was created on
     * @return date the card was created
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the date the card was created
     * @param createdDate the date the card was created
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
