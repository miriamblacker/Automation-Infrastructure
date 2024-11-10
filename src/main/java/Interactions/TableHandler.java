package Interactions;

import Driver.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableHandler {

    private static WebDriver driver;

    // אתחול המחלקה עם Driver מהניהול
    public static void initialize(DriverManagement driverManagement) {
        driver = driverManagement.getDriver();
    }

    // פונקציה לקבלת אלמנט של הטבלה לפי Locator
    private static WebElement getTableElement(By locator) {
        return driver.findElement(locator);
    }

    // פונקציה שמחזירה את כל השורות בטבלה
    public static List<WebElement> getRows(By tableLocator) {
        WebElement table = getTableElement(tableLocator);
        return table.findElements(By.tagName("tr"));
    }

    // פונקציה שמחזירה את כל העמודות בשורה נתונה
    public static List<WebElement> getColumns(By tableLocator, int rowIndex) {
        List<WebElement> rows = getRows(tableLocator);
        WebElement row = rows.get(rowIndex);
        return row.findElements(By.tagName("td"));
    }

    // פונקציה לקריאת ערך מסוים בתא בטבלה לפי אינדקס שורה ועמודה
    public static String getCellValue(By tableLocator, int rowIndex, int columnIndex) {
        List<WebElement> rows = getRows(tableLocator);
        WebElement row = rows.get(rowIndex);
        List<WebElement> columns = row.findElements(By.tagName("td"));
        return columns.get(columnIndex).getText();
    }

    // פונקציה שמחזירה את כל הערכים בעמודה מסוימת לפי אינדקס העמודה
    public static List<String> getColumnValues(By tableLocator, int columnIndex) {
        List<WebElement> rows = getRows(tableLocator);
        List<String> columnValues = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() > columnIndex) {
                columnValues.add(columns.get(columnIndex).getText());
            }
        }

        return columnValues;
    }

    // פונקציה שתבדוק אם ערך מסוים קיים בטבלה
    public static boolean isValueInTable(By tableLocator, String value) {
        List<WebElement> rows = getRows(tableLocator);
        for (WebElement row : rows) {
            if (row.getText().contains(value)) {
                return true;
            }
        }
        return false;
    }

    // פונקציה לשינוי ערך בתא בטבלה
    public static void editCellValue(By tableLocator, int rowIndex, int columnIndex, String newValue) {
        List<WebElement> rows = getRows(tableLocator);
        WebElement row = rows.get(rowIndex);
        List<WebElement> columns = row.findElements(By.tagName("td"));
        WebElement cell = columns.get(columnIndex);
        cell.clear(); // מנקה את הערך הקיים
        cell.sendKeys(newValue); // מכניס את הערך החדש
    }

    // פונקציה להדפיס את כל ערכי הטבלה (שורות ועמודות)
    public static void printTableValues(By tableLocator) {
        List<WebElement> rows = getRows(tableLocator);
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            columns.forEach(column -> System.out.print(column.getText() + "\t"));
            System.out.println();
        }
    }
}
