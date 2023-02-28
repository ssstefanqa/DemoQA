package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "custom-control-label")
    public List<WebElement> radioButtonsL;

    @FindBy (className = "text-success")
    public WebElement textOutput;

    @FindBy (css = ".custom-control-label.disabled")
    public WebElement noRadioButtonDisabled;

    // -----

    public void clickOnYesRadioButton() {
        radioButtonsL.get(0).click();
    }

    public void clickonImpressiveRadioButton() {
        radioButtonsL.get(1).click();
    }

    public void assertUnclickability() {
        Assert.assertTrue(ClickOnUnclickableElement(noRadioButtonDisabled));
    }
}
