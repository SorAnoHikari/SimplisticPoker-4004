package Enums;

import static org.apache.commons.lang3.StringUtils.capitalize;

/**
 * Created by Tony on 9/23/2015.
 */
public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    @Override
    public String toString() {
        return capitalize(this.name().toLowerCase());
    }
}
