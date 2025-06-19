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
    }

    @Given("I am on the Recruitment menu")
    public void i_am_on_the_recruitment_menu() {
        System.out.println("Navigated to Recruitment module");
    }

    @And("I click on Add Candidate")
    public void clickAddCandidate() {
        add.clickAddCandidate();
    }

    @And("I select job vacancy")
    public void selectJobVacancy() {
        add.selectVacancyAutomationQA();
    }

    @When("I enter email id address")
    public void i_enter_email_id_address() {
        add.enterCandidateEmail();
    }

    @And("I click on Shortlist button")
    public void clickOnShortlistButton() {
        add.clickShortlist();
    }

    @And("I click on Save button")
    public void clickOnSaveButton() {
        add.clickSave();
    }

    @And("I clcik on schedule interview button")
    public void clickonscheduleinterviewbutton() throws InterruptedException {
        add.clickScheduleInterview();
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
        add.selectAvailableDate();
    }

    @And("I upload resume")
    public void uploadResume() throws Exception {
        String filePath = config.readConfig().getProperty("ResumefilePath");
        add.uploadResumeFile(filePath);
    }

    @And("I click on Save")
    public void clickSaveCandidate() {
        add.clickSubmit();
    }

    @And("I enter interviewer name")
    public void enterInterviewerName() {
        add.enterInterviewerName();
    }

    @And("I enter Interview title")
    public void enterInterviewTitle() {
        add.enterInterviewTitle();
    }

    @And("I enter Interview date")
    public void enterInterviewDate() {
        add.enterInterviewDate();
    }

    @And("I enter Interview time")
    public void enterInterviewTime() {
        add.enterInterviewTime();
    }

    @And("I click on Submit button")
    public void clickOnSubmitButton() {
        add.clickSubmit();
    }

    @And("I click on interview passed")
    public void clickOnInterviewPassed() {
        add.clickInterviewPassed();
    }

    @Then("the candidate should be added successfully")
    public void verifyCandidateAdded() {
        add.verifyCandidateSubmissionSuccess();
        System.out.println("Candidate added successfully");
    }
}
