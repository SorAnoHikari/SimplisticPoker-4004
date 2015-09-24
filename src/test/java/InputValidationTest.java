import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tony on 9/23/2015.
 */
public class InputValidationTest {
    @Test
    public void CanDetectWrongInput() {
        final PokerServices pokerServices = new PokerServices();
        String input = "1 AceSpades AceSpades AceSpades AceSpades AceCroissants";
        List<String> hand = Arrays.asList(input.split(" "));

        assertThat(pokerServices.IsHandValid(hand), is(false));
    }

    @Test
    public void CanDetectCorrectInput() {
        final PokerServices pokerServices = new PokerServices();
        String input = "1 AceSpades TwoSpades ThreeSpades FourSpades FiveSpades";
        List<String> hand = Arrays.asList(input.split(" "));

        assertThat(pokerServices.IsHandValid(hand), is(true));
    }

    @Test
    public void CanDetectDuplicateCards() {
        final PokerServices pokerServices = new PokerServices();
        String input = "1 AceSpades TwoSpades ThreeSpades FourSpades FiveSpades";
        String oldInput = "1 AceSpades SixSpades SevenSpades EightSpades NineSpades";

        List<String> hand = Arrays.asList(input.split(" "));
        List<String> oldHand = Arrays.asList(oldInput.split(" "));

        List<List<String>> handList = new ArrayList<>();
        handList.add(oldHand);

        assertThat(pokerServices.IsHandContainsDuplicates(hand, handList), is(true));
    }
}
