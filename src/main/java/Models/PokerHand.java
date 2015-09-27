package Models;

import Enums.HandCombination;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tony on 9/23/2015.
 */
public class PokerHand implements Comparable<PokerHand>{
    List<Card> cards;
    private HandCombination handCombination;

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

    @Override
    public int compareTo(PokerHand o) {
        return o.getHandCombination().compareTo(this.getHandCombination());
    }
}
