package util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver implements WebDriver {

    private static WebDriver driver;
    private final static WebDriverWait wait;

    private final Map<String, String> temporaryValues = new HashMap<String, String>();
    private final LinkedHashMap<String, String> temporaryValuesSavedOrder = new LinkedHashMap<String, String>();

    final static Logger logger = Logger.getLogger(Driver.class);
    //    private static final Logger logger = LoggerFactory.getLogger(Driver.class);
    public static String currentEnv = System.getProperty("spring.profiles.active");

    public Driver() {

    }

    static {
        System.getProperty("test");

        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
//		logger.info("This is a test");

        wait = (WebDriverWait) new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                driver.quit();
            }
        }, "Shutdown-thread"));
    }

    /**
     *
     * @param by
     *            - locator of element you wish to search for
     *
     */
    public void waitForElementPresent(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTextPresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForInvisibilityOfElement(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForVisibilityOfElementFromList(List<WebElement> list) {
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public void waitForInvisibilityOfElement(final WebElement element) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                if (!isElementPresent(element)) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public void waitForExpectedSizeInList(final int expectedSize, final List<WebElement> list) {
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    if (list.size() == expectedSize) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("Expected size:<" + expectedSize + "> but was:<" + list.size() + ">");
        }
    }

    /**
     *
     * @param by
     *            - locator of element you wish to search for
     * @return true if element is present, displayed, one of many with the same by and enabled false if not
     *
     */
    public boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0) {
            driver.findElement(by);
            if (driver.findElement(by).isDisplayed()) {
                if (driver.findElement(by).isEnabled()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    /**
     *
     * Temporary properties will allow data to be passed between steps or even scenarios
     *
     * @param key
     *            - Identifier for the value being added
     * @param value
     *            - value you wish to store
     *
     *
     */
    public void addTemporaryProperty(String key, String value) {
        temporaryValues.put(key, value);
    }

    public void addTemporaryPropertySavingOrder(String key, String value) {
        temporaryValuesSavedOrder.put(key, value);
    }

    public String getTemporaryProperty(String key) {
        return temporaryValues.get(key);
    }

    public String getTemporaryPropertySavedOrder(String key) {
        return temporaryValuesSavedOrder.get(key);
    }

    public Set<String> getTemporaryPropertyKey() {
        return temporaryValues.keySet();
    }

    public int getTemporaryPropertySize() {
        return temporaryValues.size();
    }

    public int getTemporaryValuesSavedOrderSize() {
        return temporaryValuesSavedOrder.size();
    }

    public Collection<String> getTemporaryPropertyValues() {
        return temporaryValues.values();
    }

    public Collection<String> getTemporaryPropertyValuesSavedOrder() {
        return temporaryValuesSavedOrder.values();
    }

    public void clearTemporaryProperty() {
        temporaryValues.clear();
    }

    public void clearTemporaryPropertySavedOrder() {
        temporaryValuesSavedOrder.clear();
    }

    public void close() {
        driver.close();
    }

    public WebElement findElement(By arg0) {
        return driver.findElement(arg0);
    }

    public List<WebElement> findElements(By arg0) {
        return driver.findElements(arg0);
    }

    public void get(String arg0) {
        driver.get(arg0);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public Options manage() {
        return driver.manage();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public void quit() {
        driver.quit();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("scroll(250,0);");
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    public void clearLocalStorage() {
        ((JavascriptExecutor) driver).executeScript("localStorage.clear()");
    }

    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.build().perform();
    }

    public void captureScreenshot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(fileName + ".png"), true);
    }

    public byte[] captureScreenshot() throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public String getSelectedDropdownOption(WebElement dropdown) {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }

}
