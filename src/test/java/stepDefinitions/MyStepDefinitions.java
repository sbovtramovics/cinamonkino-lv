package stepDefinitions;
import java.util.Random;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Driver;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.apache.commons.lang3.ArrayUtils;

public class MyStepDefinitions {
    private Driver driver;
    public MyStepDefinitions(Driver driver) {
        this.driver = driver;
    }
    private String StoredSum;
    private String [][] SeatData;
    private String reservedSeatId;

    private int Random(int max, int min) throws Throwable{
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private String[] splitString(String text) throws Throwable{
        text = text.replaceFirst(",", " -");
        text = text.replaceFirst("r", "R");
        text = text.replace(",","");
        String [] returnValue = text.split(" ");
        ArrayUtils.reverse(returnValue);
        return returnValue;
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

    @And("^I select the film from the list$")
    public void iClickToTheFilmList() throws Throwable {
        Select select = new Select(driver.findElement(By.cssSelector("#quick-booking__film")));
        select.getAllSelectedOptions();
        List<WebElement> l = select.getOptions();
        int randomFilm =  Random(l.size()-1, 1);
        select.selectByIndex(randomFilm);
        Thread.sleep(2000);

    }

    @And("^I choose the time from the list$")
    public void iChooseTheTimeFromTheList() throws Throwable {
        Select select = new Select(driver.findElement(By.cssSelector("#quick-booking__session")));
        List<WebElement> l = select.getOptions();
        int randomTimeIndex = Random(l.size()-1, 2);
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
        int length= Random(11, 2);
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        WebElement  couponField = driver.findElement(By.cssSelector("input[placeholder='Pievienot kupona kodu']"));
        assertEquals(couponField.getText(), ""); // checking that firstNameText is empty
        couponField.sendKeys(String.valueOf(new String(text)));
    }

    @And("^I scroll down the page$")
    public void iScrollDownThePage() throws Throwable {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(1000);
    }

    @And("^I press validate button$")
    public void iPressValidateButton() throws Throwable {
        WebElement Button = driver.findElement(By.cssSelector("button.small.secondary.validate"));//#next-step
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

    @And("^I check first random seat at the last row if available$")
    public void iCheckFirstRandomSeatAtTheLastRowIfAvailable() throws Throwable {
        List<WebElement> seatList1= driver.findElements(By.cssSelector(".empty.normal[id*='a1-r0-s'], .reserved.normal[id*='a1-r0-s']")); //.empty.normal[id*='a1-r0-s']
        int seat1;
        if (seatList1.size()==0)
        {
            seatList1= driver.findElements(By.cssSelector(".empty.normal[id*='a1-r'], .reserved.normal[id*='a1-r']"));
            assertNotEquals(seatList1.size(), 0);
        }
        seat1 = Random(seatList1.size()-1, 0);
        seatList1.get(seat1).click();
        reservedSeatId=seatList1.get(seat1).getAttribute("id");
    }

    @And("^I check second random seat at the penult row if available$")
    public void iCheckSecondRandomSeatAtThePenultRowIfAvailable() throws Throwable {
        int seat2;
        List<WebElement> seatList2= driver.findElements(By.cssSelector(".empty.normal[id*='a1-r1-s'], .reserved.normal[id*='a1-r1-s']:not([id='"+reservedSeatId +"'])"));
        if (seatList2.size()==0)
        {
            seatList2= driver.findElements(By.cssSelector(".empty.normal[id*='a1-r'], .reserved.normal[id*='a1-r']:not([id='"+ reservedSeatId +"'])"));
            assertNotEquals(seatList2.size(), 0);
        }
        seat2 = Random(seatList2.size()-1, 0);
        seatList2.get(seat2).click();
    }

    @And("^I store the seat numbers$")
    public void iStoreTheSeatNumbers() throws Throwable {
        List<WebElement> SeatDataList = driver.findElements(By.cssSelector("div.medium-6.columns.picked-summary > ul >*"));
        assertNotEquals(SeatDataList.size(), 0);
        String [] seatDataRow;
        SeatData = new String [SeatDataList.size()][2];
        for(int i = 0; i < SeatDataList.size(); i++){
            seatDataRow = splitString(SeatDataList.get(i).getText());
            for(int k = 0; k < 2; k++) {
                SeatData[i][k] = seatDataRow[k];
            }
        }
    }

    @And("^I press Next again$")
    public void iPressNextAgain() throws Throwable {
        WebElement submitButton = driver.findElement(By.cssSelector("input.button.big-submit"));
        submitButton.click();
    }

    @And("^I check stored sum$")
    public void iCheckStoredSum() throws Throwable {
        WebElement storedSumText = driver.findElement(By.cssSelector("td.total"));
        assertEquals(storedSumText.getText(), StoredSum);
    }

    @And("^I check stored seats$")
    public void iCheckStoredSeats() throws Throwable {
        List<WebElement> seatDataList = driver.findElements(By.cssSelector("tr.ticket-row:not(:nth-child(1)):not(:nth-child(2)):not(:nth-child(3)):not(:nth-child(4)) > td")); //tbody > tr:nth-child(5) > td tbody>
        assertNotEquals(seatDataList.size(), 0);
        String [] seatDataRow;
        for(int i = 0; i < seatDataList.size(); i++){
            seatDataRow = splitString(seatDataList.get(i).getText());
            for(int k = 0; k < 2; k++) {
                assertEquals(seatDataRow[k],SeatData[i][k]);
            }
        }
    }

    @And("^I change the order by clicking change the order button$")
    public void iChangeTheOrderByClikingChangeTheOrderButton() throws Throwable {
        WebElement changeOrderButton = driver.findElement(By.cssSelector("a.button.change-btn.light-btn"));
        changeOrderButton.click();
    }

    @And("^I check availability of (\\d+) payment methods$")
    public void iCheckAvailabilityOfPaymentMethods(int paymentMethodsCount) throws Throwable {
        List<WebElement> l= driver.findElements(By.cssSelector("#submit_order_form > ul >*"));
        assertEquals(l.size(), paymentMethodsCount);
    }

    @And("^I logout$")
    public void iLogout() throws Throwable {
        WebElement logoutButton = driver.findElement(By.cssSelector("a.logout"));
        logoutButton.click();
    }

    @And("^I do something$")
    public void iDoSomething() throws Throwable {
        System.out.println("STOP");
    }
}



        /*for(int i = 0; i < seatDataList.size(); i++){
            for(int k = 0; k < 2; k++) {
                if(!CurrrentSeatData[i][k].equals(SeatData[i][k])){
                    fail();
                    CurrrentSeatData[i][k] = seatDataRow[k];
                     //String [][] CurrrentSeatData = new String [seatDataList.size()][2];
                }
            }
        }*/
//if(CurrrentSeatData[i][k].equals("sēdvieta") || SeatData[i][k].equals("sēdvieta")){
//}
//System.out.println("For i run "+i+"times");
//System.out.println("For k run "+k+"times");
//System.out.println("STOP!");
//System.out.println("STOP");
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

//WebElement seat1 = driver.findElement(By.cssSelector(".empty.normal"));
//seat1.click();
//WebElement seat2 = driver.findElement(By.cssSelector(".empty.normal"));
//seat2.click();
//.empty.normal[id*='a1-r0-s']


//while ( Boolean isPresent = driver.findElements(By.cssSelector(".empty.normal[id='a1-r0-s"+i+"']")).size() > 0)
//{
//    Boolean isPresent = driver.findElements(By.cssSelector(".empty.normal[id='a1-r0-s"+i+"']")).size() > 0;
//System.out.println(l.get(i).getAttribute("id"));
//}//

//System.out.println("STOP!");
        /*List<WebElement> l= driver.findElements(By.cssSelector(".reserved.normal"));
        int length= l.size();
        int[] seatNumbers = new int[length];
        for (int i = 0; i < length; i++)
        {
            //seatNumbers[i] =

        }
        */

// assertEquals(seatDataText.size(), seatDataText.size());
       /* for(int i = 0; i < seatDataText.size(); i++){

        }

        if (seatDataText.getText().equals(SeatData)) {
            String[] storedSeatData = splitString(SeatData);
            //String[] currentSeatData = splitString(seatDataText.getText());
            //System.out.println(seatDataText.getText()+ " " + SeatData);
            //System.out.println(currentSeatData[currentSeatData.length-2] + " " + storedSeatData[storedSeatData.length - 2]);
            //System.out.println(currentSeatData[currentSeatData.length - 2] + " " + storedSeatData[storedSeatData.length - 2]);
            //assertEquals(currentSeatData[currentSeatData.length - 1], storedSeatData[storedSeatData.length - 2]);
            //assertEquals(currentSeatData[currentSeatData.length - 2], storedSeatData[storedSeatData.length - 1]);
        } else
        {
            assertEquals(seatDataText.getText(), SeatData);
        }*/
// SeatData.get(i) = splitString(SeatData.get(i));
//WebElement seatDataText = driver.findElement(By.cssSelector("div.medium-6.columns.picked-summary > ul >*")); //div.medium-6.columns.picked-summary li
//SeatData=seatDataText.getText();
//SeatData=seatDataText.getText().replaceFirst(",", " -");
//SeatData=SeatData.replaceFirst("r", "R");