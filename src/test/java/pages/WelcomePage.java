package pages;

import framework.PageFactory;
import framework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WelcomePage extends PageFactory {
    private final By clinicalService = By.className("launch");

    public void clickClinicalService(){
//        Wait.explicitWait(ExpectedConditions.presenceOfElementLocated(clinicalService));
        driver.findElement(clinicalService).click();
    }
}