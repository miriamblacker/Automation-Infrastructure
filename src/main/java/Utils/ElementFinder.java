package Utils;

import Driver.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFinder {

    private static WebDriver driver;
    private static Waiting waiting;

    // אתחול המחלקה - חובה לקרוא למתודה זו פעם אחת לפני שימוש במתודות סטטיות אחרות
    public static void initialize(DriverManagement driverManagement) {
        driver = driverManagement.getDriver();
        waiting = new Waiting(driverManagement, 10); // מגדירים המתנה עם timeout של 10 שניות
    }

    // פונקציה שמקבלת Locator (By) ומחזירה את האלמנט לאחר המתנה לגלוי
    public static WebElement fetchElement(By locator) {
        // מחכים עד שהאלמנט יהיה גלוי
        waiting.waitForVisibility(driver.findElement(locator));

        // מחזירים את האלמנט
        return driver.findElement(locator);
    }
}
