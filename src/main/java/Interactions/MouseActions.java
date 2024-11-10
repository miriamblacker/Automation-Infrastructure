package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

//    private static WebDriver driver;
    private static Actions actions;

    // אתחול המחלקה עם DriverManagement
    public static void initialize(DriverManagement driverManagement) {
//        driver = driverManagement.getDriver();  // מקבלים את ה-Driver מ-DriverManagement
        actions = new Actions(driverManagement.getDriver());  // אתחול של Actions רק פעם אחת
    }

    // פונקציה לגרירה והפלה של אלמנט (Drag and Drop by offset)
    public static void dragAndDropByOffset(WebElement element, int xOffset, int yOffset) {
        actions.dragAndDropBy(element, xOffset, yOffset).perform();
    }

    // פונקציה להזזת העכבר לאלמנט (Mouse Hover)
    public static void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // פונקציה להחזקת מקש (Hold) בעכבר על אלמנט
    public static void holdMouseOverElement(WebElement element) {
        actions.moveToElement(element).clickAndHold().perform();
    }

    // פונקציה לשחרור מקש בעכבר לאחר החזקה (Release)
    public static void releaseMouse(WebElement element) {
        actions.moveToElement(element).release().perform();
    }

    // פונקציה לגרירה ושחרור (Click and Hold, then Release)
    public static void clickAndHoldThenRelease(WebElement source, WebElement target) {
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
    }

    // פונקציה לגרירה של אלמנט (Drag) לפוקנציה חדשה (ללא שחרור)
    public static void clickAndHold(WebElement element) {
        actions.moveToElement(element).clickAndHold().perform();
    }

    // פונקציה להזזת עכבר לפינה מסוימת על המסך (לא אלמנט, אלא קואורדינטות)
    public static void moveToCoordinate(int x, int y) {
        actions.moveByOffset(x, y).perform();
    }
}
