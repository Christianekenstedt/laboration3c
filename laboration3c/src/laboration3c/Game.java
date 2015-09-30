package laboration3c;
import java.util.Scanner;

/**
 * This class represent the game, in this case Blackjack. 
 * @author Christian Ekenstedt
 */
public class Game {
    private Hand dealer;
    private Hand player;
    private Deck deck;
    private boolean run; 
    private boolean done;
    /**
     * inits the game with the hands and the deck.
     */
    public Game (){
        dealer = new Hand();
        player = new Hand();
        deck = new Deck();
        //System.out.println(deck.toString());
        //System.out.println(deck.noOfCards());
        for(int i = 0; i < 49;i++){
            deck.dealCard();
        }
        run = true;
        done = false;
    }
    /**
     * The game runs with this method.
     */
    public void start(){
        init(); // shuffel the deck and give the first cards.
        if(isBlackJack()) run = false; // Checks if blackjack on first cards.
        while(run){
            if(!playerTurn()){ // Player plays until stand. 
                dealerRun(); // Then dealer play.
            }
            checkCards(); // after every round check cards.
        }
    }
    /**
     * init the first card to the game.
     */
    private void init(){
        deck.shuffelCards();
        for(int i = 0; i < 2; i++){
            hit(dealer);
            hit(player);
            //dealer.addCard(deck.dealCard());
            //player.addCard(deck.dealCard());
        }
        try{
            System.out.println("The dealer have:\n" + dealer.getCard(1) + "\nAnd one hidden"+ "\n");
            System.out.println("Player have:\n" + player.toString() + "Value: " + player.getValue() );
        }catch(NoSuchCardException ce){
            throw ce;
        }
        
        
    }
    /**
     * Hit gives the player/dealer a new card.
     * @return a new card from the deck.
     */
    private void hit(Hand h){
        try{
            h.addCard(deck.dealCard());
        }
        catch (NoSuchCardException ce){
            deck.fill();
            h.addCard(deck.dealCard());
            
        }
    }
    
    /**
     * Check and return if blackjack
     * @return true for blackjack
     */
    private boolean isBlackJack(){
        if(player.getValue() == 21){
            return true;
        }else return false;
    }
    private void checkCards(){
        if(isBlackJack()){
                    System.out.println("Player got Blackjack!");
                    run =  false;
                }else if(player.getValue() > 21){
                    System.out.println("Player bust, you lose!");
                    run =  false;
                }
        if (done){
                if (checkPlayer()){
                    System.out.println("Player wins!");
                }else if(player.getValue() == dealer.getValue()){
                    System.out.println("Player and Dealer tie!");
                }else System.out.println("Dealer wins!");
                run = false;
            }
        
    }
    private boolean playerTurn(){
        Scanner scan = new Scanner(System.in);
        String answer;
        boolean run;
        System.out.println("Player - hit or stand? (hit/stand)");
            answer = scan.next();
            System.out.println("___________________________");
            if(answer.equals("hit")){
                
                    hit(player);
                    System.out.println("Player draw " + player.getCard(player.getNoOfCards()) + "\n");
                    System.out.println("Player have:\n" + player.toString() + "Value: " + player.getValue() );
               
                
                return true;
            }else{
               return false;
            }
            
    }
    /**
     * The dealer run mehtod.
     * @return if dealer is done.
     */
    private void dealerRun(){
        
        System.out.println("\nThe dealer have:\n" + dealer.toString() + "Value: " + dealer.getValue() );
        
        while(dealer.getValue() < 17){
            hit(dealer);
            
            System.out.println("Dealer draw " + dealer.getCard(dealer.getNoOfCards()));
            System.out.println("\nThe dealer have:\n" + dealer.toString() + "Value: " + dealer.getValue() );
        }
        if(dealer.getValue() == 21){
            System.out.println("Dealer got Blackjack!");
            System.out.println("The dealer have:\n" + dealer.toString() + "Value: " + dealer.getValue() );
            System.out.println("___________________________");
            done = true;
        }else if(dealer.getValue()>21){
            System.out.println("Dealer bust, player wins!");
           run = false;
        }else{
            System.out.println("The dealer stands at " + dealer.getValue() );
            done = true; 
        }
        
    }
    /**
     * Check if the player wins.
     * @return if player wins.
     */
    private boolean checkPlayer(){
        if(player.getValue() > dealer.getValue() ){
            return true;
        }else if (player.getValue() < dealer.getValue()){
            return false;
        }else return false; // if tie.
    }
}
