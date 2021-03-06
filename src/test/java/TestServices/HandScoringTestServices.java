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

    public static PokerHand CreateHighStraightFlushHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.QUEEN, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
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

    public static PokerHand CreateHighStraightHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.CLUBS));
        cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateFlushHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.NINE, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateHighFlushHand() {
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

    public static PokerHand CreateHighFourOfAKindHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateFullHouseHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateHighFullHouseHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.HEARTS));
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

    public static PokerHand CreateHighThreeOfAKindHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateTwoPairHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.TEN, Suit.HEARTS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateHighTwoPairHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));
        cards.add(new Card(Rank.KING, Suit.SPADES));
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

    public static PokerHand CreateHighOnePairHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));
        cards.add(new Card(Rank.THREE, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateSingleHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }

    public static PokerHand CreateHighSingleHand() {
        PokerHand hand = new PokerHand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.THREE, Suit.HEARTS));
        cards.add(new Card(Rank.TEN, Suit.SPADES));
        cards.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.setCards(cards);
        return hand;
    }
}
