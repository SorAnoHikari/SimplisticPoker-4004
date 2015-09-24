import Enums.Rank;
import Enums.Suit;
import Models.Card;
import Models.PokerHand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 9/23/2015.
 */
public class PokerServices {
    public static List<List<String>> SortHandsByWinningOrder(List<List<String>> handsList) {
        List<List<String>> sortedHand = new ArrayList<List<String>>();

        for (List<String> hand : handsList) {
            PokerHand currentHand = new PokerHand();
            for (int i = 1; i < hand.size(); i++) {
                String[] r = hand.get(i).split("(?=\\p{Upper})");
                Rank rank = Rank.valueOf(r[0]);
                Suit suit = Suit.valueOf(r[1]);
                currentHand.getCards().add(new Card(rank, suit));
            }
        }

        return sortedHand;
    }
}
