package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManagement {

    public ChromeDriverManager() {
        initDriver();
        initial();
    }

    @Override
    void initDriver() {
        if (version == null) {
            WebDriverManager.chromedriver().setup();
        } else {
            WebDriverManager.chromedriver().driverVersion(version).setup();
        }
        driver = new ChromeDriver();
    }
}
