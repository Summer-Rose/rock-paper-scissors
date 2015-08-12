import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorsTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  goTo("http://localhost:4567/");
  assertThat(pageSource()).contains("Let's Play Rock Paper Scissors!");
  }

  @Test
  public void selectComputer() {
    goTo("http://localhost:4567/");
    fillSelect("#playerChoice").withValue("computer");
    //browser.$("#playerChoice").
    submit(".btn");
    assertThat(pageSource()).contains("Human vs. Computer");
  }

  @Test
  public void selectRockVsComputer() {
    goTo("http://localhost:4567/letsplay?playerChoice=computer");
    fillSelect("#playerChoice").withValue("Rock");
    submit(".btn");
    assertThat(pageSource()).contains("Rock Paper Scissors Results");
  }

  @Test
  public void selectRockVsPaper() {
    goTo("http://localhost:4567/letsplay?playerChoice=twoplayers");
    fillSelect("#playerOneChoice").withValue("Rock");
    fillSelect("#playerTwoChoice").withValue("Paper");
    submit(".btn");
    assertThat(pageSource()).contains("Player Two Wins");
  }
}
