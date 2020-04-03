
public class Turn {

	private Dice dice;
	private int score;
	private int penalty;
	private boolean skunked;
	private String skunkType;
	
	public Turn() {
		this.dice = new Dice();
		this.score = 0;
		this.skunked = false;
	}
	
	public Turn(Dice dice) {
		this.dice = dice;
		this.score = 0;
		this.skunked = false;
	}

	public int getScore() {
		return score;
	}

	public int getPenalty() {
		return penalty;
	}

	public String getTypeofSkunk() {
		return skunkType;
	}

	public void roll() {
		// if skunked in prior roll, do nothing.
		if (this.skunked) return;

		this.dice.roll();
		if (this.dice.hasSkunk())
		{
			this.skunkType = this.dice.getTypeofSkunk();
			this.score = 0;
			this.skunked = true;
		}
		else {
			this.score += this.dice.getLastRoll();
			this.skunked = false;
			this.skunkType = "";
		}

		if (this.dice.oneSkunk()) {
			this.penalty = 1;
		}
		else if (this.dice.twoSkunk()){
			this.penalty = 4;
		}
		else if (this.dice.skunkDeuce()) {
			this.penalty = 2;
		}
		else {
			this.penalty = 0;
		}
	}

	public boolean hasSkunk() {
		return skunked;
	}

	public int getDie1() {
		return dice.getDie1();
	}

	public int getDie2() {
		return dice.getDie2();
	}

	public String getRollString() {
		return dice.toString();
	}
}
