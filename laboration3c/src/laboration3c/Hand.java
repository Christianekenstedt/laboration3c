package laboration3c;

import java.util.ArrayList;

/**
 * This class Hand represent the poker hand.
 * @author Chrille
 */
public class Hand {
    private ArrayList<Card> hand;
    /**
     * Creates a hand and init the new hand.
     */
    public Hand(){
        hand = new ArrayList<>();
    }
    /**
     * Return the number of cards in the hand.
     * @return the number of cards in the hand.
     */
    public int getNoOfCards(){
        return hand.size();
    }
    /**
     * Adds a card to the hand and increas the noOfCards
     * @param c
     */
    public void addCard(Card c){
        hand.add(c);
        //hand.add(card);
      
    }
    /**
     * 
     * @param index, what position in the hand.
     * @return the card with the position in the hand given buy the index.
     */
    public Card getCard(int index){
        if((index < hand.size()) || index > 0){
            return hand.get(index-1);
        }else return null;
    }
    /**
     * Get the total value of the hand.
     * @return the value of the hand.
     */
    public int getValue(){
        int value = 0;
        for(int i=0; i<hand.size();i++){
            value += hand.get(i).getRank().getRankpoints();
            /*if(hand.get(i).getRank().getRankpoints() > 10){
                value += 10;
            }else value += hand.get(i).getRank().getRankpoints();
            */
            }
        return value;
    }
    /**
     * Removes a card in the hand.
     * @param index, what position in the hand.
     * @return the removed card.
     */
    public Card removeCard(int index){
        Card temp;
        if((index < hand.size()) || index > 0){
            temp = hand.get(index-1);
            hand.remove(index-1);
            return temp;
        }else return null;
        
    }
    /**
     * Reomves a given card
     * @param c is the card to remove
     * @return true or false if it cab ve removed.
     */
    public boolean removeCard(Card c){
        
        if (hand.contains(c)){
            hand.remove(c);
            return true;
        }else return false;
        
    }
    /**
     * Return a string with all the cards in the hand.
     * @return the hand
     */
    @Override
    public String toString(){
        String info = new String();
        for(int i=0; i< hand.size();i++){
            info += "Card " + (i+1) + ": " + hand.get(i) + "\n";
        }
        return info;
    }
    
    
}
