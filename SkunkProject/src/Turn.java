import java.util.ArrayList;
import java.util.List;

public class Turn {

	private Dice dice;
	private int score;
	private int penalty;
	private boolean skunked;
	private String skunkType;
	private List<DiceResult> rollHistory;
	private int kitty;

	public Turn() {
		this.dice = new Dice();
		this.score = 0;
		this.skunked = false;
		this.rollHistory = new ArrayList<DiceResult>();
	}
	
	public Turn(Dice dice) {
		this.dice = dice;
		this.score = 0;
		this.skunked = false;
		this.rollHistory = new ArrayList<DiceResult>();
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
		this.rollHistory.add(new DiceResult(this.dice));
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
		kitty+=this.penalty;
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
		String result = dice.toString();
		if (this.hasSkunk()) {
			result += "\nYou rolled a " + this.getTypeofSkunk();
			result += "\nPlease pay the kitty " + this.getPenalty() + " chip(s).";
		}

		return result;
	}

	public String getTurnSummary() {
		String result = "In this turn you rolled the following rolls:\n";
		for (int i=0; i<this.rollHistory.size(); i++) {
			result += this.rollHistory.get(i);
			if (i != this.rollHistory.size() - 1) {
				result += ", ";
			}
		}
		result += "\nYou lost " + this.penalty + " chip(s).\n";
		result += "\nYou scored " + this.score + " point(s).\n";
		return result;
	}
}
