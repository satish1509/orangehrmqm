package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.AddCandidatePage;
import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCandidateSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private AddCandidatePage add;
    private ConfigReader config;

    public AddCandidateSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.add = new AddCandidatePage(driver);
        this.config = new ConfigReader();
    }

    @Given("the application is opened in a web browser")
    public void launchApplication() {
        driver.get(config.readConfig().getProperty("url"));
        System.out.println("Application is opened");
    }

    @And("the user provides valid login credentials to access the dashboard")
    public void loginToApplication() {
        String username = config.readConfig().getProperty("username");
        String password = config.readConfig().getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Logged in with valid credentials");
    }

    @And("the user navigated to recruitment module")
    public void accessRecruitmentModule() {
        add.navigateToRecruitmentPage();
        System.out.println("Navigated to Recruitment module");
    }

    @Given("I am on the dashboard")
    public void i_am_on_the_dashboard() {
        System.out.println("User is on the OrangeHRM dashboard");
    }

    @When("I click on the Recruitment menu")
    public void clickRecruitment() {
        add.navigateToRecruitmentPage();
    }

    @And("I click on Add Candidate")
    public void clickAddCandidate() {
        add.clickAddCandidate();
    }

    @And("I select job vacancy")
    public void selectJobVacancy() {
        add.selectVacancyAutomationQA();
    }

    @And("I click on Shortlist button")
    public void clickOnShortlistButton() {
        add.clickShortlist();
    }

    @And("I click on Save button")
    public void clickOnSaveButton() {
        add.clickSave();
    }

    @And("I type name of candidate")
    public void i_type_name_of_candidate() {
        add.enterCandidateFirstName();
        add.enterCandidateMiddleName();
        add.enterCandidateLastName();
    }

    @And("I enter email address")
    public void enterEmailAddress() {
        add.enterCandidateEmail();
    }

    @And("I enter mobile number")
    public void enterMobileNumber() {
        add.enterCandidateContactNumber();
    }

    @And("I upload resume")
    public void uploadResume() throws Exception {
        String filePath = config.readConfig().getProperty("StringfilePath");
        add.uploadResumeFile(filePath);
        add.selectAvailableDate();
    }

    @And("I click on Save")
    public void clickSaveCandidate() {
        add.clickSubmit();
    }

    @Then("the candidate should be added successfully")
    public void verifyCandidateAdded() {
        add.verifyCandidateSubmissionSuccess();
        System.out.println("Candidate added successfully");
    }
}
