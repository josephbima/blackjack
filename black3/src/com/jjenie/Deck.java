package com.jjenie;

import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private ArrayList<Card> deck;//represents a deck of cards

    Deck() //constructor
    {
        deck = new ArrayList<Card>();
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new Card( value , suit));
            }
        }
    }

    /*
     * Shuffles the deck by changing the indexes of 200 random pairs of cards in the deck.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard()
    {
        return deck.remove(0);
    }
}
