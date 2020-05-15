
public class Player {


	private int turnScore;
	private int roundScore;
	private int totalChip;
	private int kitty;
	private String playerNamer;
	
	public Player()
	{
	
	}
	
	public Player(String playerName)
	{
		this.playerNamer = playerName.substring(0, 1).toUpperCase() + playerName.substring(1);
		turnScore = 0;
		roundScore = 0;
		totalChip = 50;
		kitty = 0;
	}
	
	public String getPlayerName()
	{
		return this.playerNamer;
	}
	
	public int getChips()
	{
		return this.totalChip;
	}
	
	public void setChips(int chip)
	{
		this.totalChip=chip;
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
		this.totalChip -= penalty;
	}

	public void addKitty(int penalty)
	{
		this.kitty+=penalty;
	}
	public int getKitty()
	{
		return this.kitty;
	}
	
	public void setPlayerName(String playerName)
	{
		this.playerNamer=playerName;
	}
}
