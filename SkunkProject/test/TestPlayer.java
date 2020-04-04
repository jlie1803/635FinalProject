import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestPlayer {
	
	@Test
	public void test_player_name()
	{
		Player player = new Player();
		player.setPlayerName("jie");
		assertEquals("jie", player.getPlayerName());
	}
	
	
	  @Test 
	  public void test_player_chips() 
	  { 
		  Player player = new Player();
		  assertEquals(50, player.getChips());
	  }
	  
	  @Test 
	  public void test_player_round_score() 
	  { 
		  Player player = new Player();
		  player.setRoundScore(10);
		  player.addTurnScore(10);
		  assertEquals(20, player.getRoundScore());
	  }
	
	  @Test 
	  public void test_player_turn_score() 
	  { 
		  Player player = new Player();
		  assertEquals(0, player.getTurnScore()); 
	  }
	 
	  
	  @Test 
	  public void test_player_penalty() 
	  { 
		  Player player = new Player();
		  player.addTurnPenalty(10);
		  assertEquals(40, player.getChips());
	  }
	  
	  @Test 
	  public void test_player_toString() 
	  { 
		  Player player = new Player("jie");
		  assertEquals("Player jie has a Turn score of 0, Round score of 0, and 50 chips.\n", player.toString());
	  }
	 
	

}
