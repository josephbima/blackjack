package com.jjenie;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean keepPlaying = true;
        Scanner scan = new Scanner(System.in);
        String userInput;
        int playerCherries = 10;
        int computerCherries = 10;


        while(keepPlaying){
            Deck deck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>(0) ;
            ArrayList<Card> compHand = new ArrayList<Card>(0) ;
            System.out.println("*** Welcome to Blackjack ***");
            System.out.println("Player's Cherries: "+ playerCherries);
            System.out.println("Computer's Cherries: " + computerCherries);
            System.out.println("Press P to Play.");
            System.out.println("Press Q to Quit.");
            userInput = scan.nextLine();
            if (userInput.equalsIgnoreCase("Q")){
                System.out.println("See ya' later!");
                keepPlaying =false;
            }
            else{
                deck.shuffle(); //shuffles deck
                boolean playerHitCounter = true;
                boolean computerHitCounter = false;

                System.out.println("Player one, here are your cards");


                hand.add(deck.drawCard());
                hand.add(deck.drawCard());
                System.out.println(hand);

                if(overTwentyOne(hand)){
                    System.out.println("You lose.");
                    playerHitCounter = false;
                }
                if(hasBlackjack(hand)){
                    System.out.println("Blackjack! You win.");
                    playerHitCounter = false;
                }

                System.out.println("Computer, here are your cards");
//                Add condition for computerHitCounter to false
                compHand.add(deck.drawCard());
                compHand.add(deck.drawCard());
                System.out.println(compHand);
                if(overTwentyOne(compHand)){
                    System.out.println("You win.");
                    playerHitCounter = false;
                }
                if(hasBlackjack(compHand)){
                    System.out.println("Blackjack! You lose.");
                    playerHitCounter = false;
                }
                while(playerHitCounter){

                    System.out.println("Press H to Hit");
                    System.out.println("Press K to Keep");
                    userInput = scan.nextLine();
                    if (userInput.equalsIgnoreCase("H")){
                        //addCard
                        System.out.println("Hit!");
                        hand.add(deck.drawCard());
                        System.out.println(hand);
                        if(overTwentyOne(hand)){
                            System.out.println("You lose.");
                            playerHitCounter = false;

                        }
                        if(hasBlackjack(hand)){
                            System.out.println("Blackjack! You win.");
                            playerHitCounter = false;
                        }

                    }
                    else{
                        playerHitCounter = false;
                    }

                }
                if(checkValue(compHand) < 15){
                    computerHitCounter = true;
                }

                while(computerHitCounter){
                    System.out.println("Computer Hit!");
//                    add condition to make false

                        compHand.add(deck.drawCard());
                        System.out.println(compHand);
                        if(overTwentyOne(compHand)){
                            System.out.println("You win.");
                            computerHitCounter = false;

                        }
                        if(hasBlackjack(compHand)){
                            System.out.println("Blackjack! You lose.");
                            computerHitCounter = false;
                        }

                        if((checkValue(compHand)>checkValue(hand)  || (checkValue(compHand)>21))){
                            computerHitCounter = false;
                        }





                }
                //compare value, who wins, who takes cherries

                if(userWins(hand, compHand) || checkValue(compHand) > 21){
                    ++playerCherries;
                    --computerCherries;
                    System.out.println("TAKE ONE CHERRY");

                }
                else{
                    --playerCherries;
                    ++computerCherries;
                    System.out.println("ONE CHERY TAKEN");

                }




                //siapa menang berdasarkan cherries
                if(playerCherries==0){
                    System.out.println( "You lose. Better luck next time!");
                    keepPlaying = false;
                }
                else if(computerCherries == 0){
                    System.out.println("You win! Awesome!");
                    keepPlaying = false;
                }


            } // Close Else
        }
    } // Close Main

    public static int checkValue(ArrayList<Card> hand){

        int totalValue=0;

        for(Card cards : hand){
            totalValue+=cards.getValue();
        }

        return totalValue;

    }


    public static boolean overTwentyOne(ArrayList<Card> hand){

        boolean overTwentyOne = false;
        if(checkValue(hand) > 21){
            overTwentyOne = true;
        }
        return overTwentyOne;

    }

    public static boolean hasBlackjack(ArrayList<Card> hand){
        boolean blackjack = false;
        // implement method
        if(checkValue(hand) == 21){
            blackjack = true;
        }
        return blackjack;
    }

   public static boolean userWins(ArrayList<Card> hand1, ArrayList<Card> hand2){

        boolean userWin = false;

        if(  (checkValue(hand1) > checkValue(hand2))  && ( (checkValue(hand1) <= 21)  )){
            userWin = true;
        }
        return userWin;
   }

}
