package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContactUs extends BaseDriver {
    /*
        ContactUs a tiklayiniz
        Mesaj kutusuna en az 10 karakterlik bir mesaj yaziniz
        Submit ettikten sonra Contact US yazisini dogrulayiniz
    */

    @Test
    @Parameters("mesaj")
    void test10(String gelenMesaj){
        // String gelenMesaj : metod icin gerekli tanimlama ayni olmak zorunda degil
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement contactLink = driver.findElement(By.linkText("Contact Us"));
        js.executeScript("arguments[0].scrollIntoView(true);" , contactLink);
        contactLink.click();

        WebElement msgBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-enquiry")));
        msgBox.sendKeys(gelenMesaj);

        WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitBtn.click();

        WebElement display = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));
        Assert.assertEquals(display.getText(), "Contact Us");


    }

}
