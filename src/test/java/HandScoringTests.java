import Enums.HandCombination;
import Enums.Rank;
import Enums.Suit;
import Models.Card;
import Models.PokerHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tony on 9/23/2015.
 */
public class HandScoringTests {
    @Test
    public void IsRoyalFlush() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForRoyalFlush(pokerHand), is(true));
    }

    @Test
    public void IsStraightFlush() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForStraightFlush(pokerHand), is(true));
    }

    @Test
    public void IsRoyalFlushBetterThanStraightFlush() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand royalFlushHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        royalFlushHand.setCards(cards);
        pokerServices.ScoreHand(royalFlushHand);

        PokerHand straightFlushHand = new PokerHand();
        cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        straightFlushHand.setCards(cards);
        pokerServices.ScoreHand(straightFlushHand);

        handsList.add(straightFlushHand);
        handsList.add(royalFlushHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0).getHandCombination(), is(HandCombination.ROYAL_FLUSH));
    }

    @Test
    public void IsStraight() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForStraight(pokerHand), is(true));
    }

    @Test
    public void IsFlush() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForFlush(pokerHand), is(true));
    }

    @Test
    public void IsFourOfAKind() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForFourOfAKind(pokerHand), is(true));
    }

    @Test
    public void IsThreeOfAKind() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForThreeOfAKind(pokerHand), is(true));
    }

    @Test
    public void IsPair() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForPair(pokerHand), is(true));
    }

    @Test
    public void IsSingle() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        pokerHand.setCards(cards);

        assertThat(pokerServices.CheckHandForSingle(pokerHand), is(true));
    }
}
