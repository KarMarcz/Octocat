package pl.github.utils;

import java.util.Properties;

public class PropertiesProvider {
    private PropertiesCreator propertiesCreator = new PropertiesCreator();
    /**
     * Method linking JVM properties with Server.properties to for example mza settings (for running single tests)
     */
    public void setSystemProperties(String path){
        Properties properties = new Properties();
        properties.putAll(System.getProperties());
        properties.putAll(propertiesCreator.propertiesCreator(path));
        System.setProperties(properties);
    }
}
