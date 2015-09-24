package Models;

import Enums.HandCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 9/23/2015.
 */
public class PokerHand {
    List<Card> cards;
    private HandCombination handCombination;

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
}
