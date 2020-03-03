import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockDie extends Die {

	private int expectedRoll;
	
	public MockDie(int i) {
		super();
		this.expectedRoll = i;
	}
	
	@Override
	public void roll() {
		this.lastRoll = this.expectedRoll;
	}	

}
