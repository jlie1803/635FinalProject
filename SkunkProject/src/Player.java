
public class Player {


	private int turnScore=0;
	private int roundScore=0;
	private int totalChip=50;
	private String playerNamer;
	
	public Player()
	{
	
	}
	
	
	public Player(String playerName)
	{
		this.playerNamer= playerName;
	}
	
	/*
	 * public Player(String playerName, int turnScore, int roundScore, int
	 * totalChip) //how to get score from Games and Turns { this.playerNamer=
	 * playerName; this.turnScore= 0; this.roundScore= 0; this.totalChip= 50; }
	 */
	
	public String getPlayerName()
	{
		return this.playerNamer;
	}
	
	public int getChip(String playerName)
	{
		return this.totalChip;
	}
	public int getTurnScore()
	{
		return this.turnScore;
	}
	
	public int getRoundScore()
	{
		return this.roundScore;
	}
	public void setRoundScore(int roundScore)
	{
		this.roundScore=roundScore;
	}
	
	public void setPlayerName(String playerName)
	{
		this.playerNamer=playerName;
	}
	
	public String toString()
	{
		return "Player " + this.getPlayerName() + 
				" has a Turn score of " + this.getTurnScore() + 
				", Round score of " + this.getRoundScore() + ", and " 
				+ this.getChip(this.getPlayerName()) + " chips.\n";
	}
}
