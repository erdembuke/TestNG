package Gun07;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*

    Senaryo ;
    1- Siteye gidiniz..

    1.Test;
    2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
    3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
    4- Daha sonra WishList e tıklatınız
    5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

*/
public class _01_WishList extends BaseDriverParameter {

    @Test
    @Parameters("searchText")
    void wishListTest(String text) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(text);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> products = driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
        int rndSayi = MyFunc.randomGenerator(products.size());

        String choosenProduct = products.get(rndSayi).getText();
        System.out.println(choosenProduct);

        products.get(rndSayi).click();

        WebElement wishList = driver.findElement(By.linkText("wish list"));
        wishList.click();

        List<WebElement> wishProducts = driver.findElements(By.cssSelector("[class='text-left']>a"));

        MyFunc.listContainsString(wishProducts,choosenProduct);
    }
}
