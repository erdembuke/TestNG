package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_PlaceOrderPOM extends BaseDriver {
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
        _03_PlaceOrderPOM_Elements elements = new _03_PlaceOrderPOM_Elements();

        elements.search.sendKeys("ipod");
        elements.searchClick.click();
        elements.firstItem.click();
        elements.shoppingCart.click();
        elements.checkout.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn3)).click();
        elements.agreeTerm.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn4)).click();
        elements.confirmOrder.click();

        Assert.assertTrue(elements.display.isDisplayed());





    }
}
