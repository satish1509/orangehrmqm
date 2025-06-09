package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.Directory;
import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;
import com.qa.utils.TestUtility;

import io.cucumber.java.en.*;

public class Directorysteps extends TestUtility {

    private WebDriver driver;
    private LoginPage loginPage;
    private Directory directoryPage;

    public Directorysteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.directoryPage = new Directory(driver);
    }

    @Given("the OrangeHRM application is opened in a browser")
    public void open_orangehrm_application() {
        System.out.println("Application is launched.");
        // URL opening can be handled via Hooks or utility
    }

    @And("the user logs in using valid credentials")
    public void login_with_valid_credentials() {
        loginPage.enterUsername(new ConfigReader().readConfig().getProperty("username"));
        loginPage.enterPassword(new ConfigReader().readConfig().getProperty("password"));
        loginPage.clickLogin();
        System.out.println("User logged in successfully.");
    }

    @And("the user navigates to the Directory section from the dashboard")
    public void navigate_to_directory_section() {
        directoryPage.clickOnDirectoryTab();
        System.out.println("Navigated to Directory tab.");
    }

    @When("the user types {string} into the employee name input field")
    public void type_employee_name(String employeeName) {
        directoryPage.enterEmployeeName(employeeName);
        System.out.println("Entered employee name: " + employeeName);
    }

    @And("selects the employee from the autocomplete suggestions")
    public void select_employee_from_autocomplete() {
        directoryPage.selectEmployeeFromSuggestion();
        System.out.println("Selected employee from suggestions.");
    }

    @And("presses the Search button in the Directory section")
    public void click_search_button_in_directory() {
        directoryPage.clickSearch();
        System.out.println("Clicked on Directory Search button.");
    }

    @Then("a message indicating {string} should appear in the results panel")
    public void verify_record_found_message(String expectedMessage) {
        directoryPage.verifyRecordFoundMessage(expectedMessage);
        System.out.println("Verified message: " + expectedMessage);
    }
}
