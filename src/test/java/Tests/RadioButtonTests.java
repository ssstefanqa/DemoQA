package Tests;

import Base.BaseTest;
import Pages.LandingPage;
import Pages.NavPanel;
import Pages.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(siteURL);
        LandingPage = new LandingPage();
        NavPanel = new NavPanel();
        RadioButtonPage = new RadioButtonPage();
        LandingPage.clickOnMainSection(0);
        NavPanel.clickOnNavPanelTab("Radio Button");
    }

    @Test (priority = 10)
    public void userCanClickOnYesButton() {
        RadioButtonPage.clickOnYesRadioButton();
        Assert.assertEquals(RadioButtonPage.textOutput.getText(), "Yes");

    }

    @Test (priority = 20)
    public void userCanClickOnImpressiveButton() {
        RadioButtonPage.clickonImpressiveRadioButton();
        Assert.assertEquals(RadioButtonPage.textOutput.getText(), "Impressive");
    }

    @Test (priority = 30)
    public void userCannotClickOnNoButton() {
        RadioButtonPage.assertUnclickability();
    }
}
