package com.qa.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.qa.timeUnits.TimeUnits;

public class TestUtility {

    private static Faker faker = new Faker();
    static String randomPassword;
    public static String generatedFirstName;

    // Open a URL in browser
    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

    // Find element by locator
    public static WebElement findElement(WebDriver driver, By selector) {
        return driver.findElement(selector);
    }

    // Click element with Allure step reporting
    public static void clickElement(WebElement element, String elementName) {
        String stepName = "Clicked on " + elementName;
        String stepUUID = UUID.randomUUID().toString();

        try {
            // Create StepResult with the name of the step
            StepResult stepResult = new StepResult().setName(stepName);

            // Start step with UUID and StepResult object
            Allure.getLifecycle().startStep(stepUUID, stepResult);

            element.click();

            // Mark step as passed
            Allure.getLifecycle().updateStep(step -> step.setStatus(Status.PASSED));
            Allure.getLifecycle().stopStep(stepUUID);
        } catch (Exception e) {
            // Mark step as failed
            Allure.getLifecycle().updateStep(step -> step.setStatus(Status.FAILED));
            Allure.getLifecycle().stopStep(stepUUID);
            throw e;
        }
    }

    public static void enterText(WebElement element, String value, String fieldName) {
        String stepName = "Entered '" + value + "' into " + fieldName;
        String stepUUID = UUID.randomUUID().toString();

        try {
            Allure.getLifecycle().startStep(stepUUID, new StepResult().setName(stepName));

            if (element == null) {
                throw new RuntimeException(fieldName + " is null");
            }
            if (!element.isDisplayed() || !element.isEnabled()) {
                throw new RuntimeException(fieldName + " is not interactable");
            }

            element.clear();
            element.sendKeys(value);

            System.out.println("Typed into UI: " + element.getAttribute("value"));

            Allure.getLifecycle().updateStep(step -> step.setStatus(Status.PASSED));
        } catch (Exception e) {
            Allure.getLifecycle().updateStep(step -> step.setStatus(Status.FAILED));
            throw e;
        } finally {
            Allure.getLifecycle().stopStep(stepUUID);
        }
    }

    public static String enterRandomEmail(WebElement element, String fieldName) {
        String randomEmail = faker.name().username() + "@gmail.com";
        System.out.println("Generated Email: " + randomEmail);
        enterText(element, randomEmail, fieldName);
        return randomEmail;
    }





    // Enter text into WebElement
    public static void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Enter text using By locator
    public static void enterTextWithBy(WebDriver driver, By ele, String text) {
        driver.findElement(ele).sendKeys(text);
    }

    // Send keys safely with exception handling
    public void fSendKeys(WebDriver driver, By element, String vSendKeys) {
        try {
            driver.findElement(element).sendKeys(vSendKeys);
        } catch (Exception e) {
            throw e;
        }
    }

    // Get text from element
    public static String getText(WebElement element) {
        return element.getText();
    }

    // Get page source
    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    // Upload file using Robot class
    public static void fileupload(String filepath) throws Exception {
        // Copy the file path to clipboard
        StringSelection str = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // Give time for the clipboard to set and the file dialog to appear
        Thread.sleep(2000); // Increased sleep for better reliability

        Robot rb = new Robot();
        rb.setAutoDelay(100); // Small delay between key events

        // Paste (Ctrl + V)
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(500); // Wait after pasting

        // Press Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }



    // Faker methods for random data entry

   

   

    public static void enterRandomUsername(WebElement element) throws IOException {
        String username = faker.name().username();
        element.sendKeys(username);
        System.out.println("Entered Random Username: " + username);
        String filePath = "./src/test/resources/Config/config.properties";

        // Load existing properties first
        Properties props = new Properties();
        FileInputStream in = new FileInputStream(filePath);
        props.load(in);
        in.close();

        // Update the username
        props.setProperty("adminusername", username);

        // Save the updated properties back to the file
        FileOutputStream out = new FileOutputStream(filePath);
        props.store(out,null);
        out.close();
    }

    public static void enterRandomPassword(WebElement element) {
        randomPassword = Faker.instance().regexify("[A-Z]{1}[a-z]{1}[0-9]{1}[!@#$%^&*]{1}[A-Za-z0-9!@#$%^&*]{7,8}");
        element.sendKeys(randomPassword);
        System.out.println("Entered Random Password: " + randomPassword);
    }
    public static void enterRandomMobileNumber(WebElement element, String fieldName) {
        String randomMobileNumber = "987" + faker.number().numberBetween(1000000, 9999999);
        enterText(element, randomMobileNumber, fieldName);
    }


    public static String getRandomPassword() {
        return randomPassword;
    }

    // Dropdown selection helpers

    public static void selectByVisibleText(WebElement dropdown, String visibleText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    public static void selectByValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement dropdown, int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public static String getSelectedOptionText(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public static List<WebElement> getAllOptions(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getOptions();
    }

    public static boolean isOptionPresent(WebElement dropdown, String optionText) {
        for (WebElement option : getAllOptions(dropdown)) {
            if (option.getText().equals(optionText)) {
                return true;
            }
        }
        return false;
    }

    public static int countDropdownOptions(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getOptions().size();
    }

    // Wait helpers

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebDriver driver, By selector, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitForElementToBePresent(WebDriver driver, By selector, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public static void waitForCustomCondition(WebDriver driver, ExpectedCondition<Boolean> condition, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(condition);
    }

    public static WebElement waitForWebElement(WebDriver driver, WebElement element, int timeOut) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOf(element));
    }

    // JavaScript helpers

    public static void executeJavaScript(WebDriver driver, String script) {
        ((JavascriptExecutor) driver).executeScript(script);
    }

    public static void executeJavaScript(WebDriver driver, String script, Object args) {
        ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public static void scrollToTop(WebDriver driver) {
        executeJavaScript(driver, "window.scrollTo(0, 0)");
    }

    public static void scrollToBottom(WebDriver driver) {
        executeJavaScript(driver, "window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        executeJavaScript(driver, "arguments[0].style.border='3px solid red'", element);
        waitForSeconds(driver, TimeUnits.KEEP_HIGHLIGHTED);
        // Optionally revert highlight:
        // executeJavaScript(driver, "arguments[0].style.border=''", element);
    }

    public static String getPageTitle(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.title;");
    }

    public static void waitForSeconds(WebDriver driver, int seconds) {
        executeJavaScript(driver, "var date = new Date(); var start = date.getTime(); " +
                "var end = start; while(end < start + " + (seconds * 1000) + ") {end = new Date().getTime();}");
    }

    public static void clickWithJavaScript(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static String getInputText(WebDriver driver, WebElement inputElement) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value", inputElement);
    }
    
    public static void enterRandomFirstName(WebElement element, String fieldName) {
        generatedFirstName = faker.name().firstName();
        enterText(element, generatedFirstName, fieldName);
    }
    public static void enterRandomMiddleName(WebElement element, String fieldName) {
        String generatedMiddleName = faker.name().firstName(); // Faker doesn't provide a direct 'middleName' method
        enterText(element, generatedMiddleName, fieldName);
    }

    // Enter random last name with Allure step
    public static void enterRandomLastname(WebElement element, String fieldName) {
        String lastName = faker.name().lastName();
        enterText(element, lastName, fieldName);
    }

    // Get text from WebElement with logging
    public static String getText(WebElement element, String fieldName) {
        String value = element.getText();
        System.out.println("Fetched value from " + fieldName + ": " + value);
        return value;
    }

    public static void printIfDisplayed(WebElement element, String successMessage) {
        String stepName;
        String stepUUID = UUID.randomUUID().toString();

        try {
            if (element != null && element.isDisplayed()) {
                System.out.println("Saved Employee details successfully");
                stepName = successMessage;
            } else {
                System.out.println("Search result found");
                stepName = "Search result found";
            }
        } catch (Exception e) {
            // Handles NoSuchElementException, StaleElementReferenceException, etc.
            System.out.println("Search result found");
            stepName = "Search result found";
        }

        Allure.getLifecycle().startStep(stepUUID, new StepResult().setName(stepName));
        Allure.getLifecycle().updateStep(step -> step.setStatus(Status.PASSED));
        Allure.getLifecycle().stopStep(stepUUID);
    }





    

    public static void printIfDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("Text: " + element.getText());
        } else {
            System.out.println("Element not displayed.");
        }
    }

}
