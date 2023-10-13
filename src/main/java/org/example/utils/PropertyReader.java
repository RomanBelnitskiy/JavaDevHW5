package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream is = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (is == null) {
                System.out.println("Can't find application.properties file");
            }

            PROPERTIES.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getConnectionUrlForH2() {
        return new StringBuilder("jdbc:")
                .append(PROPERTIES.getProperty("h2.db.host"))
                .append(":./")
                .append(PROPERTIES.getProperty("h2.db.database"))
                .toString();
    }
}
