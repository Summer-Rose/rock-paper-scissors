import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class RockPaperScissors {
  public static String computerChoice;

  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");


    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/letsplay", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String choice = request.queryParams("playerChoice");

      if ( choice.equals("twoplayers") ) {
        model.put("template", "templates/twoplayer.vtl");
      } else {
        model.put("template", "templates/computer.vtl");
        model.put("playerChoice", choice);
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      if (computerChoice == null) {
        String playerOneChoice = request.queryParams("playerOneChoice");
        String playerTwoChoice = request.queryParams("playerTwoChoice");
        String winner = isWinner(playerOneChoice, playerTwoChoice);

        model.put("playerOneChoice", playerOneChoice);
        model.put("playerTwoChoice", playerTwoChoice);
        model.put("winner", winner);
      } else {
        String result = request.queryParams("playerChoice");
        String winner = isWinnerComputer(result);

        model.put("result", result);
        model.put("computerChoice", computerChoice);
        model.put("winner", winner);
      }

      // String result = request.queryParams("playerChoice");
      // String winner = isWinnerComputer(result);


      // model.put("result", result);
      // model.put("computerChoice", computerChoice);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

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
    computerChoice = choice;
    System.out.println(choice);
    System.out.println(playerOne);

    if ((playerOne.equals("Rock") && choice.equals("Scissors")) || (playerOne.equals("Paper") && choice.equals("Rock")) || (playerOne.equals("Scissors") && choice.equals("Paper"))) {
      return "You are the winner!";
    } else if (playerOne.equals(choice)) {
      return "It's a tie.";
    } else {
      return "The computer wins. You lose!";
    }
  }
}
