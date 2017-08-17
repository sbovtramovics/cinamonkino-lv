package stepDefinitions;

import java.security.SecureRandom;
import java.util.Random;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Driver;

import javax.swing.*;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class MyStepDefinitions {
    private Driver driver;
    public MyStepDefinitions(Driver driver) {
        this.driver = driver;
    }
    Calendar cal0 = Calendar.getInstance();
    Date date0 = cal0.getTime();
    SimpleDateFormat ft0 = new SimpleDateFormat("YYYY-MM-dd");
    String randomDate=ft0.format(date0);
    int randomFilm = 1;
    int randomTime=1;
    String StoredSum;
    String SeatData;

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

    @And("^I select the film from the list$")
    public void iClickToTheFilmList() throws Throwable {
        Select select = new Select(driver.findElement(By.cssSelector("#quick-booking__film")));
        select.getAllSelectedOptions();
        List<WebElement> l = select.getOptions();
        Random rand = new Random();
        int max = l.size()-1;
        int min = 1;
        randomFilm = rand.nextInt((max - min) + 1) + min;
        select.selectByIndex(randomFilm);
        Thread.sleep(2000);

    }

    @And("^I choose the time from the list$")
    public void iChooseTheTimeFromTheList() throws Throwable {
        Select select = new Select(driver.findElement(By.cssSelector("#quick-booking__session")));
        List<WebElement> l = select.getOptions();
        Random rand = new Random();
        int max = l.size()-1;
        int min = 2;
        int randomTimeIndex= rand.nextInt((max - min) + 1) + min;
        while (select.getOptions().get(randomTimeIndex).getAttribute("disabled")!=null)
        {
            randomTimeIndex++;
        }
        select.selectByIndex(randomTimeIndex);
    }

    @And("^I press booking button$")
    public void iPressBookingButton() throws Throwable {
        WebElement Button = driver.findElement(By.cssSelector("#quick-booking__action"));
        Button.click(); // clicking on button
        Thread.sleep(1000);
    }

    @And("^I add (\\d+) tickets$")
    public void iAddTickets(int clicks) throws Throwable {
        WebElement Button = driver.findElement(By.cssSelector("input.qty-btn.qtyplus"));
        for (int i = 0; i < clicks; i++){
            Button.click(); // clicking on button
        }
    }

    @And("^I store the sum$")
    public void iStoreTheSum() throws Throwable {
        WebElement StoredSumText = driver.findElement(By.cssSelector("td.total"));
        StoredSum=StoredSumText.getText();
    }

    @And("^I type random text in coupon field$")
    public void iTypeRandomTextInCouponField() throws Throwable {
        Random rng = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int max = 11;
        int min = 2;
        int length= rng.nextInt((max - min) + 1) + min;
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        WebElement  couponField = driver.findElement(By.cssSelector("input[placeholder='Pievienot kupona kodu']"));
        assertEquals(couponField.getText(), ""); // checking that firstNameText is empty
        couponField.sendKeys(String.valueOf(new String(text)));
    }

    @And("^I press validate button$")
    public void iPressValidateButton() throws Throwable {
        WebElement Button = driver.findElement(By.cssSelector("button.small.secondary.validate"));//#next-step
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(1000);
        Button.click(); // clicking on button
        Thread.sleep(1000);
    }

    @And("^I check that validation works$")
    public void iCheckThatValidationWorks() throws Throwable {
        WebElement ValidationError = driver.findElement(By.cssSelector("small.error"));
    }

    @And("^I press Next$")
    public void iPressNext() throws Throwable {
        WebElement buttonNext= driver.findElement(By.cssSelector("#next-step"));
        buttonNext.click(); // clicking on button
    }

    @And("^I check two random at the last row$")
    public void iCheckTwoRandomAtTheLastRow() throws Throwable {
        WebElement seat1 = driver.findElement(By.cssSelector(".empty.normal"));
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(1000);
        seat1.click();
        WebElement seat2 = driver.findElement(By.cssSelector(".empty.normal"));
        seat2.click();
    }

    @And("^I store the seat numbers$")
    public void iStoreTheSeatNumbers() throws Throwable {
        WebElement seatDataText = driver.findElement(By.cssSelector("div.medium-6.columns.picked-summary li"));
        SeatData=seatDataText.getText();
        System.out.println("STOP!");
        /*List<WebElement> l= driver.findElements(By.cssSelector(".reserved.normal"));
        int length= l.size();
        int[] seatNumbers = new int[length];
        for (int i = 0; i < length; i++)
        {
            //seatNumbers[i] =
            System.out.println(l.get(i).getAttribute("id"));
        }
        */
    }

    @And("^I press Next again$")
    public void iPressNextAgain() throws Throwable {
        WebElement submitButton = driver.findElement(By.cssSelector("input.button.big-submit"));
        submitButton.click();
        System.out.println("STOP");
    }

    @And("^I check stored sum$")
    public void iCheckStoredSum() throws Throwable {
        WebElement storedSumText = driver.findElement(By.cssSelector("td.total"));
        assertEquals(storedSumText.getText(), StoredSum);
    }

    @And("^I check stored seats$")
    public void iCheckStoredSeats() throws Throwable {
        WebElement seatDataText = driver.findElement(By.cssSelector("tbody > tr:nth-child(5) > td"));
        assertEquals(seatDataText.getText(), SeatData);
    }

}
//System.out.println("STOP!");
//System.out.println("STOP!");
//Thread.sleep(5000);
//System.out.println("STOP!");
//scrollToElement.button;
//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", Button);
//Thread.sleep(5000);
//Actions actions = new Actions(driver);
//actions.moveToElement(Button);
//actions.perform();
//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", Button);
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("javascript:window.scrollBy(250,350)");
//JavascriptExecutor jse = (JavascriptExecutor)driver;
//jse.executeScript("scroll(0, 250);");

//#ticket_form > table > tbody > tr.voucher > td.barcode > input[type="text"]
//System.out.println(new String(text));
//System.out.println("STOP!");
//System.out.println("STOP!");
//select.getAllSelectedOptions();
//String value = select.getOptions().get(1).getAttribute("value");
//System.out.println(value);
//boolean parametr = select.getOptions().get(1).getAttribute("disabled");
//System.out.println(l.size());
//
//System.out.println(l.size());
//WebElement filmsList = driver.findElement(By.cssSelector("#quick-booking__film"));
//filmsList.click(); // clicking on button
//System.out.print("STOP!");
//System.out.print("STOP!");
//assertEquals(headerText.getText(), header);

        /*int lenght = 20;
        int[] randomNum = new int[lenght];
        for(int x = 0; x < 20; x++) {
        randomNum[x] = rand.nextInt((max - min) + 1) + min;
            System.out.println(randomNum[x]+";");
        }*/
//WebElement film = driver.findElement(By.cssSelector("a[href='#tab"+ ft.format(date) +"']"));

//dateButton.click(); // clicking on button
//System.out.print(randomNum);

//Select select = new Select(driver.findElement(By.cssSelector("section#acc2017-08-18")));
//List<WebElement> listOptions = select.getOptions();
//listOptions.size();

//System.out.print(listOptions.size());
//System.out.println("STOP!");
//select.getOptions().get(2).getAttribute("disabled")
//System.out.println("While message!!!");
//int randomTimeIndex=0;
//System.out.print(select.getOptions().get(randomTimeIndex).getAttribute("value"));
        /*Select select = new Select(driver.findElement(By.cssSelector("#quick-booking__session")));
        List<WebElement> l = select.getOptions();
        Random rand = new Random();
        int max = 13;
        int min = 0;
        int randomSeatNumber= rand.nextInt((max - min) + 1) + min;
        while (select.getOptions().get(randomSeatNumber).getAttribute("disabled")!=null)
        {
            randomSeatNumber++;
        }
        select.selectByIndex(randomSeatNumber);*/