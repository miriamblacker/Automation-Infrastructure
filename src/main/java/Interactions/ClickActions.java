package Interactions;

import Driver.DriverManagement;
import Utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickActions {

    private static Actions actions;
    private static Waiting waiting;

    // אתחול המחלקה - חובה לקרוא למתודה זו פעם אחת לפני שימוש במתודות סטטיות אחרות
    public static void initialize(DriverManagement driverManagement) {
        actions = new Actions(driverManagement.getDriver());
        waiting = new Waiting(driverManagement, 10);
    }

    // לחיצה רגילה
    public static void click(WebElement element) {
        waiting.waitForVisibility(element); // המתנה שהאלמנט יהיה גלוי
        actions.click(element).perform();
    }

    // לחיצה כפולה
    public static void doubleClick(WebElement element) {
        waiting.waitForVisibility(element); // המתנה שהאלמנט יהיה גלוי
        actions.doubleClick(element).perform();
    }

    // לחיצה ימנית (context click)
    public static void rightClick(WebElement element) {
        waiting.waitForVisibility(element); // המתנה שהאלמנט יהיה גלוי
        actions.contextClick(element).perform();
    }

    // גרירה ושחרור של אלמנט
    public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        waiting.waitForVisibility(sourceElement); // המתנה שהאלמנט המקורי יהיה גלוי
        waiting.waitForVisibility(targetElement); // המתנה שהיעד יהיה גלוי
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }
}
