
public class Turn1 {
	
	private int turnScore;
	private Kitty kitty;
	private Dice dice;
	private Player player;
	private int playerChip;
	private int totalChip;
	
	private boolean isSkunk;
	private boolean continueToRoll; 
	
	
	
	public Turn1(Player player, int turnScore)
	{
		this.player=player;
		this.turnScore=turnScore;			
	}
	
	public int getTurnScore(int id)
	{
		while ((! isSkunk) || (continueToRoll))
		{
			dice.roll();
			turnScore= dice.getLastRoll() + this.getTurnScore(id);
		}
	
		if (dice.oneSkunk())
		{
			this.turnScore = 0;
			this.playerChip = player.getChip(id) - 1;
			this.totalChip= kitty.getKitty() + 1;
		}
		
		if (dice.skunkDeuce())
		{
			this.turnScore = 0;
			playerChip = player.getChip(id) - 2;
			this.totalChip= kitty.getKitty() + 2;
		}
		
		if (dice.twoSkunk())
		{
			this.turnScore = 0;
			playerChip = player.getChip(id) - 4;
			this.totalChip= kitty.getKitty() + 4;
		}
		
		return this.turnScore;
	}
	
	public String toString()
	{
		return ("Player 1 Turn Score is " + player.getTurnScore());
	}

}
