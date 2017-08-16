package stepDefinitions;

import java.security.SecureRandom;
import java.util.Random;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Driver;

import javax.swing.*;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.List;
import org.openqa.selenium.support.ui.Select;


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
        Button.click(); // clicking on button
        //System.out.print("STOP!");
    }

    @And("^I go to the Films tab$")
    public void iGoToTheFilmsTab() throws Throwable {
        WebElement filmsButton = driver.findElement(By.cssSelector("#menu-item-10876 > a"));
        filmsButton.click(); // clicking on button
    }

    @And("^I select the random date using (\\d+) days interval from current date$")
    public void iSelectTheRandomDateDaysFromCurrentDate(int max) throws Throwable {
        int min = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, randomNum);
        Date date = cal.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
        randomDate=ft.format(date);
        WebElement dateButton = driver.findElement(By.cssSelector("a[href='#tab"+ ft.format(date) +"']"));
        dateButton.click(); // clicking on button
    }

    @Given("^Todays date$")
    public void todaysDate() throws Throwable {
        int max = 5;
        int min = 0;
        Random rand = new Random();
        /*int lenght = 10;
        int[] randomNum = new int[lenght];
        for(int x = 0; x < 10; x++) {
        randomNum[x] = rand.nextInt((max - min) + 1) + min;
            System.out.println(randomNum[x]+";");
        }*/
        int randomNum = rand.nextInt((max - min) + 1) + min;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, randomNum);
        Date date = cal.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(ft.format(date));
        //JOptionPane.showMessageDialog(null, ft.format(date));
    }

    @And("^I select the random film from the list$")
    public void iSelectTheRandomFilmFromTheList() throws Throwable {
        List<WebElement> forms = driver.findElements(By.cssSelector("section#acc"+ randomDate +" > div"));
        int max = forms.size();
        int min = 1;
        Random rand = new Random();
        randomFilm = rand.nextInt((max - min) + 1) + min;
    }

    @And("^I select the random time of the film$")
    public void iSelectTheRandomTimeOfTheFilm() throws Throwable {
        List<WebElement> times = driver.findElements(By.cssSelector("#acc"+ randomDate +" > div:nth-child("+ randomFilm +") div.session-item"));
        int max= times.size();
        int min = 1;
        Random randTime = new Random();
        int randomTime = randTime.nextInt((max - min) + 1) + min;
        //WebElement filmTimeButton = driver.findElement(By.cssSelector("#acc"+ randomDate + " > div:nth-child("+ randomFilm +") div.sessions-cell > div > div:nth-child("+randomTime+") > a "));
        WebElement filmTimeButton = driver.findElement(By.cssSelector("#acc2017-08-17 > div:nth-child(1) > div.small-10.columns.film-content.equal-height > div > div.sessions-cell > div > div:nth-child(1) > a"));
        filmTimeButton.click(); // clicking on button
        System.out.print("STOP! "+randomDate +" "+ randomFilm + " " + randomTime);
    }

    @And("^I select the film from the list$")
    public void iClickToTheFilmList() throws Throwable {
        Select select = new Select(driver.findElement(By.cssSelector("#quick-booking__film")));
        select.getAllSelectedOptions();
        List<WebElement> l = select.getOptions();
        Random rand = new Random();
        int max = l.size();
        int min = 1;
        randomFilm = rand.nextInt((max - min) + 1) + min;
        select.selectByIndex(randomFilm);
        Thread.sleep(1000);

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
    }

    @And("^I add (\\d+) tickets$")
    public void iAddTickets(int clicks) throws Throwable {
        WebElement Button = driver.findElement(By.cssSelector("input.qty-btn.qtyplus"));
        for (int i = 0; i < clicks; i++){
            Button.click(); // clicking on button
        }
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
        WebElement Button = driver.findElement(By.cssSelector("td.buttons > button"));
        Button.click(); // clicking on button
        System.out.println("STOP!");
    }
}
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