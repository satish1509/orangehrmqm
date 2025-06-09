package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.utils.TestUtility;

public class Directory {

    private WebDriver driver;

    // ===== Constructor =====
    public Directory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===== Page Elements =====

    @FindBy(xpath = "//li//span[.='Directory']")
    private WebElement directoryTab;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[text()='Tandra  Klocko']")
    private WebElement suggestionOption;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[text()='(1) Record Found']")
    private WebElement recordFoundLabel;

    // ===== Action Methods =====

    public void clickOnDirectoryTab() {
        TestUtility.clickElement(directoryTab, "Directory Tab");
    }

    public void enterEmployeeName(String name) {
        TestUtility.enterText(searchInput, name, "Search Input Field");
    }

    public void selectEmployeeFromSuggestion() {
        TestUtility.clickElement(suggestionOption, "Suggested Employee Option");
    }

    public void clickSearch() {
        TestUtility.clickElement(searchButton, "Search Button");
    }

    public void verifyRecordFoundMessage(String expectedMessage) {
        TestUtility.printIfDisplayed(recordFoundLabel, " 1 Record found");
    }
}
