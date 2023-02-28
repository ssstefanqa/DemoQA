package Tests;

import Base.BaseTest;
import Pages.LandingPage;
import Pages.NavPanel;
import Pages.WebTablesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(siteURL);
        LandingPage = new LandingPage();
        NavPanel = new NavPanel();
        WebTablesPage = new WebTablesPage();
        LandingPage.clickOnMainSection(0);
        NavPanel.clickOnNavPanelTab("Web Tables");
    }

    @Test (priority = 10)
    public void userCanAddRecordsToTheTableWithValidData() {
        WebTablesPage.deleteAllRecords();
        WebTablesPage.clickOnAddButton();
        WebTablesPage.assertRegistrationForm();
        fillOutWebTableAddForm();
        WebTablesPage.clickOnSubmitButton();
        WebTablesPage.assertRecordIsAdded();
    }
}
