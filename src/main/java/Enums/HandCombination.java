package Enums;

import static org.apache.commons.lang3.StringUtils.capitalize;

/**
 * Created by Tony on 9/20/2015.
 */
public enum HandCombination {
    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3),
    FULL_HOUSE(4),
    FOUR_OF_A_KIND(5),
    STRAIGHT(6),
    FLUSH(7),
    ROYAL_FLUSH(8);

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
