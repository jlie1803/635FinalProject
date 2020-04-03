import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	private String state;
	private int numberOfPlayers;
	private List<Player> playerList;
	private int activePlayer;
	private int goalPlayer;
	private Dice dice;
	private Turn turn;
	private String skunkState;

	public Controller()
	{
		this(new Die(), new Die());
	}

	public Controller(Die die1, Die die2)
	{
		this.state = "InitializeGame";
		this.numberOfPlayers = 0;
		this.playerList = new ArrayList<Player>();
		this.activePlayer = -1;
		this.goalPlayer = -1;
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
			this.state = "ActiveGame";
		}
	}

	public String getRoundScoreBoard() {
		String result = "Player Scores:\n";
		result += "----------------\n";
		for (int i=0; i < this.playerList.size(); i++) {
			Player p = this.playerList.get(i);
			result += p.getPlayerName() + ":  Score: " + p.getRoundScore() + ",  Chips: " + p.getChips() + "\n";
		}
		return result;
	}

	public void startRound() {
		this.state = "ActiveRound";
		this.activePlayer = -1;
	}

	public void startTurn() {
		this.state = "ActiveTurn";
		this.turn = new Turn(this.dice);
	}

	private Player getActivePlayer() {
		if (this.activePlayer < 0 || this.activePlayer == this.getNumberOfPlayers()) return null;
		return this.playerList.get(this.activePlayer);
	}

	public void roll() {
		this.turn.roll();
		
		if (this.turn.hasSkunk()) {
			int penalty = this.turn.getPenalty();
			this.getActivePlayer().addTurnPenalty(penalty);
			if (penalty == 4) {
				this.getActivePlayer().setRoundScore(0);
			}
			this.state = "ActiveRound";
			this.nextPlayer();
			return;
		}
	}

	public void pass() {
		this.getActivePlayer().addTurnScore(this.turn.getScore());
		if (this.getActivePlayer().getRoundScore() >= 100)
		{
			this.state = "EndGameRound";
			this.goalPlayer = this.activePlayer;
		}
		else {
			this.state = "ActiveRound";
		}

		this.nextPlayer();
	}

	public String getActivePlayerName() {
		if (this.getActivePlayer() == null) return "Invalid";

		return this.getActivePlayer().getPlayerName();
	}

	public void nextPlayer() {
		this.activePlayer += 1;
		this.turn = new Turn(this.dice);
		if (this.state == "EndGameRound" && this.activePlayer == this.goalPlayer)
		{
			this.state = "GameComplete";
			this.activePlayer = -1;
		}
		else if (this.state == "EndGameRound" && this.activePlayer == this.getNumberOfPlayers())
		{
			this.activePlayer = -1;
			this.skunkState = "EndGameRound";
		}
		else if (this.state == "ActiveRound" && this.activePlayer == this.getNumberOfPlayers())
		{
			this.state = "ActiveGame";
			this.activePlayer = -1;
		}
		else if (this.state == "ActiveRound")
		{
			this.state = "ActiveTurn";
		}
		
		
	}
	
	public int getActivePlayerTurnScore() {
		return this.turn.getScore();
	}
	
	public String getRollResult() {
		if (this.turn.hasSkunk()) {
			return "You got skunked: " + this.turn.getTypeofSkunk() +
					"\n\n" + turn.getRollString() + "\n";
		}
		
		return "\n" + turn.getRollString() + "\n\nYour current turn score is: "  + turn.getScore() + "\n";
	}
}
