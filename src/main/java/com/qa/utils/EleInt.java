package com.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.timeUnits.TimeUnits;





public class EleInt {

	// Click on a WebElement
	public static void click(WebElement element) {
		
		element.click();
		
	
	}

	// Type text into an input field
	public static void typeText(WebElement element, String text) {
		element.sendKeys(text);
	}

	// Clear text from an input field
	public static void clearText(WebElement element) {
		element.clear();
		
		
	} 	

	// Press Enter key on a WebElement
	public static void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	// Press Tab key on a WebElement
	public static void pressTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	// Get text from a WebElement
	public static String getText(WebElement element) {
		return element.getText();
	}

	// Check if a WebElement is displayed
	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// Check if a WebElement is enabled
	public static boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	// Check if a WebElement is selected (for checkboxes or radio buttons)
	public static boolean isSelected(WebElement element) {
		return element.isSelected(); //true 
	}

	// Submit a form using a WebElement (e.g., a submit button)
	public static void submitForm(WebElement element) {
		element.submit();
	}

	// Add more utility methods as needed for your specific testing requirements

	// Enables FullSctreen Window
	public static void setFullScreen(WebDriver driver) {
		JavascriptExecutor JsExec = (JavascriptExecutor) driver;
		JsExec.executeScript("window.scrollTo(0, 0);"); // Scroll to top to ensure window is visible
		JsExec.executeScript(
				"window.setTimeout(function() { window.moveTo(0, 0); window.resizeTo(screen.width, screen.height); }, 500);");
	}

	/** START>>>These two methods deal with each other **/

	public static By clickIfPresent(WebDriver driver, By locator) {
		WebElement element = waitForElementPresence(driver, locator);
		if (element != null) {
			element.click();
		} else {
			System.out.println("Element not found within the timeout period.");
			return null;

		}
		return locator;
	}

	private static WebElement waitForElementPresence(WebDriver driver, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeUnits.EXPECTED_TIME_WEBELE));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			return null;
		}

	}

	/***** <<<<<<<<<*END */

	/** START >>> **/
	public static WebElement clickIfPresent(WebDriver driver, WebElement element) {
		
	    
		if (isElementPresent(element) &&element != null) {
			element.click();
			return element;
		}
		return null;      

	}
	public static boolean isElementPresent(WebElement element) {
        try {
            // Attempt to access a property of the element to check its presence
            element.isDisplayed();
            return true; // No exception, element is present
        } catch (NoSuchElementException | NullPointerException e) {
            return false; // Element not present or null
        }
    }

}

/** <<<<<<< END */
