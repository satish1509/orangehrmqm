package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class AddCandidatePage {

    WebDriver driver;

    public AddCandidatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ========== Page Elements ==========

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitmentTab;

    @FindBy(xpath = "//*[text()=' Add ']")
    private WebElement addCandidateButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[text()='-- Select --']")
    private WebElement vacancyDropdown;

    @FindBy(xpath = "//span[text()='Automation QA chromium 1747377754679']")
    private WebElement automationQAOption;

    @FindBy(xpath = "//input[@placeholder='Type here']/preceding::input[@placeholder='Type here']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Type here']/following::input[@placeholder='Type here']")
    private WebElement contactNumberField;

    @FindBy(xpath = "//div[text()='Browse']")
    private WebElement browseButton;

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    private WebElement keywordsField;

    @FindBy(xpath = "//input[@placeholder='mm-dd-yyyy']")
    private WebElement dateField;

    @FindBy(xpath = "//input[@placeholder='mm-dd-yyyy']/following::div[text()='4']")
    private WebElement selectDateOption;

    @FindBy(xpath = "//label[text()='Notes']/following::textarea[@placeholder='Type here']")
    private WebElement notesField;

    @FindBy(xpath = "//input[@type='checkbox']/following::span")
    private WebElement consentCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    private WebElement successToastMessage;

    @FindBy(xpath = "//*[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[text()=' Shortlist ']")
    private WebElement shortlistButton;

    // ========== Action Methods ==========

    public void navigateToRecruitmentPage() {
        TestUtility.clickElement(recruitmentTab, "Recruitment Tab");
    }

    public void clickAddCandidate() {
        TestUtility.clickElement(addCandidateButton, "Add Candidate Button");
    }

    public void enterCandidateFirstName() {
        TestUtility.enterRandomFirstName(firstNameField, "First Name Field");
    }

    public void enterCandidateMiddleName() {
        TestUtility.enterRandomMiddleName(middleNameField,"Middle Name Field");
    }

    public void enterCandidateLastName() {
        TestUtility.enterRandomLastname(lastNameField, "Last Name Field");
    }

    public void selectVacancyAutomationQA() {
        TestUtility.clickElement(vacancyDropdown, "Vacancy Dropdown");
        TestUtility.clickElement(automationQAOption, "Automation QA Vacancy");
    }

    public void enterCandidateEmail() {
        TestUtility.enterRandomEmail(emailField, "Email Field");
    }

    public void enterCandidateContactNumber() {
        TestUtility.enterRandomMobileNumber(contactNumberField, "Contact Number Field");
    }


    

    public void uploadResumeFile(String filePath) throws Exception {
        TestUtility.clickElement(browseButton, "Browse Resume Button And Selected Resume");
        TestUtility.fileupload(filePath);
    }

    public void enterKeywords(String keywords) {
        TestUtility.enterText(keywordsField, keywords, "Keywords Field");
    }

    public void selectAvailableDate() {
        TestUtility.clickElement(dateField, "Available Date Field");
        TestUtility.clickElement(selectDateOption, "Select Date Option");
    }

    public void enterNotes(String notes) {
        TestUtility.enterText(notesField, notes, "Notes Field");
    }

    public void acceptConsent() {
        TestUtility.clickElement(consentCheckbox, "Consent Checkbox");
    }

    public void clickSubmit() {
        TestUtility.clickElement(submitButton, "Submit Button");
    }

    public void clickSave() {
        TestUtility.clickElement(saveButton, "Save Button");
    }

    public void clickShortlist() {
        TestUtility.clickElement(shortlistButton, "Shortlist Button");
    }

    public void verifyCandidateSubmissionSuccess() {
        TestUtility.printIfDisplayed(successToastMessage, "Candidate added successfully");
    }

    // ========== End-to-End Flow ==========

    


}
