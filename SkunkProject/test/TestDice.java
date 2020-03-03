import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDice {

	static int rolls = 10000;

	@Test
	public void dice_roll_is_always_greater_than_two_and_less_than_thirteen()
	{
		Dice dice = new Dice();
		for (int i = 0; i < rolls; i++) {
			dice.roll();
			assertTrue(dice.getLastRoll() > 1, "Last dice roll was <= 2");
			assertTrue(dice.getLastRoll() < 13, "Last dice roll was >= 13");
		}
	}

	@Test
	public void when_the_dice_are_rolled_it_is_reasonably_random()
	{
		Dice dice = new Dice();
		int two_count = 0;
		int three_count = 0;
		int four_count = 0;
		int five_count = 0;
		int six_count = 0;
		int seven_count = 0;
		int eight_count = 0;
		int nine_count = 0;
		int ten_count = 0;
		int eleven_count = 0;
		int twelve_count = 0;
		
		for (int i = 0; i < rolls; i++) {
			dice.roll();
			switch (dice.getLastRoll()) {
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
			case 7:
				seven_count += 1;
				break;
			case 8:
				eight_count += 1;
				break;
			case 9:
				nine_count += 1;
				break;
			case 10:
				ten_count += 1;
				break;
			case 11:
				eleven_count += 1;
				break;
			case 12:
				twelve_count += 1;
				break;
			}
		}
		
		assertTrue(two_count >= 0, "Two was less than the expected rolls.");
		assertTrue(two_count <= rolls/36*2, "Two was greater than the expected rolls.");
		assertTrue(three_count >= rolls/36, "Three was less than the expected rolls.");
		assertTrue(three_count <= rolls/36*3, "Three was greater than the expected rolls.");
		assertTrue(four_count >= rolls/36*2, "Four was less than the expected rolls.");
		assertTrue(four_count <= rolls/36*4, "Four was greater than the expected rolls.");
		assertTrue(five_count >= rolls/36*3, "Five was less than the expected rolls.");
		assertTrue(five_count <= rolls/36*5, "Five was greater than the expected rolls.");
		assertTrue(six_count >= rolls/36*4, "Six was less than the expected rolls.");
		assertTrue(six_count <= rolls/36*6, "Six was greater than the expected rolls.");
		assertTrue(seven_count >= rolls/36*5, "Seven was less than the expected rolls.");
		assertTrue(seven_count <= rolls/36*7, "Seven was greater than the expected rolls.");
		assertTrue(eight_count >= rolls/36*4, "Eight was less than the expected rolls.");
		assertTrue(eight_count <= rolls/36*6, "Eight was greater than the expected rolls.");
		assertTrue(nine_count >= rolls/36*3, "Nine was less than the expected rolls.");
		assertTrue(nine_count <= rolls/36*5, "Nine was greater than the expected rolls.");
		assertTrue(ten_count >= rolls/36*2, "Ten was less than the expected rolls.");
		assertTrue(ten_count <= rolls/36*4, "Ten was greater than the expected rolls.");
		assertTrue(eleven_count >= rolls/36, "Eleven was less than the expected rolls.");
		assertTrue(eleven_count <= rolls/36*3, "Eleven was greater than the expected rolls.");
		assertTrue(twelve_count >= 0, "Twelve was less than the expected rolls.");
		assertTrue(twelve_count <= rolls/36*2, "Twelve was greater than the expected rolls.");
	}
	
	@Test
	public void when_initialized_with_two_mocked_dice_expected_roll_is_returned()
	{
		for (int i=1; i<=6; i++)
		{
			for (int j=1; j<=6; j++)
			{
				Die mockDie1 = new MockDie(i);
				Die mockDie2 = new MockDie(j);
			    Dice mockDice = new Dice(mockDie1, mockDie2);		
				mockDice.roll();
				assertEquals(i+j, mockDice.getLastRoll());
			}
		}			
	}
}
