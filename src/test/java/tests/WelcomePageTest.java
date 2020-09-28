package tests;

import framework.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomePageTest extends BaseTestClass {

    @Test
    public void clickOnClinicalService() {
        getWelcomePage().clickClinicalService();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getLoginPage().getLoginText().toLowerCase());
        Assert.assertEquals(getLoginPage().getLoginText().toLowerCase(),"login");
    }
}
