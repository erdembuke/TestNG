package Gun06;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_PlaceOrder extends BaseDriver {
    /*
    Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
     */

    @Test
    void Test1() {
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("ipod");

        WebElement searchClick = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchClick.click();

        WebElement firstItem = driver.findElement(
                By.xpath("(//button[@type='button']/span[@class='hidden-xs hidden-sm hidden-md'])[1]"));
        firstItem.click();

        WebElement shoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));
        shoppingCart.click();

        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkout")));
        checkout.click();

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("button-payment-address")));
        continueBtn.click();

        WebElement continueBtn2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("button-shipping-address")));
        continueBtn2.click();

        WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("comment")));
        comment.sendKeys("Please send fast");

        WebElement continueBtn3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("button-shipping-method")));
        continueBtn3.click();

        WebElement payMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@name='payment_method'])[2]")));
        payMethod.click();

        WebElement agreeTerm = driver.findElement(By.name("agree"));
        agreeTerm.click();

        WebElement continueBtn4 = driver.findElement(By.id("button-payment-method"));
        continueBtn4.click();

        WebElement confirmOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        confirmOrder.click();

        WebElement display = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));

        Assert.assertTrue(display.isDisplayed());





    }
}
