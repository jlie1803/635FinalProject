import edu.princeton.cs.introcs.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkunkApp {

	public static void main(String[] args) {
		// ask how many players
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
	
		
		int a=0;
		while (playerList.get(a).getRoundScore()<100)
		{
			int totalRoundScore=0;
			for (int i=0; i<Integer.parseInt(numberofPlayer); i++)
			{
				ArrayList turnScoreList = new ArrayList();
				StdOut.println("\n=====================================\nPlayer " + 
							playerList.get(i).getPlayerName().substring(0,1).toUpperCase() + 
							playerList.get(i).getPlayerName().substring(1) + 
							" starts to roll the dice: \n=====================================");
			
				// ask to play y/n	
				StdOut.print("\n" + "Do you want to continue? ");
				Scanner toContinueSc = new Scanner(System.in);
				String toContinue = toContinueSc.nextLine();
				int totalTurnScore = 0;
				Map<Integer, List<Integer>> map = new HashMap<>();
				int j=0;
				
				while (toContinue.equalsIgnoreCase("Y")) 
				{
					Dice dice = new Dice();
					
					dice.roll();
					totalTurnScore = totalTurnScore + dice.getLastRoll();	
					List<Integer> diceRoll= new ArrayList<>();
					diceRoll.add(dice.getDie1().getLastRoll());
					diceRoll.add(dice.getDie2().getLastRoll());
					
					map.put(j, diceRoll);
					j++;
					
					if (dice.hasSkunk())
					{
						StdOut.print("\n" + "You got skunked: " + dice.getTypeofSkunk() + "\n");
						StdOut.print("\n" + dice.toString() + "\n");
						totalTurnScore=0;
						break;
					}
					else 
					{
						StdOut.print("\n" + dice.toString() + "\n");
						StdOut.print("\n" + "Your current turn score is: "  + totalTurnScore + "\n");
						StdOut.print("\n" + "Do you want to continue? ");
						toContinueSc = new Scanner(System.in); 
						toContinue = toContinueSc.nextLine().toUpperCase();			
					}
				}
				totalRoundScore= totalRoundScore + totalTurnScore;
				turnScoreList.add(a, totalTurnScore);
				playerList.get(a).setRoundScore(totalRoundScore);
				
				
				StdOut.println("\n#####################################\n" + 
							"Change player, Your turn summary is: " + 
							"\n#####################################\n");		
				StdOut.print("\nEach dice roll score is: " + map + "\n");	
				StdOut.print("\nYour total turn score is: "  + totalTurnScore + "\n");
				StdOut.print("\nYour total round score is: "  + playerList.get(i).getRoundScore() + "\n");
				StdOut.print(turnScoreList);
				
				//how many chips lost and remaining
			}
			
			
			}
			StdOut.print("We got a Game Winner! \n");	
		
		}
		
			
		
		 
		
}



