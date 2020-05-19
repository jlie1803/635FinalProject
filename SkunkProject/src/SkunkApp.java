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
				StdOut.println("\nPlay Game " + (gameNumber-controller.getNumberOfPlayers()+1) + "?  <Enter or P>");
				String action = stdIn.nextLine();
				if (action.equalsIgnoreCase("P"))
				{
					StdOut.println("Skunk Over!");
					StdOut.println("\nShow Current Tournament Board  <Enter or P>");
					break;
				}
				else
				{
					controller.nextGame();
				}
			}
			int roundNumber=1;
			while (controller.getState() != "GameComplete" && controller.getState() != "AddPlayers")
			{
				if (controller.getState() == "ActiveGame")
				{
					StdOut.println("\nGame " + (gameNumber-controller.getNumberOfPlayers()+1) + " begins...");
					StdOut.println("\nRound " + roundNumber + ": ");
					controller.startRound();
					if (gameNumber != controller.getNumberOfPlayers() )  //bug: kitty != 0 at new game
					{
					StdOut.println("\nShow current Round Score Board  <Enter or P>");
					String action2 = stdIn.nextLine();
						if (action2.equalsIgnoreCase("P"))
						{
							StdOut.println();
						}
						else
						{
							StdOut.println(controller.getRoundScoreBoard());
						}
					}
				}
				
				if (controller.getState() == "ActiveRound")
				{
					if (controller.getActivePlayerName() != "Invalid")
					{
						StdOut.println("\nShow Turn Summary  <Enter or P>");
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
				}
						
				if (controller.getState() == "ActiveRound" && controller.getState() != "ActiveTurn") 
				{  
						StdOut.println("\nShow current Round Score Board  <Enter or P>");
						String action1 = stdIn.nextLine();
						if (action1.equalsIgnoreCase("P"))
						{
							StdOut.println("");
						}
						else
						{
							StdOut.println(controller.getRoundScoreBoard());
						}
						StdOut.println("\nRound " + (roundNumber+1) + ":");
						roundNumber++;  
				}
				
				if (controller.getState() == "ActiveTurn")
				{
					StdOut.println("#####################################");
					StdOut.println(controller.getActivePlayerName() + "'s turn");
					StdOut.println("#####################################");
					StdOut.println(controller.getActivePlayerName() + " Turn Score: " + controller.getActivePlayerTurnScore());

					StdOut.println("\nRoll or Pass  <Enter or P> ");
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