package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.OrangeHRM.pages.TimePage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.*;

public class Timesheetstep {

    private WebDriver driver;
    private LoginPage loginPage;
    private TimePage timePage;
    private ConfigReader config;

    public Timesheetstep() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.timePage = new TimePage(driver);
        this.config = new ConfigReader();
    }

    @Given("user launches URL")
    public void user_launches_url() {
        System.out.println("Launching the application URL");
        driver.get(config.readConfig().getProperty("url"));
    }

    @And("user signs into the OrangeHRM with valid credentials")
    public void user_signs_into_orangehrm_with_valid_credentials() {
        String username = config.readConfig().getProperty("username");
        String password = config.readConfig().getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Logged in with valid credentials");
    }

    @And("user navigated to the dashboard")
    public void user_navigated_to_dashboard() {
        timePage.verifyDashboardIsDisplayed();
        System.out.println("Dashboard is displayed");
    }

    @When("user clicks on the Time tab")
    public void user_clicks_on_time_tab() {
        timePage.clickTimeTab();
        System.out.println("Clicked on Time tab");
    }

    @And("user clicks on Timesheet dropdown")
    public void user_clicks_on_timesheet_dropdown() {
        timePage.clickTimesheetDropdown();
        System.out.println("Clicked on Timesheet dropdown");
    }

    @When("user clicks on My Timesheet")
    public void user_clicks_on_my_timesheet() {
        timePage.clickMyTimesheetAndLastWeek();
        System.out.println("Clicked on My Timesheet and selected last week");
    }

    @Then("timesheet period for current week is displayed")
    public void timesheet_period_should_be_displayed() {
        timePage.verifyTimesheetPeriodInputDisplayed();
        System.out.println("Timesheet period displayed");
    }

    @And("user clicks on Submit button")
    public void user_clicks_on_submit_button() {
        timePage.clickSubmitButton();
        System.out.println("Clicked on Submit button");
    }

    @Then("timesheet is submitted successfully")
    public void timesheet_should_be_submitted_successfully() {
        timePage.verifySubmissionSuccessMessage();
        System.out.println("Timesheet submitted successfully");
    }
}
