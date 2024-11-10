package TestTesting;

import Utils.ConsolePrinter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestWatcherHandle implements TestWatcher
{

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test disabled: " + context.getDisplayName() +
                (reason.isPresent() ? " - Reason: " + reason.get() : ""));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        ConsolePrinter.printTestResult(context.getDisplayName(), true);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Test aborted: " + context.getDisplayName() + " - " + cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        // קריאה למתודה להדפסת תוצאת הטסט, עם False כי הטסט נכשל
        ConsolePrinter.printTestResult(context.getDisplayName(), false);
        // קריאה להדפסת השגיאה
        if (cause instanceof Exception) {
            ConsolePrinter.printException((Exception) cause);
        }
    }

}
