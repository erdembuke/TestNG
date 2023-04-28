package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_PlaceOrderPOM_Elements {
    // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve için PageFatory ile
    // driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
    // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.
    public _03_PlaceOrderPOM_Elements() {
        PageFactory.initElements(BaseDriver.driver , this);
        // driver.findElement i hepsi icin yapiyor.
    }

    @FindBy(name = "search")
    public WebElement search;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public WebElement searchClick;

    @FindBy(xpath = "(//button[@type='button']/span[@class='hidden-xs hidden-sm hidden-md'])[1]")
    public WebElement firstItem;

    @FindBy(linkText = "shopping cart")
    public WebElement shoppingCart;

    @FindBy(linkText = "Checkout")
    public WebElement checkout;

    @FindBy(id = "button-payment-address")
    public WebElement continueBtn;

    @FindBy(id = "button-shipping-address")
    public WebElement continueBtn2;

    @FindBy(id = "button-shipping-method")
    public WebElement continueBtn3;

    @FindBy(name = "agree")
    public WebElement agreeTerm;

    @FindBy(id = "button-payment-method")
    public WebElement continueBtn4;

    @FindBy(id = "button-confirm")
    public WebElement confirmOrder;

    @FindBy(xpath = "//div[@id='content']/h1")
    public WebElement display;


}
