package pageObjects;

import java.io.IOException;
import util.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.PropertiesUtil;

public class GenericPage {
    protected String pageURL;
    private Driver driver;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement header;


    public GenericPage() throws Exception {
        pageURL = PropertiesUtil.loadSiteProperty("homePageUrl") + "/";
    }

    public String getPageHeaderText() {
        return header.getText();
    }

    public void openPage() throws IOException {
        driver.get(pageURL);
    }
}

