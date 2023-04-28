package Gun07;

import Gun06._03_PlaceOrderPOM_Elements;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_WishListPOM extends BaseDriver {

    @Test
    @Parameters("searchText")
    void addWishList(String text) {

        _03_PlaceOrderPOM_Elements poe = new _03_PlaceOrderPOM_Elements();
        _02_WishListElements poe2 = new _02_WishListElements();

        poe.search.sendKeys(text);
        poe.searchClick.click();

        int rndSayi = MyFunc.randomGenerator(poe2.searchResultsIpod.size());

        String choosenProduct = poe2.searchResultsIpod.get(rndSayi).getText();
        System.out.println(choosenProduct);

        poe2.searchResultsIpod.get(rndSayi).click();
        poe2.wishListButton.click();

        MyFunc.listContainsString(poe2.wishListItems,choosenProduct);
    }
}
