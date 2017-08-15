package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends GenericPage {

    @FindBy(how = How.TAG_NAME, using = "p")
    private WebElement paragraph;

    public HomePage() throws Exception{
        super();
    }

    public String getParagraphText() {
        return paragraph.getText();
    }

    public String getPageUrl() throws IOException {
        return pageURL;
    }
}
