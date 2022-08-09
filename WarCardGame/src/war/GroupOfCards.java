/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package war;

/**
 * @author Benson Li, Xavier Faria, Joshua Faria, John Paua
 */

import java.util.ArrayList;

abstract class GroupOfCards {

    ArrayList<Card> cards;

    public GroupOfCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // return number of cards in the current GroupOfCards object
    public int size() {
        return cards.size();
    }

    //check if cards ie empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // remove a Card object from the end of the ArrayList "cards",
    // return the Card that is removed
    // if there are no cards, return null
    public Card removeCardFromTop() {
        return (size() > 0) ? cards.remove(size() - 1) : null;
    }

    // remove the first Card object in the ArrayList cards
    // return the Card object that is removed
    // if there are no cards, return null
    public Card removeCardFromBottom() {
        return (size() > 0) ? cards.remove(0) : null;
    }

    // add a Card object to the bottom of the cards list
    public void addCardToTop(Card card) {
        cards.add(card);
    }

    // add a Card object to the bottom of the cards list
    public void addCardToBottom(Card card) {
        cards.add(0, card);
    }

    // remove a number of Card objects from the top of a cards list,
    // return an ArrayList of the removed cards
    public ArrayList<Card> removeCardsFromTop(int removeCount) {
        ArrayList<Card> removedCards = new ArrayList<>();
        for (int i = 0; i < removeCount; i++) {
            removedCards.add(this.cards.remove(this.size() - 1));
        }
        return removedCards;
    }

    // append an ArrayList of Card objects to the current List of cards
    public void addCardsToTop(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    //add the ArrayList of Card objects to beginning of the current List of cards
    public void addCardsToBottom(ArrayList<Card> cards) {
        this.cards.addAll(0, cards);
    }
    //getters and setters

    public ArrayList<Card> getCards() {
        return cards;
    }
}
