package laboration3c;

import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

/**
 * This class represent a card deck, built of the class Card.
 * @author Christian Ekenstedt
 */
public class Deck {
    
    private ArrayList<Card> deck;
    
    /**
     * Creates a full card deck.
     */
    public Deck(){ 
        deck = new ArrayList<>();
        fill();
    }
    /**
     * Return the number of cards.
     * @return 
     */
    public int noOfCards(){
        return deck.size();
    }
    /**
     * Deals a card from the top of the deck and remove it from the deck.
     * @return 
     */
    public Card dealCard(){
        Card temp = null;
        if(!deck.isEmpty()){
            temp = deck.get(deck.size()-1);
            deck.remove(deck.size()-1);
        }else throw new NoSuchCardException();
        return temp;
    }
    /**
     * Shuffels the list with cards.
     */
    public void shuffelCards(){
        Collections.shuffle(deck);
    }
    /**
     * Remove the existing cards of the deck and the fill the deck with new cards.
     */
    public void fill(){
        int n=0;
        deck.removeAll(deck);
        
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Rank rank: Card.Rank.values()){
                deck.add(new Card(rank,suit));
                
            }
            
        }
    }
    
    /**
     * Prints the card.
     * @param card
     * @return the string of the card.
     */
    public String toString(){
        String info = new String();  
        for(Card c: deck){
            info += "Card: " + c.toString() + "\n";
        }
        return info;
    }
}
