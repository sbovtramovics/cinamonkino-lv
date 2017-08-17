package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestStepDefinitions {
    private Driver driver;
    public TestStepDefinitions(Driver driver) {
        this.driver = driver;
    }
    Calendar cal0 = Calendar.getInstance();
    Date date0 = cal0.getTime();
    SimpleDateFormat ft0 = new SimpleDateFormat("YYYY-MM-dd");
    String randomDate=ft0.format(date0);
    int randomFilm = 1;
    int randomTime=1;

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
}
