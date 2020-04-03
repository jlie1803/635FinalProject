import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController {

	@Test
	public void test_state_is_InitializeGame_after_controller_is_instantiated() {
		Controller controller = new Controller();
		assertEquals("InitializeGame", controller.getState());
	}

	@Test
	public void test_state_transitions_to_AddPlayers_after_number_of_players_is_supplied() {
		Controller controller = new Controller();
		controller.setNumberOfPlayers(2);
		assertEquals(2, controller.getNumberOfPlayers());
		assertEquals("AddPlayers", controller.getState());
	}

	@Test
	public void test_state_transitions_from_AddPlayers_to_ActiveGame_when_all_players_added() {
		Controller controller = new Controller();
		controller.setNumberOfPlayers(2);
		assertEquals("AddPlayers", controller.getState());
		assertEquals(0, controller.getPlayerCount());
		controller.addPlayer("jie");
		assertEquals("AddPlayers", controller.getState());
		assertEquals(1, controller.getPlayerCount());
		controller.addPlayer("esten");
		assertEquals("ActiveGame", controller.getState());
		assertEquals(2, controller.getPlayerCount());
		String expectedScores = "Player Scores:\n";
		expectedScores += "----------------\n";
		expectedScores += "jie:  Score: 0,  Chips: 50\n";
		expectedScores += "esten:  Score: 0,  Chips: 50\n";
		String actualScores = controller.getRoundScoreBoard();
		assertEquals(expectedScores, actualScores);
	}

	@Test
	public void test_single_player_round_logic_triggers_endgame() {
		Die die1 = new MockDie(new int[]{6,6,6,6,6,6,6,6,6,6,6,6,6});
		Die die2 = new MockDie(new int[]{6,6,6,6,6,6,6,6,6,6,6,6,6});

		Controller controller = new Controller(die1, die2);
		controller.setNumberOfPlayers(1);
		controller.addPlayer("jie");
		assertEquals("ActiveGame", controller.getState());
		assertEquals("Invalid", controller.getActivePlayerName());

		controller.startRound();
		assertEquals("ActiveRound", controller.getState());
		controller.nextPlayer();
		assertEquals("ActiveTurn", controller.getState());
		assertEquals("jie", controller.getActivePlayerName());
		assertEquals(0, controller.getActivePlayerTurnScore());
		for (int i = 0; i < 6; i++)
		{
			controller.roll();
			assertEquals(12*(i+1), controller.getActivePlayerTurnScore());
		}
		controller.pass();
		

		assertEquals("ActiveRound", controller.getState());
		assertEquals("Invalid", controller.getActivePlayerName());

		controller.startRound();
		assertEquals("ActiveRound", controller.getState());
		controller.nextPlayer();
		assertEquals("ActiveTurn", controller.getState());
		assertEquals("jie", controller.getActivePlayerName());
		assertEquals(0, controller.getActivePlayerTurnScore());
		for (int i = 0; i < 3; i++)
		{
			controller.roll();
			assertEquals(12*(i+1), controller.getActivePlayerTurnScore());
		}
		controller.pass();
		assertEquals("EndGameRound", controller.getState());
		
		controller.nextPlayer();
		assertEquals("GameComplete", controller.getState());
	}
}
