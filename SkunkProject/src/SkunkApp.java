import edu.princeton.cs.introcs.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkunkApp {

	public static void main(String[] args) {
		// Initialize Players for the Game.
		StdOut.print("Welcome to Skunk!\n\nHow many players to play? ");
		//user enter how many players
		Scanner numberofPlayerSc = new Scanner(System.in);
		String numberofPlayer = numberofPlayerSc.nextLine();
		//controller.setPlayerList();
		List<Player> playerList = new ArrayList<Player>();
		
		// ask for each player's name
		StdOut.println("\nPlease enter each player's name: ");
		for (int i=0; i<Integer.parseInt(numberofPlayer); i++)
		{
			StdOut.println("\nWhat's player " + (i+1) + " name: ");
			Scanner playerNameSc = new Scanner(System.in);
			String playerName = playerNameSc.nextLine();
			Player player = new Player(playerName);
			playerList.add(i, player);			
		}
		StdOut.println("\nPlayers are all added.\nHere are each player's info:\n");
		String formattedPlayerList = playerList.toString().replace(",", "").replace("[", "").replace("]", "").trim();           
		StdOut.println(formattedPlayerList);
		StdOut.println("\nGame begings...\n");
	
		// Game Logic Starts Here
		int a=0;
		ArrayList<Integer> turnScoreList= new ArrayList<Integer>();
		int numPlayers = Integer.parseInt(numberofPlayer);

		while (playerList.get(a).getRoundScore()<100)
		{
			int totalRoundScore=0;
			for (int i=0; i<numPlayers; i++)
			{
				Turn turn = new Turn();

				//ArrayList<Integer> turnScoreList= new ArrayList<Integer>();
				StdOut.println("\n#####################################\nPlayer " + 
							playerList.get(i).getPlayerName().substring(0,1).toUpperCase() + 
							playerList.get(i).getPlayerName().substring(1) + 
							" starts to roll the dice: \n#####################################");
			
				// ask to play y/n	
				StdOut.print("\n" + "Do you want to continue? ");
				Scanner toContinueSc = new Scanner(System.in);
				String toContinue = toContinueSc.nextLine();
				
				int totalTurnScore = 0;
				Map<Integer, List<Integer>> map = new HashMap<>();
				int j=0;
				
				while (toContinue.equalsIgnoreCase("Y")) 
				{
					turn.roll();
					
					List<Integer> diceRoll= new ArrayList<>();

					diceRoll.add(turn.getDie1());
					diceRoll.add(turn.getDie2());

					map.put(j, diceRoll);
					j++;
					if (turn.hasSkunk())
					{
						StdOut.print("\n" + "You got skunked: " + turn.getTypeofSkunk() + "\n");
						StdOut.print("\n" + turn.getRollString() + "\n");
						break;
					}
					else 
					{
						StdOut.print("\n" + turn.getRollString() + "\n");
						StdOut.print("\n" + "Your current turn score is: "  + turn.getScore() + "\n");
						StdOut.print("\n" + "Do you want to continue? ");
						toContinueSc = new Scanner(System.in); 
						toContinue = toContinueSc.nextLine().toUpperCase();			
					}
				}
				
				totalRoundScore += turn.getScore();
				turnScoreList.add(turn.getScore());
				playerList.get(i).setRoundScore(totalRoundScore);
				
				
				StdOut.println("\n=====================================\n" + 
							"Change player, Your turn summary is: " + 
							"\n=====================================");		
				StdOut.print("\nEach dice roll score is: " + map + "\n");	
				StdOut.print("\nYour total turn score is: "  + turn.getScore() + "\n");
				StdOut.print("\nYour round score list is " + turnScoreList + "\n");
				StdOut.print("\nYour total round score is: "  + playerList.get(i).getRoundScore() + "\n");
				
				
				//how many chips lost and remaining
			}
			
			
			}
			StdOut.print("We got a Game Winner! \n");	
		
		}
		
			
		
		 
		
}



