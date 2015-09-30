package laboration3c;

import java.util.Comparator;

/**
 *
 * @author Chrille
 */
public class ByValueAscending implements Comparator<Card>{

    @Override
    public int compare(Card t, Card t1) {
        return t.getRank().getRankpoints() > t1.getRank().getRankpoints() ? -1 : (t.getRank().getRankpoints() == t1.getRank().getRankpoints() ? 0 : 1);
    } 
}
