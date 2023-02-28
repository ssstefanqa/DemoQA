package Tests;

import Base.BaseTest;
import Pages.CheckBoxPage;
import Pages.LandingPage;
import Pages.NavPanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(siteURL);
        LandingPage = new LandingPage();
        NavPanel = new NavPanel();
        CheckBoxPage = new CheckBoxPage();
        LandingPage.clickOnMainSection(0);
        NavPanel.clickOnNavPanelTab("Check Box");
    }

    @Test (priority = 10)
    public void userCanSelectItemsAndGetCorrectOutput() {
        CheckBoxPage.openAllToggles();
        CheckBoxPage.allItemsL.get(2).click();
        CheckBoxPage.allItemsL.get(5).click();
        CheckBoxPage.assertTextBoxOutput();
    }
}
