package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String siteURL;
    public LandingPage LandingPage;
    public NavPanel NavPanel;
    public TextBoxPage TextBoxPage;
    public CheckBoxPage CheckBoxPage;
    public RadioButtonPage RadioButtonPage;
    public WebTablesPage WebTablesPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/DemoQA_Data.xlsx");
        siteURL = excelReader.getStringData("BaseInfo", 1,0);
    }

    @AfterClass
    public void eatAndQuit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void regularOldScroll() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 600)");
    }

    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isDisplayed1(WebElement element) {
        boolean webelement = false;
        try { webelement = element.isDisplayed();
        } catch (Exception e) {}
        return webelement;
    }

    public boolean ClickOnUnclickableElement(WebElement element) {
        boolean webelement = true;
        try {
            element.click();
        } catch (Exception e) {webelement = false;}
        return webelement;
    }

    public void fillOutWebTableAddForm() {
        WebTablesPage.assertRegistrationForm();
        WebTablesPage.insertValidFirstName(validFirstName());
        WebTablesPage.insertValidLastName(validLastName());
        WebTablesPage.insertValidEmail(validEmail());
        WebTablesPage.insertValidAge(validAge());
        WebTablesPage.insertValidSalary(validSalary());
        WebTablesPage.insertValidDepartment(validDepartment());
    }

    // ----- GENERAL DATA -----

    public String validUFullName() {
        return excelReader.getStringData("GeneralData", 1, 0);
    }

    public String validEmail() {
        return excelReader.getStringData("GeneralData", 1, 1);
    }

    public String validAddress1() {
        return excelReader.getStringData("GeneralData", 1, 2);
    }

    public String validAddress2() {
        return excelReader.getStringData("GeneralData", 1, 3);
    }

    public String validFirstName() {
        return excelReader.getStringData("GeneralData", 1, 4);
    }

    public String validLastName() {
        return excelReader.getStringData("GeneralData", 1, 5);
    }

    public String validAge() {
        return excelReader.getStringData("GeneralData", 1, 6);
    }

    public String validSalary() {
        return excelReader.getStringData("GeneralData", 1, 7);
    }

    public String validDepartment() {
        return excelReader.getStringData("GeneralData", 1, 8);
    }
}
