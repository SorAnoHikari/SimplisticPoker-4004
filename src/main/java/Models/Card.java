package Models;

import Enums.HandCombination;
import Enums.Rank;
import Enums.Suit;

import java.util.Comparator;

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

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public static enum Comparators implements Comparator<Card> {
        BY_SUIT {
            @Override
            public int compare(final Card o1, final Card o2) {
                return o1.getSuit().compareTo(o2.getSuit());
            }
        },
        BY_RANK {
            @Override
            public int compare(final Card o1, final Card o2) {
                return -1 * o1.getRank().compareTo(o2.getRank());
            }
        }
    }
}
