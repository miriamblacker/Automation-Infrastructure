package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.WebDriver;

import static FileHandling.PropertiesReader.getInstance;

public class NavigationHandler {

    private static WebDriver driver;

    // אתחול המחלקה עם דרייבר מהניהול
    public static void initialize(DriverManagement driverManagement) {
        driver = driverManagement.getDriver();
    }

    // מעבר לדף לפי URL
    public static void navigateToUrl() {
        driver.navigate().to(getInstance().getProperty("url"));
    }

    public static void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    // רענון הדף הנוכחי
    public static void refreshPage() {
        driver.navigate().refresh();
    }

    // מעבר לדף הקודם
    public static void goBack() {
        driver.navigate().back();
    }

    // מעבר לדף הבא בהיסטוריה
    public static void goForward() {
        driver.navigate().forward();
    }

    // קבלת ה-URL הנוכחי
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // קבלת כותרת הדף הנוכחי
    public static String getPageTitle() {
        return driver.getTitle();
    }
}
