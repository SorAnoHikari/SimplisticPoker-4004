import Enums.HandCombination;
import Enums.Rank;
import Enums.Suit;
import Models.Card;
import Models.PokerHand;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Main service class for poker logic
 *
 * Created by Tony on 9/23/2015.
 */
public class PokerServices {
    //<editor-fold desc="Input validation methods">
    public boolean IsHandValid(List<String> hand) {
        if (hand.size() != 6)
            return false;

        try {
            Integer.parseInt(hand.get(0));
        }
        catch (Exception e) {
            return false;
        }

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
        String id = hand.get(0);
        for (List<String> otherHand : handList)
        {
            if (otherHand.contains(id))
                return true;
        }

        Set<String> handSet = new HashSet<>(hand);
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

    /**
     * Method to convert a list of strings into a pokerhand.
     * This assumes your input is valid, so use the validation methods before this
     * @param cardStringList
     * @return
     */
    public PokerHand ConvertListToPokerHand(List<String> cardStringList) {
        PokerHand hand = new PokerHand();
        List<Card> cardList = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            String[] r = cardStringList.get(i).split("(?=\\p{Upper})");
            Rank rank = Rank.valueOf(r[0].toUpperCase());
            Suit suit = Suit.valueOf(r[1].toUpperCase());

            cardList.add(new Card(rank, suit));
        }
        hand.setCards(cardList);
        return hand;
    }

    public void ScoreHand(PokerHand pokerHand) {
        if (CheckHandForRoyalFlush(pokerHand))
            return;
        if (CheckHandForStraightFlush(pokerHand))
            return;
        if (CheckHandForFourOfAKind(pokerHand))
            return;
        if (CheckHandForFlush(pokerHand))
            return;
        if (CheckHandForStraight(pokerHand))
            return;
        if (CheckHandForThreeOfAKind(pokerHand))
            return;
        if (CheckHandForPair(pokerHand))
            return;
        if (CheckHandForSingle(pokerHand))
            return;
    }

    //<editor-fold desc="Hand scoring methods">
    public boolean CheckHandForRoyalFlush(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;

        if (isAllCardsSameSuit(pokerHand) && isRanksInRoyalFlushFormat(pokerHand)) {
            pokerHand.setHandCombination(HandCombination.ROYAL_FLUSH);
            return true;
        }
        return false;
    }

    public boolean CheckHandForStraightFlush(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;
        if (isAllCardsSameSuit(pokerHand) && isRanksInStraightFormat(pokerHand)) {
            pokerHand.setHandCombination(HandCombination.STRAIGHT_FLUSH);
            List<Card> hand = pokerHand.getCards();
            Collections.sort(hand, Card.CardComparators.BY_RANK);
            pokerHand.setHandRank(hand.get(0).getRank());
            return true;
        }
        return false;
    }

    public boolean CheckHandForFlush(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;
        if (isAllCardsSameSuit(pokerHand)) {
            pokerHand.setHandCombination(HandCombination.FLUSH);
            List<Card> hand = pokerHand.getCards();
            Collections.sort(hand, Card.CardComparators.BY_RANK);
            pokerHand.setHandRank(hand.get(0).getRank());
            return true;
        }
        return false;
    }

    public boolean CheckHandForStraight(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;

        if (isRanksInStraightFormat(pokerHand)) {
            pokerHand.setHandCombination(HandCombination.STRAIGHT);
            return true;
        }
        return false;
    }

    public boolean CheckHandForFourOfAKind(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;
        List<Rank> ranks = pokerHand.getCards().stream().map(Card::getRank).collect(toList());
        List<Rank> copyOfRanks = new ArrayList<>(ranks);
        for (Rank rank : ranks) {
            copyOfRanks.remove(rank);
            if (copyOfRanks.contains(rank)) {
                copyOfRanks.remove(rank);
                if (copyOfRanks.contains(rank)) {
                    copyOfRanks.remove(rank);
                    if (copyOfRanks.contains(rank)) {
                        pokerHand.setHandCombination(HandCombination.FOUR_OF_A_KIND);
                        List<Card> hand = pokerHand.getCards();
                        Collections.sort(hand, Card.CardComparators.BY_RANK);
                        pokerHand.setHandRank(hand.get(0).getRank());
                        pokerHand.setKickerRank(hand.get(4).getRank());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean CheckHandForFullHouse(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;

        List<Card> hand = pokerHand.getCards();
        Collections.sort(hand, Card.CardComparators.BY_RANK);

        boolean twoThreeFullHouse = ((hand.get(0).getRank() == hand.get(1).getRank())
                && (hand.get(2).getRank() == hand.get(3).getRank())
                && (hand.get(3).getRank() == hand.get(4).getRank()));

        boolean threeTwoFullHouse = ((hand.get(4).getRank() == hand.get(3).getRank())
                && (hand.get(2).getRank() == hand.get(1).getRank())
                && (hand.get(1).getRank() == hand.get(0).getRank()));

        if (twoThreeFullHouse || threeTwoFullHouse) {
            pokerHand.setHandRank(hand.get(0).getRank());
            pokerHand.setKickerRank(hand.get(3).getRank());
        }

        return twoThreeFullHouse || threeTwoFullHouse;
    }

    public boolean CheckHandForThreeOfAKind(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;
        List<Rank> ranks = pokerHand.getCards().stream().map(Card::getRank).collect(toList());
        List<Rank> copyOfRanks = new ArrayList<>(ranks);
        for (Rank rank : ranks) {
            copyOfRanks.remove(rank);
            if (copyOfRanks.contains(rank)) {
                copyOfRanks.remove(rank);
                if (copyOfRanks.contains(rank)) {
                    pokerHand.setHandCombination(HandCombination.THREE_OF_A_KIND);
                    List<Card> hand = pokerHand.getCards();
                    Collections.sort(hand, Card.CardComparators.BY_RANK);
                    pokerHand.setHandRank(hand.get(0).getRank());
                    pokerHand.setKickerRank(hand.get(3).getRank());
                    pokerHand.setSecondKickerRank(hand.get(4).getRank());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean CheckHandForTwoPair(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;
        List<Rank> ranks = pokerHand.getCards().stream().map(Card::getRank).collect(toList());
        List<Rank> copyOfRanks = new ArrayList<>(ranks);
        for (Rank rank : ranks) {
            copyOfRanks.remove(rank);
            if (copyOfRanks.contains(rank)) {
                // Got the first pair, try to find a second now
                copyOfRanks.remove(rank);
                break;
            }
        }

        List<Rank> newCopyOfRanks = new ArrayList<>(copyOfRanks);
        for (Rank rank : copyOfRanks) {
            newCopyOfRanks.remove(rank);
            if (newCopyOfRanks.contains(rank)) {
                pokerHand.setHandCombination(HandCombination.TWO_PAIR);
                List<Card> hand = pokerHand.getCards();
                Collections.sort(hand, Card.CardComparators.BY_RANK);
                pokerHand.setHandRank(hand.get(0).getRank());
                pokerHand.setKickerRank(hand.get(2).getRank());
                pokerHand.setSecondKickerRank(hand.get(4).getRank());
                return true;
            }
        }
        return false;
    }

    public boolean CheckHandForPair(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;
        List<Rank> ranks = pokerHand.getCards().stream().map(Card::getRank).collect(toList());
        List<Rank> copyOfRanks = new ArrayList<>(ranks);
        for (Rank rank : ranks) {
            copyOfRanks.remove(rank);
            if (copyOfRanks.contains(rank)) {
                pokerHand.setHandCombination(HandCombination.ONE_PAIR);
                List<Card> hand = pokerHand.getCards();
                Collections.sort(hand, Card.CardComparators.BY_RANK);
                pokerHand.setHandRank(hand.get(0).getRank());
                pokerHand.setKickerRank(hand.get(2).getRank());
                pokerHand.setSecondKickerRank(hand.get(3).getRank());
                pokerHand.setThirdKickerRank(hand.get(4).getRank());
                return true;
            }
        }
        return false;
    }

    public boolean CheckHandForSingle(PokerHand pokerHand) {
        if (pokerHand.getHandCombination() != null)
            return false;
        List<Rank> ranks = pokerHand.getCards().stream().map(Card::getRank).collect(toList());
        List<Rank> copyOfRanks = new ArrayList<>(ranks);
        for (Rank rank : ranks) {
            copyOfRanks.remove(rank);
            if (copyOfRanks.contains(rank)) {
                return false;
            }
        }
        List<Card> hand = pokerHand.getCards();
        Collections.sort(hand, Card.CardComparators.BY_RANK);
        pokerHand.setHandRank(hand.get(0).getRank());
        pokerHand.setKickerRank(hand.get(1).getRank());
        pokerHand.setSecondKickerRank(hand.get(2).getRank());
        pokerHand.setThirdKickerRank(hand.get(3).getRank());
        pokerHand.setFourthKickerRank(hand.get(4).getRank());
        pokerHand.setHandCombination(HandCombination.HIGH_CARD);
        return true;
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

    private boolean isRanksInStraightFormat(PokerHand pokerHand) {
        List<Card> hand = pokerHand.getCards();
        Collections.sort(hand, Card.CardComparators.BY_RANK);

        // Two scenarios to check if the high card in the straight is an Ace
        if (hand.get(0).getRank() == Rank.ACE) {
            pokerHand.setHandRank(hand.get(1).getRank());
            return ((hand.get(1).getRank() == Rank.FIVE
                    && hand.get(2).getRank() == Rank.FOUR
                    && hand.get(3).getRank() == Rank.THREE
                    && hand.get(4).getRank() == Rank.TWO)
                ||
                 (hand.get(1).getRank() == Rank.KING
                    && hand.get(2).getRank() == Rank.QUEEN
                    && hand.get(3).getRank() == Rank.JACK
                    && hand.get(4).getRank() == Rank.TEN));
        }

        for (int i = 1; i < 5; i++) {
            if (hand.get(i).getRank().getValue() - hand.get(i-1).getRank().getValue() != 1) {
                return false;
            }
        }
        pokerHand.setHandRank(hand.get(0).getRank());

        return true;
    }
    //</editor-fold>
}
