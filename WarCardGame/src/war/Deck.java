/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package war;

/**
 * @author benso
 */

import war.Card.Rank;
import war.Card.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends GroupOfCards {

    public Deck() {
        super(createDeck());
    }

    // Create an ArrayList composed of cards found in a standard 52-card playing
    // deck, in a random order
    private static ArrayList<Card> createDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        //create a card of every suit and value combination and append them
        //into the List
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        //randomize the order of the cards created
        Collections.shuffle(cards);
        return cards;
    }

    public void dealToPlayers(Player player1, Player player2) {
        Hand player1Hand = player1.getHand();
        Hand player2Hand = player2.getHand();
        while (!this.isEmpty()) {
            player1Hand.addCardToTop(this.removeCardFromTop());
            player2Hand.addCardToTop(this.removeCardFromTop());
        }
    }
}
