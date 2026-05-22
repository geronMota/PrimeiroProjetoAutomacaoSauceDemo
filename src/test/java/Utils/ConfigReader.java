package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();


    static {
        String filePath = "src/main/resources/config.properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            System.out.println("config.properties carregado com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar config.properties: " + e.getMessage());
        }
    }

    // Métodos simples para pegar valores
    public static String getAppUrl() {
        return properties.getProperty("site.url");
    }

    public static String getUsername() {
        return properties.getProperty("site.username");
    }

    public static String getPassword() {
        return properties.getProperty("site.password");
    }

    public static String getBrowser() {
        return properties.getProperty("site.browser");
    }

    public static long getImplicitWait() {
        return Long.parseLong(properties.getProperty("site.implicit-wait"));
    }
    public static long getPageLoadTimeout() {
        return Long.parseLong(properties.getProperty("site.page-load-timeout"));
    }
}

