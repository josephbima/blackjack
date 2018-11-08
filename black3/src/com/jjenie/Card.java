package com.jjenie;

public class Card {

    private int rank;//represents the rank of a card
    private int suit;//represents the suit of a card
    private int value;//represents the value of a card
    private static String[] ranks = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

    public Card(int value,int suit){

        rank = value;
        this.suit = suit;

    }
    public int getValue()
    {
        if(rank>10)
        {
            value=10;
        }
        else
        {
            value=rank;
        }
        return value;
    }

    public String toString() {
        return ranks[rank]+" of "+suits[suit];
    }


    public int getSuit(){
        return suit;
    }
}
