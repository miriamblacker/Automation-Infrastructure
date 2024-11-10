package Utils;

import Driver.DriverManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait with customizable timeout
    public Waiting(DriverManagement driver, int timeoutSeconds) {
        this.driver = driver.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeoutSeconds));
    }

    // Wait for the page to load completely
    public void waitForPageLoad() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    // Wait for a specific element to be visible
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for a specific element to be clickable
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for a specific element to be invisible (useful for loaders or progress indicators)
    public void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait for a specific text to be present in an element
    public void waitForTextToBePresent(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    // Custom wait for a specific attribute to have a specific value
    public void waitForAttributeToBe(WebElement element, String attribute, String value) {
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    // Custom wait to ensure no interactions until all elements are ready
    public void waitForAllElementsToBePresent() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
