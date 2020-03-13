
public class Player {

	private int id;
	private int turnScore;
	private int gameScore;
	private int chip;
	
	public Player()
	{
	
	}
	
	public Player(int id)  //how to get score from Games and Turns
	{
		this.id= id;
	}
	
	public Player(int id, int turnScore, int gameScore, int chip)  //how to get score from Games and Turns
	{
		this.id= id;
		this.turnScore= turnScore;
		this.gameScore= gameScore;
		this.chip= chip;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public int getChip(int id)
	{
		return this.chip;
	}
	public int getTurnScore()
	{
		return this.turnScore;
	}
	
	public int getGameScore()
	{
		return this.gameScore;
	}
	
	public String toString()
	{
		return "Player " + this.getID() + " has a Turn score of " + this.getTurnScore() + ", Game score of " + this.getGameScore() + ", and " 
				+ this.getChip(this.getID()) + " chips.";
	}
	
	public static void main(String[] args)
	{ 
		Player p1 = new Player(1, 0, 0, 50);
		System.out.println(p1.toString());
	}
}
