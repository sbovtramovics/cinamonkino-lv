package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static String loadSiteProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream filePath = null;
        String filePathString = "src" + File.separator + "test" +
                File.separator + "resources" + File.separator + "config.properties";

        filePath = new FileInputStream(filePathString);
        properties.load(filePath);
        filePath.close();

        return properties.getProperty(key);
    }

}
