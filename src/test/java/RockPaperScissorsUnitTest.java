import org.junit.*;
import static org.junit.Assert.*;

public class RockPaperScissorsUnitTest {

  @Test
  public void checkWinner_rockBeatsScissors_true() {
    RockPaperScissors testResult = new RockPaperScissors();
    assertEquals("Player One Wins", testResult.isWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_paperBeatsRock_true() {
    RockPaperScissors testResult = new RockPaperScissors();
    assertEquals("Player One Wins", testResult.isWinner("Paper", "Rock"));
  }

  @Test
  public void checkWinner_scissorsBeatsPaper_true() {
    RockPaperScissors testResult = new RockPaperScissors();
    assertEquals("Player One Wins", testResult.isWinner("Scissors", "Paper"));
  }

  @Test
  public void checkWinner_playersTie_true() {
    RockPaperScissors testResult = new RockPaperScissors();
    assertEquals("Tie", testResult.isWinner("Scissors", "Scissors"));
  }

  @Test
  public void checkWinner_playerTwoWins_true() {
    RockPaperScissors testResult = new RockPaperScissors();
    assertEquals("Player Two Wins", testResult.isWinner("Paper", "Scissors"));
  }

  //Test only passes when random number returns rock
  // @Test
  // public void checkWinner_playerOneBeatsComputer_true() {
  //   RockPaperScissors testResult = new RockPaperScissors();
  //   assertEquals("Player One Wins", testResult.isWinnerComputer("Paper"));
  // }

}
