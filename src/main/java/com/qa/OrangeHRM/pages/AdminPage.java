package com.qa.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.qa.utils.TestUtility;

public class AdminPage extends TestUtility {

    WebDriver driver;

    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ========== Locators ==========
    By adminTab = By.xpath("//span[text()='Admin']");
    By addButton = By.xpath("//button[text()=' Add ']");
    By userRoleDropdown = By.xpath("//input[@placeholder='Type for hints...']/preceding::div[text()='-- Select --']");
    By userRoleOptionAdmin = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']/following::div/span[text()='Admin']");
    By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    By employeeNameOption = By.xpath("//span[text()='Kathleen  Abshire']");
    By statusDropdown = By.xpath("//input[@placeholder='Type for hints...']/following::div[text()='-- Select --']");
    By statusEnabled = By.xpath("//span[text()='Enabled']");
    By usernameInput = By.xpath("//div[4]//div/div[2]/input");
    By passwordInput = By.xpath("//input[@type='password']/following::input[@type='password']");
    By confirmPasswordInput = By.xpath("//input[@type='password']/preceding::input[@type='password']");
    By submitButton = By.xpath("//button[@type='submit']");
    By successMessageToast = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
    By userRoleFilter = By.xpath("//input[@placeholder='Type for hints...']/preceding::div[text()='-- Select --']");
    By userRoleValue = By.xpath("//div[@class='oxd-select-text--after']/following::span[text()='Admin']");
    By statusFilter = By.xpath("//input[@placeholder='Type for hints...']/following::div[@class='oxd-select-text-input']");
    By statusValueEnabled = By.xpath("//div[@class='oxd-select-text-input']/following::span[text()='Enabled']");
    By resultsTable = By.xpath("//div[@class='oxd-table-body']");
    By usernameSearch = By.xpath("//label[text()='Username']/following::input[@class='oxd-input oxd-input--active']");

    // ========== Page Methods ==========
    public void clickAdminTab() {
        clickElement(driver.findElement(adminTab), "Admin Tab");
    }

    public void clickAddButton() {
        clickElement(driver.findElement(addButton), "Add Button");
    }

    public void selectUserRoleAdmin() {
        clickElement(driver.findElement(userRoleDropdown), "User Role Dropdown");
        clickElement(driver.findElement(userRoleOptionAdmin), "User Role Admin Option");
    }

    public void clickOnEmployeeNameField() {
        clickElement(driver.findElement(employeeNameInput), "Employee Name Input");
    }

    public void enterEmployeeName(String name) {
        enterText(driver.findElement(employeeNameInput), name);
    }

    public void selectEmployeeFromList() {
        clickElement(driver.findElement(employeeNameOption), "Employee Option");
    }

    public void selectStatusEnabled() {
        clickElement(driver.findElement(statusDropdown), "Status Dropdown");
        clickElement(driver.findElement(statusEnabled), "Enabled Status");
    }

    public void enterUsername() {
        enterRandomUsername(driver.findElement(usernameInput));
    }

    public void enterPassword() {
        enterRandomPassword(driver.findElement(passwordInput));
    }

    public void enterConfirmPassword() {
        String confirmPassword = getRandomPassword();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        System.out.println("Entered Confirm Password: " + confirmPassword);
    }

    public void clickSubmit() {
        clickElement(driver.findElement(submitButton), "Submit Button");
    }

    public void validateDetailsSaved() {
        printIfDisplayed(driver.findElement(successMessageToast));
    }

    public void clickOnUserRoleFilter() {
        clickElement(driver.findElement(userRoleFilter), "User Role Filter");
    }

    public void selectAdminFromFilter() {
        clickElement(driver.findElement(userRoleValue), "Admin Role Value");
    }

    public void clickOnStatusFilter() {
        clickElement(driver.findElement(statusFilter), "Status Filter");
    }

    public void selectEnabledFromFilter() {
        clickElement(driver.findElement(statusValueEnabled), "Enabled Status Filter Value");
    }

    public void validateResultsTable() {
        printIfDisplayed(driver.findElement(resultsTable));
    }

    public void searchByUsername(String username) {
        enterText(driver.findElement(usernameSearch), username);
    }
}
