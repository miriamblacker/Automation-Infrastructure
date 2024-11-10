package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManagement{

    public FirefoxDriverManager() {
        initDriver();
        initial();
    }

    public FirefoxDriverManager(String url) {
        this.url = url;
    }

    public FirefoxDriverManager(String url, String version) {
        this.url = url;
        this.version = version;
    }

    @Override
    void initDriver() {
        if (version == null) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            WebDriverManager.firefoxdriver().driverVersion(version).setup();
        }
        driver = new FirefoxDriver();
    }

}
