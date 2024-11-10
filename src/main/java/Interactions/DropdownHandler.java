package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandler {

    private static WebDriver driver;

    // אתחול המחלקה עם Driver מהניהול
    public static void initialize(DriverManagement driverManagement) {
        driver = driverManagement.getDriver();
    }

    // פונקציה שמחזירה את אלמנט ה-Dropdown על פי Locator
    private static WebElement getDropdownElement(By locator) {
        return driver.findElement(locator);
    }

    // פונקציה לבחירת ערך מתוך Dropdown על פי טקסט
    public static void selectByVisibleText(By locator, String text) {
        Select dropdown = new Select(getDropdownElement(locator));
        dropdown.selectByVisibleText(text);
    }

    // פונקציה לבחירת ערך מתוך Dropdown על פי ערך (value)
    public static void selectByValue(By locator, String value) {
        Select dropdown = new Select(getDropdownElement(locator));
        dropdown.selectByValue(value);
    }

    // פונקציה לבחירת ערך מתוך Dropdown על פי Index
    public static void selectByIndex(By locator, int index) {
        Select dropdown = new Select(getDropdownElement(locator));
        dropdown.selectByIndex(index);
    }

    // פונקציה לבדיקת אם ה-Dropdown הוא multiple (רבים)
    public static boolean isMultiple(By locator) {
        Select dropdown = new Select(getDropdownElement(locator));
        return dropdown.isMultiple();
    }

    // פונקציה לקבלת כל האפשרויות מתוך ה-Dropdown
    public static void printAllOptions(By locator) {
        Select dropdown = new Select(getDropdownElement(locator));
        dropdown.getOptions().forEach(option -> System.out.println(option.getText()));
    }

    // פונקציה לבחירת ערך שנבחר כבר ב-Dropdown
    public static String getSelectedOption(By locator) {
        Select dropdown = new Select(getDropdownElement(locator));
        return dropdown.getFirstSelectedOption().getText();
    }
}
