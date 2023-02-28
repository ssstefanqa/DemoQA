package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".rct-icon.rct-icon-expand-close")
    public List<WebElement> toggleOpenL;

    @FindBy (className = "rct-title")
    public List<WebElement> allItemsL;

    @FindBy (className = "text-success")
    public List<WebElement> textOutputL;

    @FindBy (id = "result")
    public WebElement textOutput;

    @FindBy (css = ".rct-icon.rct-icon-check")
    public List<WebElement> checkedItemsL;

    public void openAllToggles() {
        do {
            for (int i = 0; i < toggleOpenL.size(); i++) {
                toggleOpenL.get(i).click();
            }
        } while (toggleOpenL.size() > 0);
    }

    public void getTextFromTextOutput() {
        for (int i = 0; i < textOutputL.size(); i++) {
            System.out.println(textOutputL.get(i).getText());
        }
    }

    public void assertTextBoxOutput() {
        Assert.assertEquals(textOutput.getText(), "You have selected :\n" +
                "notes\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu");
    }

}
