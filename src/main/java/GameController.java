import Models.Card;
import Models.PokerHand;

import java.util.*;

/**
 * Created by Tony on 9/21/2015.
 */
public class GameController {
    private boolean isGameRunning;
    private Scanner in = new Scanner(System.in);
    // Consider removing this later
    private List<List<String>> inputsList;
    private List<PokerHand> handsList;
    PokerServices pokerServices = new PokerServices();

    int numberOfPlayers = 0;

    public void InitializeGame() {
        isGameRunning = true;
    }

    public void MainGameLoop() {
        while (isGameRunning) {
            inputsList = new ArrayList<>();
            handsList = new ArrayList<>();

            System.out.println("\n\nPlease enter the # of players");
            String numOfPlayersString = in.nextLine();
            numberOfPlayers = Integer.parseInt(numOfPlayersString);
            int numberOfHandsEntered = 0;

            /* Get inputs for the hands */
            while (numberOfPlayers != numberOfHandsEntered) {
                System.out.println("enter a hand: ");
                String input = in.nextLine();
                List<String> inputList = Arrays.asList(input.split(" "));
                while (!pokerServices.IsHandValid(inputList) || pokerServices.IsHandContainsDuplicates(inputList, inputsList)) {
                    System.out.println("Invalid input, please enter a hand: ");
                    input = in.nextLine();
                    inputList = Arrays.asList(input.split(" "));
                }

                int playerId = Integer.parseInt(inputList.get(0));
                PokerHand newHand = pokerServices.ConvertListToPokerHand(inputList);
                newHand.setPlayerID(playerId);
                pokerServices.ScoreHand(newHand);

                handsList.add(newHand);
                inputsList.add(inputList);
                numberOfHandsEntered++;
            }
            Collections.sort(handsList);

            for (PokerHand hand : handsList) {
                System.out.println(hand.toString());
            }

            System.out.println("\nAnother round? (Y/N)");
            String playAgainInput = in.nextLine();
            if (playAgainInput.toLowerCase().equals("n"))
                isGameRunning = false;
        }
    }
}
