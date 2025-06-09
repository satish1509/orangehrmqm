package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class TimePage extends TestUtility {

    private WebDriver driver;

    // Constructor
    public TimePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ============ Web Elements ============

    @FindBy(xpath = "//span[text()='Time']")
    private WebElement timeTab;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//input[@placeholder='mm-dd-yyyy']")
    private WebElement timesheetPeriodInput;

    @FindBy(xpath = "//button[text()=' Submit ']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast--success')]")
    private WebElement successMessageToast;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Timesheets ']")
    private WebElement timesheetDropdown;

    @FindBy(xpath = "//p[text()='Timesheet Period']/following::i[@class='oxd-icon bi-chevron-left']")
    private WebElement lastWeekButton;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Timesheets ']/following::a[text()='My Timesheets']")
    private WebElement myTimesheetOption;

    // ============ Action Methods ============

    public void clickTimeTab() {
        clickElement(timeTab, "Time Tab");
    }

    public void verifyDashboardIsDisplayed() {
        printIfDisplayed(dashboardHeader, "Dashboard header is displayed");
    }

    public void verifyTimesheetPeriodInputDisplayed() {
        printIfDisplayed(timesheetPeriodInput, "Timesheet period input is displayed");
    }

    public void clickSubmitButton() {
        clickElement(submitButton, "Submit Button");
    }

    public void verifySubmissionSuccessMessage() {
        printIfDisplayed(successMessageToast, "Timesheet submitted successfully");
    }

    public void clickTimesheetDropdown() {
        clickElement(timesheetDropdown, "Timesheet dropdown");
    }

    public void clickMyTimesheetAndLastWeek() {
        clickElement(myTimesheetOption, "My Timesheets Option");
        clickElement(lastWeekButton, "Last Week Button");
    }
}
