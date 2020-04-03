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

		// StdOut.println("\nGame begings...\n");
	
		// // Game Logic Starts Here
		// int a=0;
		// ArrayList<Integer> turnScoreList= new ArrayList<Integer>();
		// int numPlayers = Integer.parseInt(numberofPlayer);

		// while (playerList.get(a).getRoundScore()<100)
		// {
		// 	int totalRoundScore=0;
		// 	for (int i=0; i<numPlayers; i++)
		// 	{
		// 		Turn turn = new Turn();

		// 		//ArrayList<Integer> turnScoreList= new ArrayList<Integer>();
		// 		StdOut.println("\n#####################################\nPlayer " + 
		// 					playerList.get(i).getPlayerName().substring(0,1).toUpperCase() + 
		// 					playerList.get(i).getPlayerName().substring(1) + 
		// 					" starts to roll the dice: \n#####################################");
			
		// 		// ask to play y/n	
		// 		StdOut.print("\n" + "Do you want to continue? ");
		// 		Scanner toContinueSc = new Scanner(System.in);
		// 		String toContinue = toContinueSc.nextLine();
				
		// 		int totalTurnScore = 0;
		// 		Map<Integer, List<Integer>> map = new HashMap<>();
		// 		int j=0;
				
		// 		while (toContinue.equalsIgnoreCase("Y")) 
		// 		{
		// 			turn.roll();
					
		// 			List<Integer> diceRoll= new ArrayList<>();

		// 			diceRoll.add(turn.getDie1());
		// 			diceRoll.add(turn.getDie2());

		// 			map.put(j, diceRoll);
		// 			j++;
		// 			if (turn.hasSkunk())
		// 			{
		// 				StdOut.print("\n" + "You got skunked: " + turn.getTypeofSkunk() + "\n");
		// 				StdOut.print("\n" + turn.getRollString() + "\n");
		// 				break;
		// 			}
		// 			else 
		// 			{
		// 				StdOut.print("\n" + turn.getRollString() + "\n");
		// 				StdOut.print("\n" + "Your current turn score is: "  + turn.getScore() + "\n");
		// 				StdOut.print("\n" + "Do you want to continue? ");
		// 				toContinueSc = new Scanner(System.in); 
		// 				toContinue = toContinueSc.nextLine().toUpperCase();			
		// 			}
		// 		}
				
		// 		totalRoundScore += turn.getScore();
		// 		turnScoreList.add(turn.getScore());
		// 		playerList.get(i).setRoundScore(totalRoundScore);
				
				
		// 		StdOut.println("\n=====================================\n" + 
		// 					"Change player, Your turn summary is: " + 
		// 					"\n=====================================");		
		// 		StdOut.print("\nEach dice roll score is: " + map + "\n");	
		// 		StdOut.print("\nYour total turn score is: "  + turn.getScore() + "\n");
		// 		StdOut.print("\nYour round score list is " + turnScoreList + "\n");
		// 		StdOut.print("\nYour total round score is: "  + playerList.get(i).getRoundScore() + "\n");
				
				
		// 		//how many chips lost and remaining
		// 	}
			
			
		// 	}
		// 	StdOut.print("We got a Game Winner! \n");	
		
		}
		
			
		
		 
		
}



