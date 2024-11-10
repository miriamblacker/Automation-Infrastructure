//package FileHandling;
//
//import Utils.ConsolePrinter;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class PropertiesReader {
//
//    private static Properties properties;
//
//    public PropertiesReader(String filePath) {
//        properties = new Properties();
//        try (FileInputStream inputStream = new FileInputStream(filePath)) {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            ConsolePrinter.printException(e);
//        }
//    }
//
//    public static String getProperty(String key) {
//        return properties.getProperty(key);
//    }
//}

package FileHandling;

import Utils.ConsolePrinter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader instance; // מופע סינגלטון
    private static Properties properties = new Properties();
    private static final String FILE_PATH = "src/main/resources/config.properties";

    // קונסטרקטור פרטי כדי למנוע יצירה מחוץ למחלקה
    private PropertiesReader() {
        try (FileInputStream inputStream = new FileInputStream(FILE_PATH)) {
            properties.load(inputStream);
        } catch (IOException e) {
            ConsolePrinter.printException(e);
        }
    }

    // מתודה לגישה למופע הסינגלטון
    public static PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    // מתודה סטטית לגישה לפרופרטיס
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

