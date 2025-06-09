package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.OrangeHRM.pages.PIMPage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;
import com.qa.utils.TestUtility;

import io.cucumber.java.en.*;

public class PIMsteps extends TestUtility {

    private WebDriver driver;
    private LoginPage loginPage;
    private PIMPage pimPage;
    
    public PIMsteps() {
        this.driver = DriverFactory.getDriver(); 
        this.loginPage = new LoginPage(driver);
        this.pimPage = new PIMPage(driver);
    }

   
    @Given("User navigated to the url")
    public void user_navigated_to_the_url() {
        System.out.println("URL opened.");
    }

    @And("user signed into the application")
    public void user_signed_into_the_application() {
    	
    	
        loginPage.enterUsername(new ConfigReader().readConfig().getProperty("username"));
        loginPage.enterPassword(new ConfigReader().readConfig().getProperty("password"));
        loginPage.clickLogin();
        System.out.println("User signed into the application.");
    }

    @And("user navigates to the PIM page")
    public void user_navigates_to_the_pim_page() {
        pimPage.navigateToAddEmployee();
        System.out.println("User navigated to the PIM page.");
    }

    @When("I click on the Add button")
    public void i_click_on_the_add_button() {
    	pimPage.clickonaddbutton();
        System.out.println("Clicked on the Add Employee button.");
   
    }

    @And("I enter employee first name")
    public void i_enter_employee_first_name() {
         pimPage.enterfirstname();
    }

    @And("I enter employee last name")
    public void i_enter_employee_last_name() {
        pimPage.enterlastname();
        System.out.println("Entered employee last name.");
    }

    @And("I see employee ID number")
    public void i_see_employee_id_number() {
        pimPage.getSavedEmployeeId();
    }

   

    @And("I click on the Save button")
    public void i_click_on_the_save_button() {
        pimPage.clickSave();
        System.out.println("Clicked Save.");
    }

    @Then("the employee should be added successfully")
    public void the_employee_should_be_added_successfully() {
    	pimPage.isEmployeeSaved();
        System.out.println("Employee successfully added: ");
    }
    @When("I enter employee name in the search field")
    public void i_enter_employee_name_in_the_search_field() {
    	pimPage.search();
        // Simulate entering employee name
        System.out.println("Entered employee name in the search field.");
    }

    @And("I click on the Search button")
    public void i_click_on_the_search_button() {
        // Simulate clicking the search button
        pimPage.clickSave();
        
    }

    @Then("the employee record should be displayed in the results")
    public void the_employee_record_should_be_displayed_in_the_results() {
        // Simulate verifying the search result
    	pimPage.isEmployeeSaved();
        System.out.println("Employee record displayed in the search results.");
    }

}
