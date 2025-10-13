//package config;
//
//public class Constants {
//
//}


package config;

public class Constants {
    public static final String URL = ConfigReader.getProperty("url");
    public static final String BROWSER = ConfigReader.getProperty("browser");
    public static final int IMPLICIT_WAIT = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
}
