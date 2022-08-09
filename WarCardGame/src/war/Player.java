/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package war;

import java.util.ArrayList;

/**
 * @author Benson Li, Xavier Faria, Joshua Faria, John Paua
 */
public class Player {

    private final Hand hand;
    private final CardPlayArea playArea;
    private String name;

    //constructors
    Player() {
        this("");
    }

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.playArea = new CardPlayArea();
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public CardPlayArea getPlayArea() {
        return playArea;
    }

    //plays the top card in the current Player's hand
    //the top Card object in hand is transfered to the top of the playArea
    //the card transferred to the playArea is immediately flipped
    //return a copy of the Card that was played;
    public Card playCard() {
        Card cardPlayed = hand.removeCardFromTop();
        playArea.addCardToTop(cardPlayed);
        //flip the card that was just played
        playArea.flipCard(playArea.getCards().get(playArea.size() - 1));
        return cardPlayed;
    }

    //play the cards needed for war phase
    //flip the 4th card that is played
    //return a copy of the list of all cards played
    //if there are not enough cards to play return null
    public ArrayList<Card> playWarCards() {
        //4 cards are played
        int playCount = 4;
        ArrayList<Card> cardsPlayed = null;
        if (this.hand.size() >= 4) {
            cardsPlayed = hand.removeCardsFromTop(playCount);
            playArea.addCardsToTop(cardsPlayed);
//            playArea.flipCard(playArea.getCards().get(playArea.size() - 1));
        }

        return cardsPlayed;
    }
}
