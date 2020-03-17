import edu.princeton.cs.introcs.*;
import java.util.Scanner;

public class SkunkApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.println("Welcome to Skunk!");
		// ask for player's name
		StdOut.println();
		StdOut.print("Enter player's name: ");
		Scanner playerNameSc = new Scanner(System.in);
		String playerName = playerNameSc.nextLine();
		StdOut.println("\n" + "=====================================" + "\n" + "Player " + playerName + " starts to play: " + "\n" + "=====================================");
		
		// ask to play y/n
		StdOut.print("\n" + "Do you want to continue? ");
		Scanner toContinueSc = new Scanner(System.in);
		String toContinue = toContinueSc.nextLine();
		int totalTurnScore = 0;
		while (toContinue.equalsIgnoreCase("Y")) 
		{
			Dice dice = new Dice();
			dice.roll();
			totalTurnScore = totalTurnScore + dice.getLastRoll();
			
			if (dice.hasSkunk())   //needs to add what kind of skunk
			{
				StdOut.print("\n" + "You got skunked: " + dice.getTypeofSkunk());
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
		StdOut.println("\n" + "========================================" + "\n" + "Change player, Your turn summary is: " + "\n" + "========================================");
		StdOut.print("\n" + "Total turn score is: "  + totalTurnScore + "\n");

	}

}
