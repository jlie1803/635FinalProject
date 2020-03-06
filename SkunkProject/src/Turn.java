
public class Turn {

	private Dice dice;
	private int score;
	
	public Turn() {
		dice = new Dice();
		score = 0;
	}
	
	public Turn(Dice dice) {
		this.dice = dice;
	}

	public int getScore() {
		return score;
	}

	public void roll() {
		dice.roll();
		this.score += dice.getLastRoll();		
	}
}
