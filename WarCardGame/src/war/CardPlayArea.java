/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package war;

/**
 * @author Benson Li, Xavier Faria, Joshua Faria, John Paua
 */
import java.util.ArrayList;

public class CardPlayArea extends GroupOfCards {

    private final ArrayList<Card> flippedCards = new ArrayList<>(); //keeps track of which cards are flipped

    public CardPlayArea() {
        super(new ArrayList<>());
    }

    //getters and setters
    public ArrayList<Card> getFlippedCards() {
        return this.flippedCards;
    }
    
    //return the card that was the most recently flipped
    public Card getLastFlippedCard(){
        return flippedCards.get(flippedCards.size() - 1);
    }

    //mark a card as flipped, so that when it is displayed, it's value is not hidden
    public void flipCard(Card card){
        //This is important, do not 
        flippedCards.add(card);
    }
    
    //removes all the cards that were
    public void clearFlippedCards(){
        flippedCards.removeAll(flippedCards);
    }
    
    @Override
    public String toString() {
        StringBuilder cardsString = new StringBuilder();
        for (Card card : getCards()) {
            if (flippedCards.contains(card)) {
                cardsString.append(card.toString()).append(" ");
            } else {
                cardsString.append("XX" + " ");
            }
            
        }

        return cardsString.toString();
    }
}
