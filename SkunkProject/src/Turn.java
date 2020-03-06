
public class Turn {

	private Dice dice;
	private int score;
	private boolean skunked;
	
	public Turn() {
		this.dice = new Dice();
		this.score = 0;
		this.skunked = false;
		this.roll();
	}
	
	public Turn(Dice dice) {
		this.dice = dice;
		this.score = 0;
		this.skunked = false;
		this.roll();
	}

	public int getScore() {
		return score;
	}

	public void roll() {
		if (this.skunked) return;
		this.score += dice.getLastRoll();
		this.skunked = dice.hasSkunk();
		if (this.skunked)
		{
			this.score = 0;
		}
		dice.roll();
	}
}
