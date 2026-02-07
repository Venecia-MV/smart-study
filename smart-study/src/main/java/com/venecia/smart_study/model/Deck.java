package com.venecia.smart_study.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;


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

    /**
     * Default Constuctor for Deck Class
     */
    public Deck() {
        this.createdDate = LocalDateTime.now();
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

}
