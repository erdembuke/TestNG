package Gun07;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishListElements{

    public _02_WishListElements() {
        PageFactory.initElements(BaseDriver.driver , this);
    }

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    public List<WebElement> searchResultsIpod;

    @FindBy(css = "[class='text-left']>a")
    public List<WebElement> wishListItems;

    @FindBy(linkText = "wish list")
    public WebElement wishListButton;
}
