package TestServices;

import Enums.Rank;
import Enums.Suit;
import Models.Card;
import Models.PokerHand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 9/27/2015.
 */
public class HandScoringTestServices {
    public static PokerHand CreateRoyalFlushHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateStraightFlushHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateStraightHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateFlushHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateFourOfAKindHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateThreeOfAKindHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateOnePairHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateSingleHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }
}
