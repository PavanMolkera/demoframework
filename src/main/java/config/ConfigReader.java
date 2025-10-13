//package config;
//
//public class ConfigReader {
//
//}


//package config;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class ConfigReader {
//    private static Properties properties;
//
//    static {
//        try {
//            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
//            properties = new Properties();
//            properties.load(file);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
//        }
//    }
//
//    public static String getProperty(String key) {
//        return properties.getProperty(key);
//    }
//}











package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found in resources folder");
            }
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

