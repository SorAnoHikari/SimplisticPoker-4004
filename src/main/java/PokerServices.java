import Enums.HandCombination;
import Enums.Rank;
import Enums.Suit;
import Models.Card;
import Models.PokerHand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Created by Tony on 9/23/2015.
 */
public class PokerServices {
    //<editor-fold desc="Input validation methods">
    public boolean IsHandValid(List<String> hand) {
        if (hand.size() != 6)
            return false;
        for (int i = 1; i <= 5; i++) {
            if (!IsCardValid(hand.get(i)))
                return false;
        }
        return true;
    }
    public boolean IsCardValid(String card) {
        String[] r = card.split("(?=\\p{Upper})");
        try {
            Rank rank = Rank.valueOf(r[0].toUpperCase());
            Suit suit = Suit.valueOf(r[1].toUpperCase());

            if (rank == null || suit == null)
                return false;
            return true;
        }
        catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean IsHandContainsDuplicates(List<String> hand, List<List<String>> handList) {
        Set<String> handSet = new HashSet<String>(hand);
        if (handSet.size() != hand.size())
            return true;
        for(String card : hand) {
            for (List<String> otherHand : handList) {
                if (otherHand.contains(card)) {
                    return true;
                }
            }
        }
        return false;
    }
    //</editor-fold>

    public static List<List<String>> SortHandsByWinningOrder(List<List<String>> handsList) {
        List<List<String>> sortedHand = new ArrayList<List<String>>();

        for (List<String> hand : handsList) {
            PokerHand currentHand = new PokerHand();
            for (int i = 1; i < hand.size(); i++) {
                String[] r = hand.get(i).split("(?=\\p{Upper})");
                Rank rank = Rank.valueOf(r[0].toUpperCase());
                Suit suit = Suit.valueOf(r[1].toUpperCase());
                currentHand.getCards().add(new Card(rank, suit));
            }
        }

        return sortedHand;
    }

    public boolean CheckHandForRoyalFlush(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;

        if (isAllCardsSameSuit(pokerHand) && isRanksInRoyalFlushFormat(pokerHand)) {
            pokerHand.setHandCombination(HandCombination.ROYAL_FLUSH);
            return true;
        }
        return false;
    }

    private boolean isAllCardsSameSuit(PokerHand pokerHand) {
        List<Suit> suits = pokerHand.getCards().stream().map(Card::getSuit).collect(toList());
        for (int i = 1; i < suits.size() - 1; i++) {
            if (suits.get(i) != suits.get(i-1))
                return false;
        }
        return true;
    }

    private boolean isRanksInRoyalFlushFormat(PokerHand pokerHand) {
        List<Rank> ranks = pokerHand.getCards().stream().map(Card::getRank).collect(toList());
        return ranks.contains(Rank.ACE) && ranks.contains(Rank.KING) && ranks.contains(Rank.QUEEN) && ranks.contains(Rank.JACK) && ranks.contains(Rank.TEN);
    }

    public boolean CheckHandForFlush(PokerHand pokerHand) {
        return false;
    }
}
