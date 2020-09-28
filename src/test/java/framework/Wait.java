package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait extends Driver {

    public static void setImplicitWait(int implicitWaitInSeconds) {
        driver.manage().timeouts().implicitlyWait(implicitWaitInSeconds, TimeUnit.SECONDS);
    }

    public static void explicitWait(Function<WebDriver, WebElement> condition) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(condition);
    }
}