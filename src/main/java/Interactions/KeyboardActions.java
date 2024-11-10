package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

    private static Actions actions;

    // אתחול המחלקה עם DriverManagement
    public static void initialize(DriverManagement driverManagement) {
        actions = new Actions(driverManagement.getDriver());  // אתחול של Actions רק פעם אחת
    }

    // פונקציה להקשה על מקש בודד
    public static void pressKey(WebElement element, Keys key) {
        actions.moveToElement(element).sendKeys(key).perform();
    }

    // פונקציה לשילוב של מקשים (לדוג' Ctrl + A)
    public static void pressCombination(WebElement element, Keys modifierKey, Keys key) {
        actions.moveToElement(element).keyDown(modifierKey).sendKeys(key).keyUp(modifierKey).perform();
    }

    // פונקציה להקלדת טקסט בתוך אלמנט
    public static void typeText(WebElement element, String text) {
        actions.moveToElement(element).sendKeys(text).perform();
    }

    // פונקציה להקלדת טקסט עם שילוב מקשים (למשל, שליחת טקסט ואחריו לחיצה על "Enter")
    public static void typeTextWithEnter(WebElement element, String text) {
        actions.moveToElement(element).sendKeys(text).sendKeys(Keys.ENTER).perform();
    }

    // פונקציה להקשה על מקש "Enter"
    public static void pressEnter(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.ENTER).perform();
    }

    // פונקציה להקשה על מקש "Tab"
    public static void pressTab(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.TAB).perform();
    }

    // פונקציה להקשה על מקש "Escape"
    public static void pressEscape(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.ESCAPE).perform();
    }

    // פונקציה להקשה על מקש "Backspace"
    public static void pressBackspace(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.BACK_SPACE).perform();
    }

    // פונקציה להקשה על מקש "Arrow Down"
    public static void pressArrowDown(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.ARROW_DOWN).perform();
    }

    // פונקציה להקשה על מקש "Arrow Up"
    public static void pressArrowUp(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.ARROW_UP).perform();
    }

    // פונקציה להקשה על מקש "Arrow Right"
    public static void pressArrowRight(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    // פונקציה להקשה על מקש "Arrow Left"
    public static void pressArrowLeft(WebElement element) {
        actions.moveToElement(element).sendKeys(Keys.ARROW_LEFT).perform();
    }
}
