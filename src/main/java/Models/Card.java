package Models;

import Enums.HandCombination;
import Enums.Rank;
import Enums.Suit;

/**
 * Created by Tony on 9/23/2015.
 */
public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
