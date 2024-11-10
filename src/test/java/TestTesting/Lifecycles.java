package TestTesting;

import Driver.DriverManagement;
import Driver.DriverSetup;
import FileHandling.PropertiesReader;
import org.junit.jupiter.api.extension.*;

public class Lifecycles implements BeforeAllCallback, BeforeEachCallback, AfterAllCallback, AfterEachCallback {

    protected static DriverManagement driverManagement;

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        if (driverManagement != null) {
            driverManagement.tearDown();
        }
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        driverManagement = DriverSetup.setup(PropertiesReader.getInstance().getProperty("browser").toLowerCase());
        DriverSetup.setupInteractions(driverManagement);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
//        driverManagement = DriverSetup.setup(PropertiesReader.getInstance().getProperty("browser").toLowerCase());
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {

    }
}
