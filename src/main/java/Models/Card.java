package Models;

import static org.apache.commons.lang3.StringUtils.capitalize;
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

    public static enum CardComparators implements Comparator<Card> {
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

    @Override
    public String toString() {
        return capitalize(this.rank.name().toLowerCase()) + capitalize(this.suit.name().toLowerCase());
    }
}
