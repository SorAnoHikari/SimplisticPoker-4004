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
    public void IsFullHouse() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateFullHouseHand();

        assertThat(pokerServices.CheckHandForFullHouse(pokerHand), is(true));
    }

    @Test
    public void IsNotFullHouse() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateThreeOfAKindHand();

        assertThat(pokerServices.CheckHandForFullHouse(pokerHand), is(false));
    }

    @Test
    public void IsThreeOfAKind() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateThreeOfAKindHand();

        assertThat(pokerServices.CheckHandForThreeOfAKind(pokerHand), is(true));
    }

    @Test
    public void IsTwoPair() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateTwoPairHand();

        assertThat(pokerServices.CheckHandForTwoPair(pokerHand), is(true));
    }

    @Test
    public void IsNotTwoPair() {
        final PokerServices pokerServices = new PokerServices();

        PokerHand pokerHand = HandScoringTestServices.CreateOnePairHand();

        assertThat(pokerServices.CheckHandForTwoPair(pokerHand), is(false));
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
    public void IsStraightBetterThanPair() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand straightHand = HandScoringTestServices.CreateStraightHand();
        pokerServices.ScoreHand(straightHand);

        PokerHand pairHand = HandScoringTestServices.CreateOnePairHand();
        pokerServices.ScoreHand(pairHand);

        handsList.add(pairHand);
        handsList.add(straightHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0).getHandCombination(), is(HandCombination.STRAIGHT));
    }

    @Test
    public void IsSingleWorseThanPair() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand singleHand = HandScoringTestServices.CreateSingleHand();
        pokerServices.ScoreHand(singleHand);

        PokerHand pairHand = HandScoringTestServices.CreateOnePairHand();
        pokerServices.ScoreHand(pairHand);

        handsList.add(singleHand);
        handsList.add(pairHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0).getHandCombination(), not(HandCombination.HIGH_CARD));
    }

    @Test
    public void IsHighStraightFlushBetterThanLowStraightFlush() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowHand = HandScoringTestServices.CreateStraightFlushHand();
        pokerServices.ScoreHand(lowHand);

        PokerHand highHand = HandScoringTestServices.CreateHighStraightFlushHand();
        pokerServices.ScoreHand(highHand);

        handsList.add(lowHand);
        handsList.add(highHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highHand));
    }

    @Test
    public void IsHighFullHouseBetterThanLowFullHouse() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowHand = HandScoringTestServices.CreateFullHouseHand();
        pokerServices.ScoreHand(lowHand);

        PokerHand highHand = HandScoringTestServices.CreateHighFullHouseHand();
        pokerServices.ScoreHand(highHand);

        handsList.add(lowHand);
        handsList.add(highHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highHand));
    }

    @Test
    public void IsHighFlushBetterThanLowFlush() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowHand = HandScoringTestServices.CreateFlushHand();
        pokerServices.ScoreHand(lowHand);

        PokerHand highHand = HandScoringTestServices.CreateHighFlushHand();
        pokerServices.ScoreHand(highHand);

        handsList.add(lowHand);
        handsList.add(highHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highHand));
    }

    @Test
    public void IsHighStraightBetterThanLowStraight() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowStraightHand = HandScoringTestServices.CreateStraightHand();
        pokerServices.ScoreHand(lowStraightHand);

        PokerHand highStraightHand = HandScoringTestServices.CreateHighStraightHand();
        pokerServices.ScoreHand(highStraightHand);

        handsList.add(lowStraightHand);
        handsList.add(highStraightHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highStraightHand));
    }

    @Test
    public void IsHighFourOfAKindBetterThanLowFourOfAKind() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowHand = HandScoringTestServices.CreateFourOfAKindHand();
        pokerServices.ScoreHand(lowHand);

        PokerHand highHand = HandScoringTestServices.CreateHighFourOfAKindHand();
        pokerServices.ScoreHand(highHand);

        handsList.add(lowHand);
        handsList.add(highHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highHand));
    }

    @Test
    public void IsHighTripleBetterThanLowTriple() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowHand = HandScoringTestServices.CreateThreeOfAKindHand();
        pokerServices.ScoreHand(lowHand);

        PokerHand highHand = HandScoringTestServices.CreateHighThreeOfAKindHand();
        pokerServices.ScoreHand(highHand);

        handsList.add(lowHand);
        handsList.add(highHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highHand));
    }

    @Test
    public void IsHighTwoPairBetterThanLowTwoPair() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowHand = HandScoringTestServices.CreateTwoPairHand();
        pokerServices.ScoreHand(lowHand);

        PokerHand highHand = HandScoringTestServices.CreateHighTwoPairHand();
        pokerServices.ScoreHand(highHand);

        handsList.add(lowHand);
        handsList.add(highHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highHand));
    }

    @Test
    public void IsHighPairBetterThanLowPair() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowPairHand = HandScoringTestServices.CreateOnePairHand();
        pokerServices.ScoreHand(lowPairHand);

        PokerHand highPairHand = HandScoringTestServices.CreateHighOnePairHand();
        pokerServices.ScoreHand(highPairHand);

        handsList.add(lowPairHand);
        handsList.add(highPairHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highPairHand));
    }

    @Test
    public void IsHighSingleBetterThanLowSingle() {
        final PokerServices pokerServices = new PokerServices();

        List<PokerHand> handsList = new ArrayList<>();
        PokerHand lowSingleHand = HandScoringTestServices.CreateSingleHand();
        pokerServices.ScoreHand(lowSingleHand);

        PokerHand highSingleHand = HandScoringTestServices.CreateHighSingleHand();
        pokerServices.ScoreHand(highSingleHand);

        handsList.add(lowSingleHand);
        handsList.add(highSingleHand);

        Collections.sort(handsList);

        assertThat(handsList.get(0), is(highSingleHand));
    }
}
