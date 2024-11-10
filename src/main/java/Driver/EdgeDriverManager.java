package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManagement{

    public EdgeDriverManager() {
        initDriver();
        initial();
    }

//    public EdgeDriverManager(String url) {
//        this.url = url;
//    }
//
//    public EdgeDriverManager(String url, String version) {
//        this.url = url;
//        this.version = version;
//    }

    @Override
    void initDriver() {
        if (version == null) {
            WebDriverManager.edgedriver().setup();
        } else {
            WebDriverManager.edgedriver().driverVersion(version).setup();
        }
        driver = new EdgeDriver();
    }
}
