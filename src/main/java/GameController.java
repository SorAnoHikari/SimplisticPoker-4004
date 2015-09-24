import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tony on 9/21/2015.
 */
public class GameController {
    private boolean isGameRunning;
    private Scanner in = new Scanner(System.in);
    private List<List<String>> handsList;

    int numberOfPlayers = 0;

    public void InitializeGame() {
        isGameRunning = true;
    }

    public void MainGameLoop() {
        handsList = new ArrayList<List<String>>();

        while (isGameRunning) {
            System.out.println("Please enter the # of players");
            String numOfPlayersString = in.next();
            numberOfPlayers = Integer.parseInt(numOfPlayersString);
            int numberOfHandsEntered = 0;

            while (numberOfPlayers != numberOfHandsEntered) {
                System.out.println("enter a hand: ");
                String input = in.nextLine();
                // TODO: Validate the input

                List<String> inputList = Arrays.asList(input.split(" "));

                String playerId = inputList.get(0);
                handsList.add(inputList);
                numberOfHandsEntered++;
            }
            //TODO: Calculate scores and compare
        }
    }
}
