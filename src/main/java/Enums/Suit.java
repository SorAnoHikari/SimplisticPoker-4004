package Enums;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;
/**
 * Created by Tony on 9/23/2015.
 */
public enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    @Override
    public String toString() {
        return capitalize(this.name().toLowerCase());
    }
}
