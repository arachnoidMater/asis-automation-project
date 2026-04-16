package core;

import java.io.InputStream;
import java.util.Properties;

public class BaseConfiguration {

    private final Properties props = new Properties();

    public BaseConfiguration() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("base.properties")) {
            if (is == null) {
                throw new RuntimeException("base.properties bulunamadi. src/test/resources altinda oldugundan emin ol.");
            }
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("base.properties okunamadi: " + e.getMessage(), e);
        }
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }
}