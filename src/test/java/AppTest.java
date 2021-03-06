import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver(){
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource().contains("Join"));
  }

  void FemaleMakeProfile() {
    goTo("http://localhost:4567/");
    click("a", withText("Are you a queen?"));
    assertThat(pageSource().contains("Add your whiskers"));
    fill("#name").with("Sue");
    fill("#fixedstatus").with("Yes");
    fill("#city").with("PDX");
    fill("#breed").with("Calico");
    find("#false").click();
    submit("#submit");
    assertThat(pageSource()).contains("Sue");
  }

  void MaleMakeProfile() {
    goTo("http://localhost:4567/");
    click("a", withText("Are you a tom?"));
    assertThat(pageSource().contains("Add your whiskers"));
    fill("#name").with("Bob");
    fill("#fixedstatus").with("Yes");
    fill("#city").with("PDX");
    fill("#breed").with("Calico");
    find("#false").click();
    submit("#submit");
    assertThat(pageSource()).contains("Bob");
  }

}
