package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandler {

    private static WebDriver driver;

    // אתחול המחלקה עם Driver מהניהול
    public static void initialize(DriverManagement driverManagement) {
        driver = driverManagement.getDriver();
    }

    // פונקציה למעבר ל-frame לפי שם או ID
    public static void switchToFrameById(String frameIdentifier) {
        driver.switchTo().frame(frameIdentifier);
    }

    // פונקציה למעבר ל-frame לפי WebElement
    public static void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // פונקציה למעבר מה-frame חזרה לדף הראשי (Main Content)
    public static void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    // פונקציה למעבר בין אם יש מספר frames (לפי אינדקס)
    public static void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    // פונקציה למעבר בין frames על פי אינדקסים, תומך במעבר לכמה frames ברצף
    public static void switchToNestedFrames(int[] frameIndexes) {
        for (int frameIndex : frameIndexes) {
            driver.switchTo().frame(frameIndex);
        }
    }
}
