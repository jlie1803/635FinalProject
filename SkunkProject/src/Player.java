
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
	
	public String getPlayerName()
	{
		return this.playerNamer;
	}
	
	public int getChips()
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
	
	public void addTurnScore(int turnscore) {
		this.roundScore += turnscore;
	}

	public void addTurnPenalty(int penalty) {
		this.roundScore -= penalty;
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
				+ this.getChips() + " chips.\n";
	}
}
