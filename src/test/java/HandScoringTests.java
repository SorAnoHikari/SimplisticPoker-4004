import Enums.HandCombination;
import Enums.Rank;
import Enums.Suit;
import Models.Card;
import Models.PokerHand;
import TestServices.HandScoringTestServices;
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

        PokerHand pokerHand = HandScoringTestServices.CreateRoyalFlushHand();

        assertThat(pokerServices.CheckHandForRoyalFlush(pokerHand), is(true));
    }

    @Test
    public void IsStraightFlush() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateStraightFlushHand();

        assertThat(pokerServices.CheckHandForStraightFlush(pokerHand), is(true));
    }

    @Test
    public void IsRoyalFlushBetterThanStraightFlush() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand royalFlushHand = HandScoringTestServices.CreateRoyalFlushHand();
        pokerServices.ScoreHand(royalFlushHand);

        PokerHand straightFlushHand = HandScoringTestServices.CreateStraightFlushHand();
        pokerServices.ScoreHand(straightFlushHand);

        handsList.add(straightFlushHand);
        handsList.add(royalFlushHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0).getHandCombination(), is(HandCombination.ROYAL_FLUSH));
    }

    @Test
    public void IsStraight() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateStraightHand();

        assertThat(pokerServices.CheckHandForStraight(pokerHand), is(true));
    }

    @Test
    public void IsFlush() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateFlushHand();

        assertThat(pokerServices.CheckHandForFlush(pokerHand), is(true));
    }

    @Test
    public void IsFourOfAKind() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateFourOfAKindHand();

        assertThat(pokerServices.CheckHandForFourOfAKind(pokerHand), is(true));
    }

    @Test
    public void IsThreeOfAKind() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateThreeOfAKindHand();

        assertThat(pokerServices.CheckHandForThreeOfAKind(pokerHand), is(true));
    }

    @Test
    public void IsPair() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateOnePairHand();

        assertThat(pokerServices.CheckHandForPair(pokerHand), is(true));
    }

    @Test
    public void IsSingle() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateSingleHand();

        assertThat(pokerServices.CheckHandForSingle(pokerHand), is(true));
    }
}
