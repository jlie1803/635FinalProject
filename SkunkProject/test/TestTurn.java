import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void turn_returns_score_of_zero_when_a_one_is_rolled() {
		Die mockDie1 = new MockDie(new int[] { 1, 5, 3, 1 });
		Die mockDie2 = new MockDie(new int[] { 1, 4, 2, 9 });
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();
		assertEquals(5, turn.getDie1());
		assertEquals(4, turn.getDie2());
		assertEquals(9, turn.getScore());
		turn.roll();
		assertEquals(14, turn.getScore());
		turn.roll();
		assertEquals(0, turn.getScore());
	}

	@Test
	void when_a_one_is_rolled_subsequent_rolls_do_not_affect_the_score() {
		Die mockDie1 = new MockDie(new int[] { 1, 5, 3, 1, 5 });
		Die mockDie2 = new MockDie(new int[] { 1, 4, 2, 9, 6 });
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();
		assertEquals(5, turn.getDie1());
		assertEquals(4, turn.getDie2());
		assertEquals(9, turn.getScore());
		turn.roll();
		assertEquals(14, turn.getScore());
		assertEquals("", turn.getTypeofSkunk());
		
		turn.roll();
		assertEquals(0, turn.getScore());
		turn.roll();
		assertEquals(0, turn.getScore());
	}

	@Test
	void turn_returns_a_non_zero_score_when_a_one_is_not_rolled() {
		Die mockDie1 = new MockDie(new int[] { 1, 5, 3, 7 });
		Die mockDie2 = new MockDie(new int[] { 1, 4, 2, 9 });
		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();
		assertEquals(5, turn.getDie1());
		assertEquals(4, turn.getDie2());
		assertEquals(9, turn.getScore());
		turn.roll();
		assertEquals(14, turn.getScore());
		turn.roll();
		assertEquals(30, turn.getScore());
	}

	@Test
	void getTypeofSkunk_returns_the_expected_result() {
		Die mockDie1 = mock(MockDie.class);
		Die mockDie2 = mock(MockDie.class);

		when(mockDie1.getLastRoll()).thenReturn(1);
		when(mockDie2.getLastRoll()).thenReturn(1);

		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();

		String result = turn.getTypeofSkunk();

		assertEquals("Two Skunk!", result);
	}

	@Test
	void turn_instantiates_successfully() {
		int expectedScore = 0;
		boolean expectedSkunked = false;

		Turn turn = new Turn();

		assertEquals(expectedScore, turn.getScore());
		assertEquals(expectedSkunked, turn.hasSkunk());
	}

	@Test
	void getRollString_returns_the_expected_result() {
		Die mockDie1 = mock(MockDie.class);
		Die mockDie2 = mock(MockDie.class);

		when(mockDie1.getLastRoll()).thenReturn(1);
		when(mockDie2.getLastRoll()).thenReturn(1);

		String expectedResult = "Value of each thrown die: 2 => 1 + 1\n" + "You rolled a Two Skunk!\n"
				+ "Please pay the kitty 4 chip(s).";

		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();

		String result = turn.getRollString();

		assertEquals(expectedResult, result);
	}

	@Test
	void getTurnSummary_returns_the_expected_result() {
		Die mockDie1 = mock(MockDie.class);
		Die mockDie2 = mock(MockDie.class);

		when(mockDie1.getLastRoll()).thenReturn(1);
		when(mockDie2.getLastRoll()).thenReturn(1);

		String expectedResult = "In this turn you rolled the following rolls:\n" + "{1,1}\n" + "You lost 4 chip(s).\n\n"
				+ "You scored 0 point(s).\n";

		Turn turn = new Turn(new Dice(mockDie1, mockDie2));
		turn.roll();

		String result = turn.getTurnSummary();

		assertEquals(expectedResult, result);
	}
	
	@Test
	void skunkdeuce_has_penalty_of_two() {
		Die d1 = new MockDie(new int[] {5,5,1});
		Die d2 = new MockDie(new int[] {5,5,2});
		Dice dice = new Dice(d1, d2);
		
		Turn turn = new Turn (dice);
		turn.roll();
		turn.roll();
		
		assertEquals("Skunk Deuce!", turn.getTypeofSkunk());
		assertEquals(2, turn.getPenalty());
		assertEquals(2, turn.getKitty());
		
		String expectedResult = "In this turn you rolled the following rolls:\n" 
		                      + "{5,5}, {1,2}\n" 
				              + "You lost 2 chip(s).\n\n"
		                      + "You scored 0 point(s).\n";
		assertEquals(expectedResult, turn.getTurnSummary());
	}
}
