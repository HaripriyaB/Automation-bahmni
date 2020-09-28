package framework;

import pages.HomePage;
import pages.LoginPage;
import pages.WelcomePage;

public class PageFactory extends Driver {


    private static WelcomePage welcomePage;
    private static LoginPage loginPage;
    private static HomePage homePage;

    public static WelcomePage getWelcomePage() {
        return welcomePage;
    }

    public static HomePage getHomePage() {
        return homePage;
    }

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static void instantiatePages() {
        loginPage = new LoginPage();
        welcomePage = new WelcomePage();
        homePage = new HomePage();
    }
}