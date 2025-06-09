package com.qa.OrangeHRM.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class PIMPage {

    WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login Elements
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "(//*[text()='Admin Two'])[1]")
    private WebElement userInfo;

    // Navigation Tabs
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimTab;

    @FindBy(xpath = "//*[text()=' Add ']")
    private WebElement addEmployeeTab;

    // Add Employee Form
    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "middleName")
    private WebElement middleNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='lastName']/following::div/input")
    private WebElement employeeIdField;

    @FindBy(xpath = "(//img[@alt='profile picture'])[2]")
    private WebElement photographUploadInput;

    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    private WebElement createLoginSwitch;

    @FindBy(xpath = "//div[3]/div/div[1]/div/div[2]/input")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type='password']/following::input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='password']/preceding::input[@type='password']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    private WebElement savedemployeedetails;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']/preceding::input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;


    // ========== Action Methods ==========

    public void openURL(String url) {
        TestUtility.openPage(driver, url);
    }

    public void enterLoginCredentials(String user, String pass) {
        TestUtility.enterText(username, user, "Username field");
        TestUtility.enterText(password, pass, "Password field");
    }

    public void clickLogin() {
        TestUtility.clickElement(loginButton, "Login button");
    }

    public void navigateToAddEmployee() {
        TestUtility.clickElement(pimTab, "PIM tab");
    }

    public void clickonaddbutton() {
        TestUtility.clickElement(addEmployeeTab, "Add Employee tab");

    }
    public void search() {
        TestUtility.clickElement(pimTab, "PIM tab");
        TestUtility.clickElement(employeeNameInput, "Employee Name input");
        TestUtility.enterText(employeeNameInput, TestUtility.generatedFirstName, "Employee Name input");
    }

    public void enterfirstname() {
        TestUtility.enterRandomFirstName(firstNameField, "First Name field");
    }

    public void enterlastname() {
        TestUtility.enterRandomLastname(lastNameField, "Last Name field");
    }

    public void loginid() {
        TestUtility.getText(employeeIdField, "Employee ID field");
    }

    public void enableLoginCreation() {
        TestUtility.clickElement(createLoginSwitch, "Create Login toggle");
    }

    public void enterLoginDetails(String loginUsername, String loginPassword, String confirmPassword) {
        TestUtility.enterText(usernameField, loginUsername, "Login Username field");
        TestUtility.enterText(passwordField, loginPassword, "Login Password field");
        TestUtility.enterText(confirmPasswordField, confirmPassword, "Confirm Password field");
    }

    public void clickSave() {
        TestUtility.clickElement(saveButton, "Save button");
    }

    public void isEmployeeSaved() {
      
                TestUtility.printIfDisplayed(savedemployeedetails,"Saved Employee details successfully");
            }
    


    public void getSavedEmployeeId() {
        TestUtility.getText(employeeIdField, "Saved Employee ID field");
    }

    public void enterEmployeeName() {
        TestUtility.clickElement(employeeNameInput, "Employee Name input");
        TestUtility.enterRandomFirstName(employeeNameInput, "Employee Name input");
    }
}
