package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Driver;

public class TestStepDefinitions {
    private Driver driver;
    public TestStepDefinitions(Driver driver) {
        this.driver = driver;
    }

    @Given("^Page is opened$")
    public void pageIsOpened() throws Throwable {
        driver.get("https://cinamonkino.lv/filmas/#fndtn-tab2017-08-17");
    }

    @And("^I do a click$")
    public void iDoAClick() throws Throwable {
        WebElement Button = driver.findElement(By.cssSelector("a[href='https://cinamonkino.lv/biletes/?sessionId=30474']"));
        //Thread.sleep(5000);
        Button.click(); // clicking on button
        //System.out.print("STOP!");
    }
}
