import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestDiceResult {
	
	@Test
	void DiceResult_instantiates_successfully() {

		String ExpectedResult = "{1,2}";

		DiceResult result = new DiceResult(1,2);

		assertEquals(ExpectedResult, result.toString());
	}

}
