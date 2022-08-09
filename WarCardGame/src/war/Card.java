/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package war;

/**
 * @author Benson Li, Xavier Faria, Joshua Faria, John Paua
 */
public class Card implements Comparable<Card> {

    /**
     * Field Variables
     */
    //a
    private Rank rank;
    private Suit suit;

    /**
     * 2 parameter Constructor.
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     *
     * @return
     */
    public Rank getRank() {
        return rank;
    }

    /**
     *
     * @param rank
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    // This method compares the current card object with another card object, if
    // this card is larger than the other card, return 1
    // If this card is smaller than other card, return -1
    // If the two cards are the equal to each other, return 0;
    @Override
    public int compareTo(Card otherCard) {
        return (Integer.compare(this.rank.getValue(), otherCard.rank.getValue()));
    }

    // This method returns a String representation of the card object
    @Override
    public String toString() {
        return rank.getShorthand() + suit.getIcon();
    }

    //Check if the Card has same suit and rank as another
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return this.getRank() == card.getRank()
                && this.getSuit() == card.getSuit();
    }

    //    public enum Suit {
//        CLUBS(), DIAMONDS, HEARTS, SPADES
//    };
    public enum Suit {

        SPADES('\u2660'), HEARTS('\u2665'), DIAMONDS('\u2666'), CLUBS('\u2663');

        private final char icon;

        Suit(char icon) {
            this.icon = icon;
        }

        public char getIcon() {
            return icon;
        }
    }

    public enum Rank {
        TWO(2, "2"),
        THREE(3, "3"),
        FOUR(4, "4"),
        FIVE(5, "5"),
        SIX(6, "6"),
        SEVEN(7, "7"),
        EIGHT(8, "8"),
        NINE(9, "9"),
        TEN(10, "10"),
        JACK(11, "J"),
        QUEEN(12, "Q"),
        KING(13, "K"),
        ACE(14, "A");

        public final int value;
        public final String shorthand;

        Rank(int value, String shorthand) {
            this.value = value;
            this.shorthand = shorthand;
        }

        public int getValue() {
            return this.value;
        }

        public String getShorthand() {
            return this.shorthand;
        }
    }
}
