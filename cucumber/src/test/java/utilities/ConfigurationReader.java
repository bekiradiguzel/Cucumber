package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    static Properties properties;

    public ConfigurationReader() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    static {
        String path = "configuration.properties";
        FileInputStream file = null;

        try {
            file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }
}
