package Models;

import Enums.HandCombination;
import Enums.Rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tony on 9/23/2015.
 */
public class PokerHand implements Comparable<PokerHand>{
    List<Card> cards;
    private HandCombination handCombination;

    private Rank handRank;

    private Rank kickerRank;

    private int playerID;

    public PokerHand() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public HandCombination getHandCombination() {
        return handCombination;
    }

    public void setHandCombination(HandCombination handCombination) {
        this.handCombination = handCombination;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public Rank getHandRank() {
        return handRank;
    }

    public void setHandRank(Rank handRank) {
        this.handRank = handRank;
    }

    @Override
    public int compareTo(PokerHand o) {
        if (!this.equals(o))
            return o.getHandCombination().compareTo(this.getHandCombination());

        return Integer.compare(o.getHandRank().getValue(), this.getHandRank().getValue());
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof PokerHand)) {
            return false;
        }
        final PokerHand otherHand = (PokerHand) other;
        return this.getHandCombination().equals(otherHand.getHandCombination());
    }

    @Override
    public String toString() {
        String returnString = "Player " + Integer.toString(playerID) + ": ";
        for (Card card : cards) {
            returnString += card.toString() + " ";
        }
        returnString += " (" + this.handCombination + ")";
        return returnString;
    }
}
