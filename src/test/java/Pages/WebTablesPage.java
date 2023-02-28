package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(id = "registration-form-modal")
    public WebElement registrationFormID;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "delete-record-1")
    public WebElement deleteRecordButton1;

    @FindBy(id = "delete-record-2")
    public WebElement deleteRecordButton2;

    @FindBy(id = "delete-record-3")
    public WebElement deleteRecordButton3;

    @FindBy(className = "rt-tr-group")
    public List<WebElement> ListOfRecords;


    // -----

    public void clickOnAddButton() {
        addNewRecordButton.click();
    }

    public void assertRegistrationForm() {
        Assert.assertEquals(registrationFormID.getText(), "Registration Form");
    }

    public void insertValidFirstName(String firstname) {
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void insertValidLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void insertValidEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertValidAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void insertValidSalary(String salary) {
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public void insertValidDepartment(String department) {
        departmentField.clear();
        departmentField.sendKeys(department);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void deleteAllRecords() {
        deleteRecordButton1.click();
        deleteRecordButton2.click();
        deleteRecordButton3.click();
    }

    public void assertRecordIsAdded() {
        Assert.assertEquals(ListOfRecords.get(0).getText(), "Pera\n" +
                "Peric\n" +
                "34\n" +
                "Pera@gmail.com\n" +
                "120000\n" +
                "Dentist");
    }
}