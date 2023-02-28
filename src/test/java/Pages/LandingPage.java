package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LandingPage extends BaseTest {

    public LandingPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "card-body")
    public List<WebElement> MainSections;

    // -----

    public void clickOnMainSection(int n) {
        scrollIntoView(MainSections.get(n));
        MainSections.get(n).click();
    }


}
