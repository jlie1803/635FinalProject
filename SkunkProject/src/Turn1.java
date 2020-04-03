import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Turn1 {
	
	private int turnScore=0;
	private Kitty kitty;
	private Dice dice=new Dice();
	private Player player;
	private int playerChip;
	private int totalChip;
	private int totalKitty;
	
	
	private boolean isSkunk;
	public boolean toContinue; 
	
	public Turn1()
	{
		
	}
	
	public Turn1(Player player, int turnScore)
	{
		this.player=player;
		this.turnScore=turnScore;			
	}
	
	/*
	 * public void turn() { Dice dice = new Dice(); while (this.toContinue) {
	 * dice.roll(); if (dice.hasSkunk()) { break; } } }
	 */
	/*
	 * public Map turnResult() {
	 * if (dice.oneSkunk())
			{
				this.turnScore = 0;
				//this.totalChip = player.getChip(player.getPlayerName()) - 1;
				//this.totalKitty = kitty.getKitty() + 1;		
				break;
			}

			if (dice.skunkDeuce())
			{
				this.turnScore = 0;
				//this.totalChip = player.getChip(player.getPlayerName()) - 2;
				//this.totalKitty = kitty.getKitty() + 2;
				break;
			}
			
			if (dice.twoSkunk())
			{
				this.turnScore = 0;
				//this.totalChip = player.getChip(player.getPlayerName()) - 4;
				//this.totalKitty = kitty.getKitty() + 4;
				break;
			}
			StdOut.print("\n" + dice.toString() + "\n");
			StdOut.print("\n" + "Continue? ");
			Scanner toContinueSc = new Scanner(System.in); 
			String toContinue = toContinueSc.nextLine();
					
	 * 
	 * }
	 */
	
	public void turn()
	{	
		dice.roll();
		StdOut.print("\n" + dice.toString() + "\n");
		toContinue=false;
		
		
		/*
		 * if (!dice.hasSkunk()) { dice.roll(); StdOut.print("\n" + dice.toString() +
		 * "\n"); toContinue=false; } else { toContinue=false; StdOut.print("\n" +
		 * "You got skunked: " + dice.getTypeofSkunk() + "\n"); StdOut.print("\n" +
		 * dice.toString() + "\n");
		 * 
		 * }
		 */
		
			
		

		
		
		
			/*
			 * turnScore = turnScore + dice.getLastRoll(); List<Integer> diceRoll= new
			 * ArrayList<>(); diceRoll.add(dice.getDie1().getLastRoll());
			 * diceRoll.add(dice.getDie2().getLastRoll());
			 */
				
			//rollScoresMap.put(i, diceRoll);
			//i++;		
			
	}
		
		
		
		
		
	
	/*
	 * public int getTurnScore(String playerName) { this.turn();
	 * 
	 * if (dice.oneSkunk()) { this.turnScore = 0; this.totalChip =
	 * player.getChip(player.getPlayerName()) - 1; this.totalKitty =
	 * kitty.getKitty() + 1; }
	 * 
	 * if (dice.skunkDeuce()) { this.turnScore = 0; this.totalChip =
	 * player.getChip(player.getPlayerName()) - 2; this.totalKitty =
	 * kitty.getKitty() + 2; }
	 * 
	 * if (dice.twoSkunk()) { this.turnScore = 0; this.totalChip =
	 * player.getChip(player.getPlayerName()) - 4; this.totalKitty =
	 * kitty.getKitty() + 4; }
	 * 
	 * 
	 * StdOut.print("\n" + "You got skunked: " + dice.getTypeofSkunk() + "\n");
	 * StdOut.print("\n" + dice.toString() + "\n");
	 * 
	 * return this.turnScore; }
	 */
	public String toString()
	{
		return ("Player 1 Turn Score is " + player.getTurnScore());
		// print turnSummary	
		//StdOut.println("\n" + "========================================" + "\n" + "Change player, Your turn summary is: " + "\n" + "========================================" + "\n");	
		//print each roll summary		
		//StdOut.print("Each dice roll score is: " + map + "\n");	
		//StdOut.print("\n" + "Your total turn score is: "  + totalScore + "\n");
		//how many chips lost and remaining
	}

}
