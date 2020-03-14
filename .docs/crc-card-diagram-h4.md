# CRC Card Diagram

## Team Members

- Esten Rye
- Jie Li
- Fadi Bchara

---

```mermaid
stateDiagram
  state Game {
    state Responsibilities {
      return_game_scores_to_presentation_layer
      manage_state_of_active_game
      manage_player_turn_order
      determine_when_endgame_condition_is_met
      pay_kitty_to_winning_player
      determine_who_the_winner_or_winners_are
    }
    state Collaborators {
      state Player{
        get_scores
        set_scores
        get_chips
      }
      state Turn {
        get_turn_state
        get_turn_score
        get_turn_penalty
        get_last_roll
      }
      state Kitty {
        get_chip_count
      }
    }
  }
```