package laboration3c;

import java.util.Comparator;

/**
 *
 * @author Chrille
 */
public class BySuit implements Comparator<Card>{

    @Override
    public int compare(Card t, Card t1) {
        return t.getSuit().toString().compareTo(t1.getSuit().toString());
    }
    
}
