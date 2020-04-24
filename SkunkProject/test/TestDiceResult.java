import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestDiceResult {
	
	@Test
	void DiceResult_instantiates_successfully() {

		Die d1 = new MockDie(new int[] {1});
		Die d2 = new MockDie(new int[] {2});
		Dice dice = new Dice(d1, d2);
		
		String ExpectedResult = "{1,2}";

		DiceResult result = new DiceResult(dice);

		assertEquals(ExpectedResult, result.toString());
	}

}
