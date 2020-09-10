package webpages;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

    private Properties properties = new Properties();
    private final String propertyFile = "configs//config.properties";

    public Properties getProperties() {
        try {
            FileInputStream fileInput = new FileInputStream(propertyFile);
            properties.load(fileInput);
        } catch(Exception e) {
            System.out.println("Error while reading properties file");
            e.printStackTrace();
        }
        return this.properties;
    }

}
