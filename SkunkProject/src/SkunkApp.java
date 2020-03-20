import edu.princeton.cs.introcs.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkunkApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.println("Welcome to Skunk!");
		// ask for player's name
		StdOut.println();
		StdOut.print("Enter player's name: ");
		Scanner playerNameSc = new Scanner(System.in);
		String playerName = playerNameSc.nextLine();
		StdOut.println("\n" + "=====================================" + "\n" + "Player " + playerName.substring(0,1).toUpperCase() + playerName.substring(1) + " starts to play: " + "\n" + "=====================================");
		
		// ask to play y/n
		StdOut.print("\n" + "Do you want to continue? ");
		Scanner toContinueSc = new Scanner(System.in);
		String toContinue = toContinueSc.nextLine();
		int totalTurnScore = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		//Map<String, List<Integer>> map = new HashMap<>(); //how to add explicit roll names in summary?
		int i=0;
		while (toContinue.equalsIgnoreCase("Y")) 
		{
			Dice dice = new Dice();
			
			dice.roll();
			totalTurnScore = totalTurnScore + dice.getLastRoll();	
			List<Integer> diceRoll= new ArrayList<>();
			diceRoll.add(dice.getDie1().getLastRoll());
			diceRoll.add(dice.getDie2().getLastRoll());
			
			map.put(i, diceRoll);
			i++;
			
			if (dice.hasSkunk())
			{
				StdOut.print("\n" + "You got skunked: " + dice.getTypeofSkunk() + "\n");
				StdOut.print("\n" + dice.toString() + "\n");
				
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
		// print turnSummary	
		StdOut.println("\n" + "========================================" + "\n" + "Change player, Your turn summary is: " + "\n" + "========================================" + "\n");	
		//print each roll summary		
		StdOut.print("Each dice roll score is: " + map + "\n");	
		StdOut.print("\n" + "Your total turn score is: "  + totalTurnScore + "\n");
		//how many chips lost
	}
}



















