import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void turn_returns_score_of_zero_when_a_one_is_rolled() {
		Die mockDie1 = new MockDie(new int[] {5, 3, 1});
		Die mockDie2 = new MockDie(new int[] {4, 2, 9});
		assertEquals(5, mockDie1.getLastRoll());
		assertEquals(4, mockDie2.getLastRoll());
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		assertEquals(9, turn.getScore());
		turn.roll();
		assertEquals(14, turn.getScore());
		turn.roll();
		assertEquals(0, turn.getScore());
	}
	
	@Test
	void when_a_one_is_rolled_subsequent_rolls_do_not_affect_the_score() {
		Die mockDie1 = new MockDie(new int[] {5, 3, 1, 5});
		Die mockDie2 = new MockDie(new int[] {4, 2, 9, 6});
		assertEquals(5, mockDie1.getLastRoll());
		assertEquals(4, mockDie2.getLastRoll());
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		assertEquals(9, turn.getScore());
		turn.roll();
		assertEquals(14, turn.getScore());
		turn.roll();
		assertEquals(0, turn.getScore());
		turn.roll();
		assertEquals(0, turn.getScore());
	}
	
	@Test
	void turn_returns_a_non_zero_score_when_a_one_is_not_rolled() {
		Die mockDie1 = new MockDie(new int[] {5, 3, 7});
		Die mockDie2 = new MockDie(new int[] {4, 2, 9});
		assertEquals(5, mockDie1.getLastRoll());
		assertEquals(4, mockDie2.getLastRoll());
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		assertEquals(9, turn.getScore());
		turn.roll();
		assertEquals(14, turn.getScore());
		turn.roll();
		assertEquals(30, turn.getScore());
	}
}
