import edu.princeton.cs.introcs.*;
import java.util.Scanner;

public class SkunkApp {

	public static void main(String[] args) {
		// Initialize Players for the Game.
		// Current Controller State: InitializeGame

		Scanner stdIn = new Scanner(System.in);

		Controller controller = new Controller();

		while (controller.getState() != "GameComplete")
		{
			if (controller.getState() == "InitializeGame")
			{
				StdOut.print("Welcome to Skunk!\n\nHow many players to play? ");
				String numberOfPlayers = stdIn.nextLine();
				controller.setNumberOfPlayers(Integer.parseInt(numberOfPlayers));
			}
			if (controller.getState() == "AddPlayers")
			{
				StdOut.println("\nWhat's player " + (controller.getPlayerCount()+1) + " name: ");
				String playerName = stdIn.nextLine();
				controller.addPlayer(playerName);
			}
			if (controller.getState() == "ActiveGame")
			{
				StdOut.println("\nGame begins...\n");
				controller.startRound();
			}
			if (controller.getState() == "ActiveRound")
			{
				if (controller.getActivePlayerName() != "Invalid")
				{
					StdOut.println(controller.getActivePlayerTurnSummary());
				}
				controller.nextPlayer();
				StdOut.println(controller.getRoundScoreBoard());
			}
			if (controller.getState() == "ActiveTurn" || controller.getState() == "EndGameRound")
			{
				StdOut.println("\n#####################################");
				StdOut.println(controller.getActivePlayerName() + "'s turn");
				StdOut.println("#####################################");
				StdOut.println(controller.getActivePlayerName() + " Turn Score: " + controller.getActivePlayerTurnScore());

				StdOut.println("\nRoll or Pass (r/p):");
				String action = stdIn.nextLine();
				if (action.equalsIgnoreCase("R")) {
					StdOut.println(controller.getActivePlayerName() +" decided to roll");
					controller.roll();
					StdOut.println(controller.getRollResult());
					StdOut.println(controller.getActivePlayerName() + "'s Turn Score: " + controller.getActivePlayerTurnScore());
				}
				else
				{
					StdOut.println(controller.getActivePlayerName() +" decided to pass");
					StdOut.println(controller.getActivePlayerName() + "'s Turn Score: " + controller.getActivePlayerTurnScore());
					controller.pass();
				}
			}
		}

		StdOut.println();
		StdOut.println(controller.getRoundScoreBoard());

		stdIn.close();
	}
}