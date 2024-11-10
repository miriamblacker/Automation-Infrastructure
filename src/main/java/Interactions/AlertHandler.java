package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandler {

    private static WebDriver driver;

    // אתחול המחלקה עם דרייבר מהניהול
    public static void initialize(DriverManagement driverManagement) {
        driver = driverManagement.getDriver();
    }

    // קבלת המופע של Alert הנוכחי
    private static Alert getAlert() {
        return driver.switchTo().alert();
    }

    // קבלת הטקסט של ה-Alert
    public static String getAlertText() {
        return getAlert().getText();
    }

    // אישור ה-Alert (לחיצה על OK)
    public static void acceptAlert() {
        getAlert().accept();
    }

    // דחיית ה-Alert (לחיצה על Cancel)
    public static void dismissAlert() {
        getAlert().dismiss();
    }

    // הכנסת טקסט ל-Alert מסוג Prompt
    public static void sendTextToAlert(String text) {
        getAlert().sendKeys(text);
    }

    // בדיקה אם ה-Alert קיים
    public static boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
