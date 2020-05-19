import java.util.ArrayList;
import java.util.List;

public class Controller{
	
	private String state;
	private int numberOfPlayers;
	private List<Player> playerList;
	private int activePlayer;
	private int goalPlayer;
	private Dice dice;
	private Turn turn;

	public Controller()
	{
		this(new Die(), new Die());
	}

	public Controller(Die die1, Die die2)
	{
		this.state = "InitializeTournament";
		this.numberOfPlayers = 0;
		this.playerList = new ArrayList<Player>();
		this.activePlayer = -1;
		this.goalPlayer = -2;
		this.dice = new Dice(die1, die2);
	}
	
	public String getState() {
		return state;
	}

	public void setNumberOfPlayers(int numPlayers) {
		this.numberOfPlayers = numPlayers;
		this.state = "AddPlayers";
	}

	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}

	public int getPlayerCount() {
		return this.playerList.size();
	}

	public void addPlayer(String playerName) {
		this.playerList.add(new Player(playerName));
		if (this.playerList.size() == this.getNumberOfPlayers()) {
			this.state = "ActiveTournament";
		}
	}
	
	public void startGame() {
		this.state = "ActiveGame";
		this.activePlayer = -1;
	}
	
	public void nextGame() {
		this.state = "ActiveGame";
		for (int i=0; i < this.playerList.size(); i++) {
			Player p = this.playerList.get(i);
			p.setRoundScore(0);
			p.setChips(p.getChips());
		}
		this.turn.setKitty(0);
		this.activePlayer = -1;
		this.goalPlayer = -2;
	}
	
	public void startRound() {
		this.state = "ActiveRound";
		this.activePlayer = -1;
	}
	
	private Player getActivePlayer() {
		if (this.activePlayer < 0 || this.activePlayer == this.getNumberOfPlayers()) return null;
		return this.playerList.get(this.activePlayer);
	}
	
	public String getActivePlayerName() {
		if (this.getActivePlayer() == null) return "Invalid";

		return this.getActivePlayer().getPlayerName();
	}

	public void nextPlayer() {
		this.activePlayer += 1;
		this.turn = new Turn(this.dice);
		if (this.state == "ActiveRound" && this.activePlayer == this.getNumberOfPlayers())
		{
			this.state = "ActiveRound";
			this.activePlayer = -1;
		}
		else if (this.state == "ActiveRound")
		{
			this.state = "ActiveTurn";
		}
		if (this.activePlayer == this.goalPlayer)
		{
			StdOut.println(this.getRoundScoreBoard());
			this.state = "GameComplete";
			this.activePlayer = -1;
			this.turn.setKitty(0);
		}
	}

	public String getTournamentScoreBoard()
	{
		String result = "Tournament Score Board:\n";
		result += "----------------\n";
		return result;
	}
	
	public String getGameScoreBoard()
	{
		int goalKitty=0;
		String result = "We got a game Winner! <<< " + this.getGoalPlayerName() + " >>>\n";
		result += "\nGame Score Board:\n";
		result += "----------------\n";
		for (int i=0; i < this.playerList.size(); i++) {
			Player p = this.playerList.get(i);
			if (p.getPlayerName() != this.getGoalPlayerName())
			{
				if (p.getRoundScore()==0)
				{
					goalKitty +=10;
				}
				else 
				{
					goalKitty+=5;
				}
			}
		}
		result += this.getGoalPlayerName() + ": Score: " + this.playerList.get(this.goalPlayer).getRoundScore() + ", Chips: " + (this.playerList.get(this.goalPlayer).getChips()+this.turn.getKitty() + goalKitty + "\n");
		this.playerList.get(this.goalPlayer).setChips(this.playerList.get(this.goalPlayer).getChips()+this.turn.getKitty() + goalKitty);
		this.turn.setKitty(0);
		for (int i=0; i < this.playerList.size(); i++) {
			Player p = this.playerList.get(i);
			if (p.getPlayerName() != this.getGoalPlayerName()) 
			{	
				if (p.getRoundScore()==0)
				{
					result += p.getPlayerName() + ":  Score: " + p.getRoundScore() + ",  Chips: " + (p.getChips()-10) + "\n";
					p.setChips(p.getChips()-10);
				}
				else
				{
					result += p.getPlayerName() + ":  Score: " + p.getRoundScore() + ",  Chips: " + (p.getChips()-5) + "\n";
					p.setChips(p.getChips()-5);
				}
			}
		}
		result += "Total kitty is " + this.turn.getKitty() + ".\n";
		this.turn.setKitty(0);
		return result;
	}
	
	public String getRoundScoreBoard() {
		String result = "Round Score Board:\n";
		result += "----------------\n";
		int kitty=0;
		for (int i=0; i < this.playerList.size(); i++) {
			Player p = this.playerList.get(i);
			result += p.getPlayerName() + ":  Score: " + p.getRoundScore() + ",  Chips: " + p.getChips() + "\n";
			kitty+=p.getKitty();
		}
		this.turn.setKitty(kitty);
		result+="Total kitty is " + kitty + ".\n";
		
		return result;
	}	

	public void roll() {
		this.turn.roll();

		if (this.getActivePlayer().getChips()<=20)
		{
			//this.state="GameComplete";
			this.state="TournamentComplete";
		}
		if (this.turn.hasSkunk()) {
			int penalty = this.turn.getPenalty();
			this.getActivePlayer().addTurnPenalty(penalty);
			this.getActivePlayer().addKitty(penalty);
			if (penalty == 4) {
				this.getActivePlayer().setRoundScore(0);
			}
			this.state = "ActiveRound";
			return;
		}
	}

	public void pass() {
		this.getActivePlayer().addTurnScore(this.turn.getScore());
		if (this.getActivePlayer().getRoundScore() >= 20)
		{
			StdOut.println(this.getRoundScoreBoard());
			this.state = "GameComplete";
			this.goalPlayer = this.activePlayer;
		}
		else 
		{
			this.state = "ActiveRound";
		}
	}

	public Player getGoalPlayer()
	{
		return this.playerList.get(this.goalPlayer);
	}
	
	public String getGoalPlayerName()
	{
		return this.playerList.get(this.goalPlayer).getPlayerName();
	}
	
	public int getActivePlayerTurnScore() {
		return this.turn.getScore();
	}

	public int getActivePlayerGameScore() {
		return this.getActivePlayer().getRoundScore();
	}
	
	public String getRollResult() {
		return this.turn.getRollString();
	}

	public String getPlayerSummary() {
		if (this.getActivePlayer() == null) return "";
		return this.getActivePlayerName().toString();
	}

	public String getActivePlayerTurnSummary() {
		return this.turn.getTurnSummary();
	}
}
