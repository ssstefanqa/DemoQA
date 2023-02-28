package Tests;

import Base.BaseTest;
import Pages.LandingPage;
import Pages.NavPanel;
import Pages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(siteURL);
        LandingPage = new LandingPage();
        NavPanel = new NavPanel();
        TextBoxPage = new TextBoxPage();
        LandingPage.clickOnMainSection(0);
        NavPanel.clickOnNavPanelTab("Text Box");

    }
    @Test
    public void TextBox_UserGetsValidOutputWithValidInput() {
        TextBoxPage.insertFullName(validUFullName());
        TextBoxPage.insertEmail(validEmail());
        TextBoxPage.insertCurrentAddress(validAddress1());
        TextBoxPage.insertPermanentAddress(validAddress2());
        TextBoxPage.clickOnSubmitBttn();
        Assert.assertTrue(TextBoxPage.outputBox.isDisplayed());
        TextBoxPage.assertCorrectFullNameOutput(validUFullName());
        TextBoxPage.assertCorrectEMailOutput(validEmail());
        TextBoxPage.assertCorrectCurrentAddressOutput(validAddress1());
        TextBoxPage.assertCorrectPermanentAddressOutput(validAddress2());
    }
}
