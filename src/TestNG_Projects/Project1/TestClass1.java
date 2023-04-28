package TestNG_Projects.Project1;

import Utility.BaseDriverProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClass1 extends BaseDriverProject {

    @Test(priority = 1)
    @Parameters("browser")
    void Test1() {
        /*
            ➢ https://demo.nopcommerce.com/register?returnUrl=%2F Sitesine gidiniz
            ➢ Register butonuna tıklayınız
            ➢ First Name ve Last Name giriniz
            ➢ Doğum tarihi kısımlarını select ile seciniz
            ➢ Email giriniz
            ➢ Password ve password confirm giriniz
            ➢ Register butonuna tıklayınız
            ➢ Başarılı bir şekilde kaydolduğunuzu doğrulayınız
        */

        WebElement registerBtn = driver.findElement(By.linkText("Register"));
        registerBtn.click();

        WebElement maleBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gender-male")));
        maleBox.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Erdem");

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Buke");

        WebElement daySelect = driver.findElement(By.name("DateOfBirthDay"));
        WebElement monthSelect = driver.findElement(By.name("DateOfBirthMonth"));
        WebElement yearSelect = driver.findElement(By.name("DateOfBirthYear"));

        Select day = new Select(daySelect);
        Select month = new Select(monthSelect);
        Select year = new Select(yearSelect);

        day.selectByValue("16");
        month.selectByValue("11");
        year.selectByValue("1999");

        WebElement mailBox = driver.findElement(By.id("Email"));
        mailBox.sendKeys("erdem@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("erdem123");

        WebElement passwordBox2 = driver.findElement(By.id("ConfirmPassword"));
        passwordBox2.sendKeys("erdem123");

        WebElement registerBtn2 = driver.findElement(By.id("register-button"));
        registerBtn2.click();

        WebElement display = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));
        Assert.assertEquals(display.getText(), "Your registration completed");
    }

    @Test(priority = 2)
    @Parameters("browser")
    void Test2() {
        /*
            ➢ Login butonuna tıklayınız
            ➢ Kaydolduğunuz Email ve password giriniz
            ➢ LOG IN butonunna tıklayınız
            ➢ Başarılı bir şekilde login olduğunuzu doğrulayınız.
        */

        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        loginBtn.click();

        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys("erdem@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("erdem123");

        WebElement loginBtn2 = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginBtn2.click();

        WebElement correct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My account")));

        Assert.assertTrue(correct.isDisplayed());

    }

    @Test(dataProvider = "userData", priority = 3)
    @Parameters("browser")
    void Test3(String mail, String password) {
        /*
            ➢ Login butonuna tıklayınız
            ➢ Geçerli ve geçersiz Email ve password’u Data Provider metodundan aliniz
            ➢ LOG IN butonunna tıklayınız
            ➢ başarılı bir şekilde login olup olmadığınızı doğrulayınız.
        */

            WebElement loginBtn = driver.findElement(By.linkText("Log in"));
            loginBtn.click();

            WebElement emailBox = driver.findElement(By.id("Email"));
            emailBox.sendKeys(mail);

            WebElement passwordBox = driver.findElement(By.id("Password"));
            passwordBox.sendKeys(password);

            WebElement loginBtn2 = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
            loginBtn2.click();

            if (mail.equals("erdem1@gmail.com")) {
                WebElement wrongInfo = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class='message-error validation-summary-errors']")));
                Assert.assertTrue(wrongInfo.isDisplayed());

            } else if (mail.equals("erdem@gmail.com")) {
                WebElement correct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My account")));
                Assert.assertTrue(correct.isDisplayed());
            }

        }

        @Test(priority = 4)
        @Parameters("browser")
        void Test4() {
        /*
            ➢ Tab menudeki ürünlerin isimlerini liste atiniz
            ➢ Tab menu listesini locate ediniz
            ➢ Locate ettiginiz listenin elemanlarinin tab menudeki ürünleri içerdiğini doğrulayınız.
        */
            List<WebElement> products = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
            List<String> names = new ArrayList<>();

            for (WebElement abc : products) {
                names.add(abc.getText());
            }

            for (WebElement abd : products) {
                for (String def : names) {
                    if(def.equals(abd.getText())) {
                        Assert.assertEquals(abd.getText(), def);
                        break;
                    }
                }
            }
        }

        @Test(priority = 5)
        @Parameters("browser")
        void Test5() {
        /*
            ➢ Tab menuden gifts’e tıklayınız
            ➢ Physical giftlerden birini random olarak seciniz
            ➢ Açılan sayfada recipient name, sender name ve message bölümlerini doldurunuz
            ➢ Ad To Cart’a tıklayınız
            ➢ Urunun sepete eklendiğini doğrulayınız
        */
            WebElement gift = driver.findElement(By.linkText("Gift Cards"));
            gift.click();

            List<WebElement> physicals = driver.findElements(By.xpath("//a[contains(text(),'Physical')]"));

            int sayi = (int)(Math.random()*physicals.size());

            physicals.get(sayi).click();

            if(sayi == 0) {
                WebElement nameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("giftcard_44_RecipientName")));
                nameBox.sendKeys("Emrahgun");

                WebElement myName = driver.findElement(By.id("giftcard_44_SenderName"));
                myName.clear();
                myName.sendKeys("Erdem Buke");

                WebElement message = driver.findElement(By.id("giftcard_44_Message"));
                message.sendKeys("Iyi gunlerde kullan");

                WebElement addtoCart = driver.findElement(By.id("add-to-cart-button-44"));
                addtoCart.click();

                WebElement shopCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));

                Assert.assertTrue(shopCart.isDisplayed());
            }else if (sayi == 1) {
                WebElement nameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("giftcard_45_RecipientName")));
                nameBox.sendKeys("Emrahgun");

                WebElement myName = driver.findElement(By.id("giftcard_45_SenderName"));
                myName.clear();
                myName.sendKeys("Erdem Buke");

                WebElement message = driver.findElement(By.id("giftcard_45_Message"));
                message.sendKeys("Iyi gunlerde kullan");

                WebElement addtoCart = driver.findElement(By.id("add-to-cart-button-45"));
                addtoCart.click();

                WebElement shopCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));

                Assert.assertTrue(shopCart.isDisplayed());
            }
        }

        @Test(priority = 6)
        @Parameters("browser")
        void Test6() {
        /*
            ➢ Tab menudeki Computers üzerine gidiniz
            ➢ Drop down dan Desktops’a tıklayınız
            ➢ Açılan sayfadan Build your own computer’i seciniz
            ➢ Random bir RAM seciniz
            ➢ Random bir HDD seciniz
            ➢ AD TO CART’a tıklayınız
            ➢ Urunun başarılı bir şekilde sepete eklendiğini doğrulayını
        */
            Actions actions = new Actions(driver);

            WebElement computers = driver.findElement(By.linkText("Computers"));
            actions.moveToElement(computers).build().perform();

            WebElement desktops = driver.findElement(By.linkText("Desktops"));
            desktops.click();

            WebElement buildComp = driver.findElement(By.linkText("Build your own computer"));
            buildComp.click();

            WebElement ramSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_attribute_2")));
            Select ram = new Select(ramSelect);
            int rnd = (int)(Math.random()*4);
            ram.selectByIndex(rnd);

            List<WebElement> hddList = driver.findElements(By.name("product_attribute_3"));
            int rnd2 = (int)(Math.random()*2);
            hddList.get(rnd2).click();

            WebElement addCart = driver.findElement(By.id("add-to-cart-button-1"));
            addCart.click();

            WebElement shopCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));
            Assert.assertTrue(shopCart.isDisplayed());
        }

        @Test(priority = 7)
        @Parameters("search")
        void Test7(String searchWord) {
            /*
            ➢ Search’e xml den aldiginiz “Adobe Photoshop CS4” giriniz
            ➢ Search butonuna tıklayınız
            ➢ Açılan sayfadaki urun baslığının bu text’I içerdiğini doğrulayınız
            */
            WebElement searchBox = driver.findElement(By.id("small-searchterms"));
            searchBox.sendKeys(searchWord);

            WebElement searchBtn = driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));
            searchBtn.click();

            WebElement product = driver.findElement(By.linkText("Adobe Photoshop CS4"));

            Assert.assertTrue(product.getText().contains(searchWord));
        }



    @DataProvider
    public Object[][] userData() {
        Object[][] data = {
                {"erdem1@gmail.com", "erdem1231"},
                {"erdem@gmail.com", "erdem123"}
        };

        return data;
    }

}
