import Enums.Rank;
import Enums.Suit;
import Models.Card;
import Models.PokerHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tony on 9/23/2015.
 */
public class HandScoringTests {
    @Test
    public void IsHandRoyalFlush() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForRoyalFlush(pokerHand), is(true));
    }

    @Test
    public void IsHandFlush() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForFlush(pokerHand), is(true));
    }

}
