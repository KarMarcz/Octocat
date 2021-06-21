package pl.github.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesCreator {
    public Properties propertiesCreator(String path) {
        Properties prop;
        prop = new Properties();
        try {
            FileInputStream input = new FileInputStream(new File(path));
            prop.load(new InputStreamReader(input));
            return prop;
        } catch (IOException e) {
            //normally log via log4j2
            e.getMessage();
        }
        return prop;
    }
}
