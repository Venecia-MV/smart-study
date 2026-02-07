package com.venecia.smart_study.controller;

import com.venecia.smart_study.model.Deck;
import com.venecia.smart_study.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller that handles the decks allowing them to
 * be created, saved, and stored
 * THIS PROJECT IS AI ASSISTED
 * @author Michael Venecia
 */
@Controller
@RequestMapping("/decks")
public class DeckController {

    @Autowired
    private DeckRepository deckRepository;

    //Shows the available decks
    @GetMapping
    public String listDecks(Model model) {
        List<Deck> decks = deckRepository.findAll();
        model.addAttribute("decks", decks);
        return "decks/list";
    }

    //Allows the creation of decks
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("deck", new Deck());
        return "decks/form";
    }

    //Saves a new deck
    @PostMapping
    public String createDeck(@ModelAttribute Deck deck) {
        deckRepository.save(deck);
        return "redirect:/decks";
    }
}
