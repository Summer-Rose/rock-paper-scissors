import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class RockPaperScissors {
  public static void main(String[] args) {

  }

  public static String isWinner( String playerOne, String playerTwo ) {
    if((playerOne == "Rock" && playerTwo == "Scissors") || (playerOne == "Paper" && playerTwo == "Rock") || (playerOne == "Scissors" && playerTwo == "Paper")) {
      return "Player One Wins";
    } else if (playerOne == playerTwo) {
      return "Tie";
    } else {
      return "Player Two Wins";
    }
  }

  public static String isWinnerComputer(String playerOne) {
    Random computerRandom = new Random();
    Integer computer = computerRandom.nextInt(3);

    //0 = Rock
    //1 = Paper
    //2 = Scissors

    Map<Integer, String> computerChoices = new HashMap<>();
    computerChoices.put(0, "Rock");
    computerChoices.put(1, "Paper");
    computerChoices.put(2, "Scissors");

    String choice = computerChoices.get(computer);


    if ((playerOne == "Rock" && choice == "Scissors" ) || (playerOne == "Paper" && choice == "Rock") || (playerOne == "Scissors" && choice == "Paper")) {
      return "Player One Wins";
    } else if (playerOne == choice) {
      return "Tie";
    } else {
      return "Computer Wins";
    }
  }
}
