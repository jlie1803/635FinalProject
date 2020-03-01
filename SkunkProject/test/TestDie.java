
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;


public class TestDie
{
	static int rolls = 10000;
	static int min_threshold_divisor = 7;
	static int max_threshold_divisor = 5;

	@Test
	public void die_roll_is_always_greater_than_zero_and_less_than_seven()
	{
		Die die = new Die();
		for (int i = 0; i < rolls; i++) {
			die.roll();
			assertTrue(die.getLastRoll() > 0, "Last die roll was <= 0");
			assertTrue(die.getLastRoll() < 7, "Last die roll was >= 7");
		}
	}

	@Test
	public void when_the_die_is_rolled_it_is_reasonably_random()
	{
		Die die = new Die();
		int one_count = 0;
		int two_count = 0;
		int three_count = 0;
		int four_count = 0;
		int five_count = 0;
		int six_count = 0;
		
		for (int i = 0; i < rolls; i++) {
			die.roll();
			switch (die.getLastRoll()) {
			case 1:
				one_count += 1;
				break;
			case 2:
				two_count += 1;
				break;
			case 3:
				three_count += 1;
				break;
			case 4:
				four_count += 1;
				break;
			case 5:
				five_count += 1;
				break;
			case 6:
				six_count += 1;
				break;
			}
		}
		
		assertTrue(one_count >= rolls/min_threshold_divisor, "One was less than the expected rolls.");
		assertTrue(one_count <= rolls/max_threshold_divisor, "One was greater than the expected rolls.");
		assertTrue(two_count >= rolls/min_threshold_divisor, "Two was less than the expected rolls.");
		assertTrue(two_count <= rolls/max_threshold_divisor, "Two was greater than the expected rolls.");
		assertTrue(three_count >= rolls/min_threshold_divisor, "Three was less than the expected rolls.");
		assertTrue(three_count <= rolls/max_threshold_divisor, "Three was greater than the expected rolls.");
		assertTrue(four_count >= rolls/min_threshold_divisor, "Four was less than the expected rolls.");
		assertTrue(four_count <= rolls/max_threshold_divisor, "Four was greater than the expected rolls.");
		assertTrue(five_count >= rolls/min_threshold_divisor, "Five was less than the expected rolls.");
		assertTrue(five_count <= rolls/max_threshold_divisor, "Five was greater than the expected rolls.");
		assertTrue(six_count >= rolls/min_threshold_divisor, "Six was less than the expected rolls.");
		assertTrue(six_count <= rolls/max_threshold_divisor, "Six was greater than the expected rolls.");
	}
	
	@Test
	public void die_returns_expected_value_when_replaced_with_mock_die() {
		for (int i = 0; i < rolls; i++)
		{
			Die die = new MockDie(1);
			die.roll();
			assertEquals(1, die.getLastRoll());
			assertEquals("Die: " + 1, die.toString());
		}
	}
}
