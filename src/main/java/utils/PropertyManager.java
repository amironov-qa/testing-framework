package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    public static Properties properties;

    static {
        properties = new Properties();
        try (InputStream propertyFile = new FileInputStream("src/main/resources/app.properties")) {
            properties.load(propertyFile);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Cannot find property file! ");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
