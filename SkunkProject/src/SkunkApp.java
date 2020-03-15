import edu.princeton.cs.introcs.*;
import java.util.Scanner;

public class SkunkApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.println("Welcome!");

		/*
		 * Dice dice = new Dice(); dice.roll();
		 * 
		 * 
		 * StdOut.print(dice.toString());
		 */

		// ask for player's name
		StdOut.println();
		StdOut.print("Enter player's name: ");
		Scanner playerNameSc = new Scanner(System.in);
		String playerName = playerNameSc.nextLine();
		StdOut.println("\n" + "Player " + playerName + " starts to play:" + "\n"
				+ "=======================================================");

		// ask to play y/n
		StdOut.print("\n" + "Do you want to continue? ");
		Scanner toContinueSc = new Scanner(System.in);
		String toContinue = toContinueSc.nextLine();
		while (toContinue.equalsIgnoreCase("Y")) {
			// roll
			/*
			 * dice.roll; if (isSkunk) { StdOut.println("Sorry, your turn is over! ");
			 * break; }
			 */
			
			Dice dice = new Dice();
			dice.roll();
			//StdOut.print("\n" + dice.toString() + "\n");
			
			if (dice.hasSkunk())
			{
				StdOut.print("\n" + "You got skunked!" + "\n");
				StdOut.print("\n" + dice.toString() + "\n");
				break;
			}
			
			else 
			{
				StdOut.print("\n" + dice.toString() + "\n");
				StdOut.print("\n" + "Do you want to continue? ");
				toContinueSc = new Scanner(System.in); 
				toContinue = toContinueSc.nextLine().toUpperCase();
			}
			
			 
			// StdOut.print("continue");
		}
		// summary turnSummary
		StdOut.println("\n" + "Change player, Your turn summary is: ");

	}

}
