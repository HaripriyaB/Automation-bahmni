package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public abstract class Driver {

    protected static WebDriver driver;

    public static WebDriver getInstanceOfDriver(String browser) {
        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }
        return driver;
    }

    public static WebDriver getInstanceOfHeadLessDriver(String browser) {
        if (browser.equalsIgnoreCase("headlessChrome")) {
            ChromeOptions option = new ChromeOptions();
            option.setHeadless(true);
            driver = new ChromeDriver(option);
        } else if (browser.equalsIgnoreCase("headlessFirefox")){
            FirefoxOptions option = new FirefoxOptions();
            option.setHeadless(true);
            driver = new FirefoxDriver(option);
        }
        return driver;
    }
}