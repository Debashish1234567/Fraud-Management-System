package com.cognizant.fraudmanagementsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cognizant.fraudmanagementsystem.model.Card;
import com.cognizant.fraudmanagementsystem.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    
    private CardRepository cardRepository;
    private List<Card> cards = new ArrayList<>();

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
        cards = this.cardRepository.getAllCards();
    }

    public List<Card> getAllCards() {
        return cards;
    }

    public Card getCardById(int id) {
        return cards.stream().filter(card -> card.getId() == id).findAny().get();
    }

    public void delete(Card card) {
        cardRepository.delete(card);
        cards = cardRepository.getAllCards();
    }

    public boolean addCard(Card card) {
        try {
            cardRepository.addCard(card);
            cards = cardRepository.getAllCards();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Card> searchCards(String query, String type) {
        if (type.equals("cardType")) {
            return cards.stream().filter(card -> card.getCardType().equalsIgnoreCase(query)).collect(Collectors.toList());
        }
        if (type.equals("userId")) {
            return cards.stream().filter(card -> card.getUserId().equals(query)).collect(Collectors.toList());
        }
        if (type.equals("fraudLevel")) {
            return cards.stream().filter(card -> card.getFraudLevel().equalsIgnoreCase(query)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

}
