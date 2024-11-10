package Driver;

import Interactions.*;
import Utils.ElementFinder;

public class DriverSetup {

    public static DriverManagement setup(String browser) {
        switch (browser) {
            case "chrome":
                return new ChromeDriverManager();
            case "edge":
                return new EdgeDriverManager();
            case "firefox":
                return new FirefoxDriverManager();
            default:
                System.out.println("Unsupported browser: " + browser);
                return null;
        }
    }

    public static void setupInteractions(DriverManagement driverManagement){
        ElementFinder.initialize(driverManagement);
        ClickActions.initialize(driverManagement);
        NavigationHandler.initialize(driverManagement);
        AlertHandler.initialize(driverManagement);
        DropdownHandler.initialize(driverManagement);
        FrameHandler.initialize(driverManagement);
        KeyboardActions.initialize(driverManagement);
        MouseActions.initialize(driverManagement);
        TableHandler.initialize(driverManagement);
        WindowHandler.initialize(driverManagement);
    }
}
