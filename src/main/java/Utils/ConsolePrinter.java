//package Utils;
//
//public class ConsolePrinter {
//    public static void printException(Exception e) {
//        System.out.println("[EXCEPTION]: " + e.getClass().getName() + " - " + e.getMessage());
//        e.printStackTrace(System.out);
//    }
//
//    // מדפיס תשובת טסט
//    public static void printTestResult(String testName, boolean isSuccess) {
//        String status = isSuccess ? "PASSED" : "FAILED";
//        System.out.println("[TEST RESULT]: " + testName + " - " + status);
//
//        // צילום מסך במקרה של כשל בטסט
//        if (!isSuccess) {
//                Screenshots.takeScreenshot(testName + "_failure.png");
//                System.out.println("[SCREENSHOT]: Screenshot saved as '" + testName + "_failure.png'");
//        }
//    }
//
//}

package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ConsolePrinter {
    private static final String LOG_FILE = "test_log.txt";

    private static void logToFile(String message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(message);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static void printException(Exception e) {
        String message = "[EXCEPTION]: " + e.getClass().getName() + " - " + e.getMessage();
        logToFile(message);
        for (StackTraceElement element : e.getStackTrace()) {
            logToFile("\tat " + element.toString());
        }
    }

    public static void printTestResult(String testName, boolean isSuccess) {
        String status = isSuccess ? "PASSED" : "FAILED";
        String resultMessage = "[TEST RESULT]: " + testName + " - " + status;
        logToFile(resultMessage);

        if (!isSuccess) {
            String screenshotName = testName + "_failure.png";
            Screenshots.takeScreenshot(screenshotName);
            logToFile("[SCREENSHOT]: Screenshot saved as '" + screenshotName + "'");
        }
    }
}

