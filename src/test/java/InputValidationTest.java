import org.junit.Test;

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
}
