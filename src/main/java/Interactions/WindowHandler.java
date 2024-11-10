package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandler {

    private static WebDriver driver;

    // אתחול המחלקה עם DriverManagement
    public static void initialize(DriverManagement driverManagement) {
        driver = driverManagement.getDriver();
    }

    // מעבר לחלון לפי שם או מזהה חלון
    public static void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    // מעבר לחלון לפי כותרת החלון
    public static boolean switchToWindowByTitle(String title) {
        for (String handle : driver.getWindowHandles()) {
            switchToWindow(handle);
            if (driver.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    // מעבר לחלון החדש שנפתח
    public static void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentWindow)) {
                switchToWindow(handle);
                break;
            }
        }
    }

    // סגירת החלון הנוכחי
    public static void closeCurrentWindow() {
        driver.close();
    }

    // מעבר לחלון הראשי (חלון הדפדפן הראשון שנפתח)
    public static void switchToMainWindow() {
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        switchToWindow(mainWindowHandle);
    }

    // פונקציה להחזרת מספר חלונות פתוחים
    public static int getWindowCount() {
        return driver.getWindowHandles().size();
    }

    // פונקציה לסגירת כל החלונות חוץ מהחלון הראשי
    public static void closeAllWindowsExceptMain() {
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                switchToWindow(handle);
                closeCurrentWindow();
            }
        }
        switchToMainWindow();
    }

    // פונקציה לסגירת כל החלונות הפתוחים
    public static void closeAllWindows() {
        for (String handle : driver.getWindowHandles()) {
            switchToWindow(handle);
            closeCurrentWindow();
        }
    }
}
