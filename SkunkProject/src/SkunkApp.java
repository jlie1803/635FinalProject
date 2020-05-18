import edu.princeton.cs.introcs.*;
import java.util.Scanner;

public class SkunkApp {

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);

		Controller controller = new Controller();
		
		int gameNumber = 1;
		while (controller.getState() != "TournamentComplete")
		{
			if (controller.getState() == "InitializeTournament")
			{
				StdOut.print("Welcome to Skunk!\n\nHow many players to play? ");
				String numberOfPlayers = stdIn.nextLine();
				controller.setNumberOfPlayers(Integer.parseInt(numberOfPlayers));
			}
			if (controller.getState() == "AddPlayers")
			{
				StdOut.println("\nWhat's player " + (controller.getPlayerCount()+1) + "'s name: ");
				String playerName = stdIn.nextLine();
				controller.addPlayer(playerName);
			}
			if (controller.getState() == "ActiveTournament")
			{
				StdOut.println("\n\nTournament begins...\n");
				controller.startGame();
			} 
			if (controller.getState() == "GameComplete")
			{
				StdOut.println("\nGame Over!");
				StdOut.println("\n" + controller.getGameScoreBoard());
				StdOut.println("\nPlay Game " + (gameNumber-controller.getNumberOfPlayers()+1) + "?\nEnter for yes, P to pass");
				String action = stdIn.nextLine();
				if (action.equalsIgnoreCase("P"))
				{
					StdOut.println("Not want to play another game");
					StdOut.println("Skunk Over!");
					//show score board
					break;
				}
				else
				{
					controller.nextGame();
				}
				
			}
			while (controller.getState() != "GameComplete" && controller.getState() != "AddPlayers")
			{
				if (controller.getState() == "ActiveGame")
				{
					StdOut.println("\nGame " + (gameNumber-controller.getNumberOfPlayers()+1) + " begins...");
					controller.startRound();
				}
				if (controller.getState() == "ActiveRound")
				{
					if (controller.getActivePlayerName() != "Invalid")
					{
						StdOut.println("\nShow Turn Summary? <Enter or P>");
						String action = stdIn.nextLine();
						if (action.equalsIgnoreCase("P")) {
							
						}
						else
						{
							StdOut.println(controller.getActivePlayerTurnSummary());
						}
					}
						controller.nextPlayer();
						StdOut.println();
					if (controller.getState() != "ActiveRound") {  
						StdOut.println("\nShow current Round Score Board? <Enter or P>");
						String action1 = stdIn.nextLine();
						if (action1.equalsIgnoreCase("P"))
						{
							StdOut.println("\nNew Player:");
						}
						else
						{
							StdOut.println("\n" + controller.getRoundScoreBoard());
							StdOut.println("New Player:");
						}
					}	
				}
				if (controller.getState() == "ActiveTurn")
				{
					StdOut.println("#####################################");
					StdOut.println(controller.getActivePlayerName() + "'s turn");
					StdOut.println("#####################################");
					StdOut.println(controller.getActivePlayerName() + " Turn Score: " + controller.getActivePlayerTurnScore());

					StdOut.println("\nRoll or Pass <Enter or P> ");
					String action = stdIn.nextLine();
					if (action.equalsIgnoreCase("P")) {
						StdOut.println(controller.getActivePlayerName() + " decided to pass");
						StdOut.println(controller.getActivePlayerName() + "'s Turn Score: " + controller.getActivePlayerTurnScore());
						controller.pass();
					}
					else {
						StdOut.println(controller.getActivePlayerName() + " decided to roll");
						controller.roll();
						if (controller.getState()=="TournamentComplete")
						{
							StdOut.println("\nTournament Over!\n");
							StdOut.println(controller.getTournamentScoreBoard());
						}
						else
						{
							StdOut.println(controller.getRollResult());
							StdOut.println(controller.getActivePlayerName() + "'s Turn Score: " + controller.getActivePlayerTurnScore() + "\n");
						}	
					}
				}
			} 
			gameNumber++; 
		}
		stdIn.close();
	}
}