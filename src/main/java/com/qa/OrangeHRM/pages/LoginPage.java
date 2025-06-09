package com.qa.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class LoginPage extends TestUtility {


    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
    
        PageFactory.initElements(driver,this);
    }

    By userinp=By.xpath("//inlsl");
    		
    // WebElements using @FindBy
    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath="//h5[text()='Login']")
    WebElement loginpage;

    // Page methods
    public void enterUsername(String username) {
        usernameInput.clear();
        enterText(usernameInput, username); // or TestUtility.enterText(...)
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        enterText(passwordInput, password);
    }

    public void clickLogin() {
    	clickElement(loginButton,"loginbutton");
    }
    public void loginpagedisplayed() {
   // 	isDisplayed(loginpage);
    }
}
