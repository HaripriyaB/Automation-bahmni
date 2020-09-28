package pages;

import framework.PageFactory;
import org.openqa.selenium.By;

public class LoginPage extends PageFactory {
    private final By loginText = By.cssSelector(".left");

    public String getLoginText() {
        return driver.findElement(loginText).getText();
    }
}