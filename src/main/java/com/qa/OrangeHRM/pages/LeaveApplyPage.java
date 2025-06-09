package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class LeaveApplyPage {

    WebDriver driver;

    public LeaveApplyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ========== Navigation ==========
    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveTab;

    @FindBy(xpath = "//a[text()='Apply']")
    private WebElement applyLeaveButton;

    // ========== Leave Type ==========
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//span[text()='Casual Leave']")
    private WebElement casualLeaveOption;

    // ========== Date Pickers ==========
    @FindBy(xpath = "//div[@class='oxd-date-input']/preceding::input[@placeholder='mm-dd-yyyy']")
    private WebElement fromDateInput;

    @FindBy(xpath = "//div[@class='oxd-date-input']/preceding::input[@placeholder='mm-dd-yyyy']/following::div[text()='9']")
    private WebElement fromDateSelect;

    @FindBy(xpath = "//div[@class='oxd-date-input']/following::input[@placeholder='mm-dd-yyyy']")
    private WebElement toDateInput;

    @FindBy(xpath = "//div[@class='oxd-date-input']/following::input[@placeholder='mm-dd-yyyy']/following::div[text()='10']")
    private WebElement toDateSelect;

    // ========== Partial Days ==========
    @FindBy(xpath = "(//input[@placeholder='mm-dd-yyyy'])[2]/following::div[@tabindex='0']")
    private WebElement partialDaysDropdown;

    @FindBy(xpath = "//span[text()='Start Day Only']")
    private WebElement startDayOnlyOption;

    @FindBy(xpath = "//div[text()='Start Day Only']/following::*[text()='-- Select --']")
    private WebElement startDayTimeDropdown;

    @FindBy(xpath = "//div[text()='-- Select --']/following::span[text()='Half Day - Morning']")
    private WebElement halfDayMorningOption;

    // ========== Comment & Submit ==========
    @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    private WebElement commentBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    private WebElement successToast;

    // ========== Action Methods ==========

    public void navigateToLeaveApplyPage() {
        TestUtility.clickElement(leaveTab, "Leave tab");
        TestUtility.clickElement(applyLeaveButton, "Apply Leave button");
    }

    public void selectLeaveTypeCasual() {
        TestUtility.clickElement(leaveTypeDropdown, "Leave Type dropdown");
        TestUtility.clickElement(casualLeaveOption, "Casual Leave option");
    }

    public void selectFromDate() {
        TestUtility.clickElement(fromDateInput, "From Date input");
        TestUtility.clickElement(fromDateSelect, "Select From Date");
    }

    public void selectToDate() {
        TestUtility.clickElement(toDateInput, "To Date input");
        TestUtility.clickElement(toDateSelect, "Select To Date");
    }

    public void selectPartialDay() {
        TestUtility.clickElement(partialDaysDropdown, "Partial Days dropdown");
        TestUtility.clickElement(startDayOnlyOption, "Start Day Only option");
        TestUtility.clickElement(startDayTimeDropdown, "Start Day Time dropdown");
        TestUtility.clickElement(halfDayMorningOption, "Half Day - Morning");
    }

    public void enterLeaveComment(String comment) {
        TestUtility.enterText(commentBox, comment, "Leave Comment");
    }

    public void submitLeaveRequest() {
        TestUtility.clickElement(submitButton, "Submit Leave button");
    }

    public void verifyLeaveSubmissionSuccess() {
        TestUtility.printIfDisplayed(successToast, "Leave applied successfully");
    }

    // ========== Complete Flow ==========
    public void applyCasualLeave(String comment) throws InterruptedException {
        navigateToLeaveApplyPage();
        selectLeaveTypeCasual();
        selectFromDate();
        selectToDate();
        selectPartialDay();
        enterLeaveComment(comment);
        submitLeaveRequest();
        verifyLeaveSubmissionSuccess();
    }
}
