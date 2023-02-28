package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class TextBoxPage extends BaseTest {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName")
    public WebElement FullNameField;

    @FindBy (id = "userEmail")
    public WebElement emailField;

    @FindBy (id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy (id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy (css = ".btn.btn-primary")
    public WebElement submitBttn;

    @FindBy (className = "mb-1")
    public List<WebElement> textBoxOutputList;

    @FindBy (id = "output")
    public WebElement outputBox;

    // -----

    public void insertFullName(String username) {
        FullNameField.clear();
        FullNameField.sendKeys(username);
    }

    public void insertEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress) {
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }

    public void insertPermanentAddress(String permanentAddress) {
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitBttn() {
        scrollIntoView(submitBttn);
        submitBttn.click();
    }

    public void assertCorrectFullNameOutput(String validname) {
        Assert.assertEquals(textBoxOutputList.get(0).getText(),"Name:"+validname);
    }

    public void assertCorrectEMailOutput(String validemail) {
        Assert.assertEquals(textBoxOutputList.get(1).getText(),"Email:"+validemail);
    }

    public void assertCorrectCurrentAddressOutput(String validCurrAddress) {
        Assert.assertEquals(textBoxOutputList.get(2).getText(),"Current Address :"+validCurrAddress);
    }

    public void assertCorrectPermanentAddressOutput(String validPermAddress) {
        Assert.assertEquals(textBoxOutputList.get(3).getText(), "Permananet Address :"+validPermAddress);
    }

}
