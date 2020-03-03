import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockDie extends Die {

	private int[] expectedRoll;
	private int rollIndex;
	
	public MockDie(int i) {
		this.expectedRoll = new int[] {i};
		this.rollIndex = 0;
		this.roll();
	}
	
	public MockDie(int[] rolls) {
		this.rollIndex = 0;
		this.expectedRoll = rolls;
		this.roll();
	}

	@Override
	public void roll() {
		this.lastRoll = this.expectedRoll[this.rollIndex];
		this.rollIndex = (this.rollIndex + 1) % this.expectedRoll.length;
	}	

}
