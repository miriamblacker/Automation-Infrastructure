package Driver;

import FileHandling.PropertiesReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManagement {

    protected WebDriver driver;
    protected String url = PropertiesReader.getInstance().getProperty("url");
    protected String version =PropertiesReader.getInstance().getProperty("version");

    abstract void initDriver();

    public WebDriver getDriver() {
        return driver;
    }

    void initial() {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDown() {
        driver.quit();
    }
}
