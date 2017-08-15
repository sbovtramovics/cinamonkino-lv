package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Driver;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MyStepDefinitions {
    private Driver driver;
    public MyStepDefinitions(Driver driver) {
        this.driver = driver;
    }

    @Given("^I go to the main page: \"([^\"]*)\"$")
    public void iGoToTheMainPage(String page) throws Throwable {
        driver.get(page);
    }


    @When("^I sign in$")
    public void iSignIn() throws Throwable {
            WebElement loginButton = driver.findElement(By.className("username"));
            loginButton.click(); // clicking on button
    }


    @And("^I enter the email: \"([^\"]*)\"$")
    public void iEnterTheEmail(String email) throws Throwable {
        WebElement emailField = driver.findElement(By.cssSelector("input[name='username']")); //input[@name="username"] input[name='username']
        emailField.sendKeys(String.valueOf(email));
    }

    @And("^I enter the password: \"([^\"]*)\"$")
    public void iEnterThePassword(String password) throws Throwable {
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
        passwordField.sendKeys(String.valueOf(password));
    }

    @And("^I press submit button$")
    public void iPressSubmitButton() throws Throwable {
        WebElement Button = driver.findElement(By.xpath("//button[contains(text(), 'Pieteikties')]"));
        Button.click(); // clicking on button
    }

    @And("^I check that the Name is \"([^\"]*)\"$")
    public void iCheckThatTheNameIs(String name) throws Throwable {
        driver.waitForElementPresent(By.cssSelector("input[name='firstname']"));
        String nameField = driver.findElement(By.cssSelector("input[name='firstname']")).getAttribute("value") ;
        assertEquals(nameField, name);
    }

    @And("^I check the the Surname is \"([^\"]*)\"$")
    public void iCheckTheTheSurnameIs(String surname) throws Throwable {
        driver.waitForElementPresent(By.cssSelector("input[name='lastname']"));
        String surnameField = driver.findElement(By.cssSelector("input[name='lastname']")).getAttribute("value") ;
        assertEquals(surnameField, surname);
    }

    @And("^I press the Save button$")
    public void iPressTheSaveButton() throws Throwable {
        WebElement Button = driver.findElement(By.xpath("//button[contains(text(), 'Saglabāt izmaiņas')]"));
        //Thread.sleep(5000);
        Button.click(); // clicking on button
        //System.out.print("STOP!");
    }

    @And("^I go to the Films tab$")
    public void iGoToTheFilmsTab() throws Throwable {
        WebElement filmsButton = driver.findElement(By.cssSelector("#menu-item-10876 > a"));
        filmsButton.click(); // clicking on button
    }

    @And("^I select the random date (\\d+) days from current date$")
    public void iSelectTheRandomDateDaysFromCurrentDate(int arg0) throws Throwable {
        WebElement dateButton = driver.findElement(By.cssSelector("a[href='#tab2017-08-18']"));
        dateButton.click(); // clicking on button
        System.out.print("STOP!");
    }

    @Given("^Todays date$")
    public void todaysDate() throws Throwable {
        //Date date = new Date(); // date object
        //System.out.println(date); // Try to print the date object

        //Calendar cal = Calendar.getInstance(); // creates calendar
        //cal.setTime(new Date()); // sets calendar time/date
       // cal.add(Calendar.DAY_OF_MONTH, 3); // adds one hour
       // cal.getTime(); // returns new date object, one hour in the future
        ///System.out.println(cal.getTime(YYYYMMDD));


        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 3);
        Date date = cal.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(ft.format(date));
        //JOptionPane.showMessageDialog(null, ft.format(date));
    }
}
//System.out.print("STOP!");
//assertEquals(headerText.getText(), header);