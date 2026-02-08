package com.venecia.smart_study.controller;

import com.venecia.smart_study.model.Card;
import com.venecia.smart_study.model.Deck;
import com.venecia.smart_study.repository.CardRepository;
import com.venecia.smart_study.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller that handles the cards allowing them to
 * be created, saved, and stored
 * THIS PROJECT IS AI ASSISTED
 * @author Michael Venecia
 */
@Controller
@RequestMapping("/decks/{deckId}/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private DeckRepository deckRepository;

    /**
     * Allows you to view all cards in a deck
     * @param deckId specifing which deck to view
     * @param model deck model
     * @return list of cards to view
     */
    @GetMapping
    public String listCards(@PathVariable Long deckId, Model model) {
        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck not found"));
        List<Card> cards = cardRepository.findByDeckId(deckId);

        model.addAttribute("deck", deck);
        model.addAttribute("cards", cards);
        return "cards/list";
    }

    /**
     * Shows the form to create a new card
     * @param deckId deck to create a card in
     * @param model allows us to add a card into the specified deck
     * @return card form
     */
    @GetMapping("/new")
    public String showCreateForm(@PathVariable Long deckId, Model model) {
        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck not found"));

        model.addAttribute("deck", deck);
        model.addAttribute("card", new Card());
        return "cards/form";
     }

    /**
     * Saves a new card
     * @param deckId deck the card is in
     * @param card to be saved
     * @return redirects to the flashcards in the deck
     */
     @PostMapping
    public String createCard(@PathVariable Long deckId, @ModelAttribute Card card) {
        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck not found"));

        card.setDeck(deck);
        cardRepository.save(card);
        return "redirect:/decks/" + deckId + "/cards";
     }

    /**
     * Allows for the deletion of cards in a deck
     * @param deckId deck to find the card in
     * @param cardId card to be deleted
     * @return redirects to the flashcard to be deleted
     */
     @PostMapping("/{cardId}/delete")
    public String deleteCard(@PathVariable Long deckId, @PathVariable Long cardId) {
         cardRepository.deleteById(cardId);
         return "redirect:/decks/" + deckId + "/cards";
     }

}
