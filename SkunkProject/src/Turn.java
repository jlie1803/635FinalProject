
public class Turn {

	private Dice dice;
	private int score;
	
	public Turn() {
		dice = new Dice();
		score = 0;
		this.roll();
	}
	
	public Turn(Dice dice) {
		this.dice = dice;
		this.roll();
	}

	public int getScore() {
		return score;
	}

	public void roll() {
		this.score += dice.getLastRoll();
		if (dice.hasSkunk())
		{
			this.score = 0;
		}
		dice.roll();
	}
}
