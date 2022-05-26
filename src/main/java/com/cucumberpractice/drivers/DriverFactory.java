package com.cucumberpractice.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (webDriver.get() == null)
            webDriver.set(createDriver());
        return webDriver.get();

    }

    private static WebDriver createDriver() {

        WebDriver driver = null;

        switch (getBreowserType()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                option.addArguments("--headless");
                //driver = new ChromeDriver(option);
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), option);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffoption = new FirefoxOptions();
                ffoption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                ffoption.addArguments("--headless");
                driver = new FirefoxDriver(ffoption);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eoption = new EdgeOptions();
                eoption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                eoption.addArguments("--headless");
                driver = new EdgeDriver(eoption);
                break;

        }
        driver.manage().window().maximize();
        return driver;

    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    private static String getBreowserType() {
        String browserTyep = "chrome";
        try {
            Path currentRelativePath = Path.of("");
            String location = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current absolute path is: " + location);


            Path path = Path.of(location + "//src//main//java//com//cucumberpractice//properties//config.properties");
            InputStream fileInputStream = Files.newInputStream(path);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            browserTyep = properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return browserTyep;

    }

}
