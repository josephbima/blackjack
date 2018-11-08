package com.jjenie;

public class Deck {

    private Card[] myDeck = new Card[52];
    private int cardsUsed;

    public Deck(){
//        unshuffled deck of cards.
        int cardIndex=0;

        for(int suit = 0;suit<4;suit++){ // 1. 1 - 13, 2. 1-13 Number in front represents the suits.

            for(int value = 1;value<=13;value++){

                myDeck[cardIndex] = new Card(value,suit);
                cardIndex++;
            }

        }
    }

    public void shuffle(){
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = myDeck[i];
            myDeck[i] = myDeck[rand];
            myDeck[rand] = temp;
        }
        cardsUsed = 0;
    }

    public int cardsLeft() {
        // As cards are dealt from the deck, the number of cards left
        // decreases.  This function returns the number of cards that
        // are still left in the deck.
        return 52 - cardsUsed;
    }

    public Card dealCard() {
        // Deals one card from the deck and returns it.
        if (cardsUsed == 52)
            shuffle();
        cardsUsed++;
        return myDeck[cardsUsed - 1];
    }



}
