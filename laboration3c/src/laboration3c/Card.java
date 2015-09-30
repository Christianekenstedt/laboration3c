package laboration3c;

import java.util.Comparator;

/**
 * Objects of this class represents cards in a deck (of cards). A card is
 * immutable, i.e. once created its rank or suit cannot be changed.
 */

public class Card{

    

    /**
     * @param rank 1 = Ace, 2 = 2, ...
     * @param suit 1 = spades, 2 = hearts, 3 = diamonds, 4 = clubs
     */
    
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
        NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

        private int Rankpoints;

        Rank(int points) {
            this.Rankpoints = points;
        }

        public int getRankpoints() {
            return this.Rankpoints;
        }

    }
    
    public enum Suit {
        CLUBS(2), DIAMONDS(3), HEARTS(4), SPADES(1);

        private int Suitpoints;

        Suit(int points) {
            this.Suitpoints = points;
        }

        public int getSuitpoints() {
            return this.Suitpoints;
        }
    }
    
    private final Rank rank;
    private final Suit suit;
    
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public boolean equals(Card other) {
        return this.rank.getRankpoints() == other.rank.getRankpoints() && this.suit.getSuitpoints() == other.suit.getSuitpoints();
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
    // Tables for converting rank & suit to text (why static?)

}
