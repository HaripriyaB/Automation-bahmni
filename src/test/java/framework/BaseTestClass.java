package framework;

import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static framework.ConfigureProperties.*;

public class BaseTestClass extends PageFactory {

    WebDriver baseDriver;

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) {
        try {
            baseDriver = Driver.getInstanceOfDriver(browser);
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, browser + " driver initialised");

            baseDriver.manage().window().maximize();

            PageFactory.instantiatePages();
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, browser + "pages instantiated");

            readProperties();
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, "read config properties");

            setUrlToDriver();
            LoggerClass.showLog(BaseTestClass.class, Level.INFO, "URL set to" + " driver");

        } catch (Exception e) {
            LoggerClass.showLog(BaseTestClass.class, Level.WARN, "Exception: " + e.getMessage());
        }
    }

    private void setUrlToDriver() {
        String message = "Configuring url to driver";
        LoggerClass.showLog(BaseTestClass.class, Level.INFO, message);
        baseDriver.get(ConfigureProperties.local_URL);
        LoggerClass.showLog(BaseTestClass.class, Level.INFO, message);
    }

    @AfterMethod
    public void screenshot(ITestResult result) {
        String screenshotName = "Screenshot " + result.getMethod().getMethodName() + " " + java.util.Calendar.getInstance().getTime();
        try {
            if (ITestResult.FAILURE == result.getStatus()) {
                TakeSnapShot.captureScreenshot(screenshotName);
                LoggerClass.showLog(BaseTestClass.class, Level.INFO, "captured Screenshot");
            }
        } catch (Exception e) {
            LoggerClass.showLog(BaseTestClass.class, Level.WARN, "Exception: " + e.getMessage());
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        baseDriver.quit();
    }
}