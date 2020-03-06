import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void turn_returns_score_of_zero_when_a_one_is_rolled() {
		Die mockDie1 = new MockDie(new int[] {5, 3, 1});
		Die mockDie2 = new MockDie(new int[] {4, 2, 9});
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();
		turn.roll();
		turn.roll();
		assertEquals(0, turn.getScore());
	}
	
	@Test
	void turn_returns_a_non_zero_score_when_a_one_is_not_rolled() {
		Die mockDie1 = new MockDie(new int[] {5, 3, 7});
		Die mockDie2 = new MockDie(new int[] {4, 2, 9});
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();
		turn.roll();
		turn.roll();
		assertEquals(30, turn.getScore());
	}
}
