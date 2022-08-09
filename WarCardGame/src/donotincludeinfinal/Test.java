/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donotincludeinfinal;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import war.Card;
import war.Deck;
import war.Hand;
import war.Player;

/**
 *
 * @author benso
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        // Card toCompare() test and card toString() test
        Card card1 = new Card(Card.Rank.TWO, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.THREE, Card.Suit.CLUBS);

//        int result = card1.compareTo(card2);
//        if (result > 0) {
//            System.out.println(card1 + " is larger than " + card2);
//        } else if (result < 0) {
//            System.out.println(card1 + " is smaller than " + card2);
//        } else {
//            System.out.println(card1 + " is equal with " + card2);
//        }
//
//        if (card1.equals(card2)) {
//            System.out.println("card objects have equals() value. ");
//        }
        //Class constructors testing
        Deck deck = new Deck();
        Player player1 = new Player("Benson");
        Player player2 = new Player("Andy");
    
//        player2.getHand().addCardToTop(player1.getHand().removeCardFromTop());
//        System.out.println(" " + deck.size() + " " + player1.getHand().size() + " " + player2.getHand().size());
//        Hand hand1 = new Hand();      
//        player1.setHand(hand1);
//        Hand hand2 = new Hand();
//        player2.setHand(hand2);
        //Test if deck is created correctly
//        System.out.println(deck.size());
//        for (Card card : deck.getCards()) {
//            System.out.println(card.toString());
//        }
        //Test if cards are dealt correctly
//        deck.dealToPlayers(player1, player2);
//        System.out.println(player1.getHand().toString());
//        System.out.println(player2.getHand().toString());

//        //Test if cards can be played correctly
//        player1.playCard();
//        player1.playCard();
//
//        System.out.println(player1.getName() + " has played " + player1.getPlayArea());
        //test equals()
//        ArrayList<Integer> arr1 = new ArrayList<>();
//        arr1.add(1);
//        arr1.add(2);
//        arr1.add(3);
//        ArrayList<Integer> arr2 = new ArrayList<>();
//        arr2.add(arr1.get(arr1.size() - 1));
//        System.out.println("Arr 2 is " + arr2);
//        System.out.println("Arr 1 is " + arr1);
        //test transfer of cards
        player1.playCard();
        System.out.println(player1.getHand().toString() + " play area " + player1.getPlayArea().size());
        player2.getHand().addCardToTop(player1.getPlayArea().removeCardFromTop());
        System.out.println(player2.getHand().toString());
        player1.playWarCards();
        System.out.println(player1.getHand().toString() + " play area size: " + 
                player1.getPlayArea().size() + " play area cards: " + player1.getPlayArea());
        player2.getHand().addCardsToTop(player1.getPlayArea()
                .removeCardsFromTop(player1.getPlayArea().size()));
        System.out.println(player2.getHand().toString());
        //Tesing Player class
    }
}
