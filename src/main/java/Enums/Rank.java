package Enums;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

/**
 * Created by Tony on 9/23/2015.
 */
public enum Rank {
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12),
    ACE(13);

    int value;

    Rank(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return capitalize(this.name().toLowerCase());
    }

    public int getValue() {
        return value;
    }
}
