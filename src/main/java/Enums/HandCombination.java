package Enums;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

/**
 * Created by Tony on 9/20/2015.
 */
public enum HandCombination {
    HIGH_CARD(1),
    ONE_PAIR(2),
    TWO_PAIR(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9),
    ROYAL_FLUSH(10);

    private int value;

    HandCombination(int value) {
        this.value = value;
    }

    public int GetValue() {
        return this.value;
    }

    public String toString() {
        return capitalize(this.name().toLowerCase());
    }
}
