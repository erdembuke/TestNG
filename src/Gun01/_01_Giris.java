package Gun01;
/*
Selenium WebDriver -> WebDriver
testNG             -> Organizator
 */

import org.testng.annotations.Test;

public class _01_Giris {

    // Herhangi bir siralama tanimlanmazsa testleri alfabetik olarak sirayla calistirir
    @Test(priority = 1)
    public void openWebSite() {
        System.out.println("driver tanimlandi ve website acildi");
    }

    @Test(priority = 2)
    public void doLogin() {
        System.out.println("Login test yapildi");
    }

    @Test(priority = 3)
    public void closeDriver() {
        System.out.println("driver kapatildi");
    }
}
