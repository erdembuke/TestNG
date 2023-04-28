package Gun03;

import Utility.BaseDriver;
import Utility.MyFunc;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class _02_AddressFunctionality extends BaseDriver {

    /*
    1- siteyi açınız
    2- Address ekleyiniz
    3- en son adresi edit yaparak ad ve soyadı degistirip kaydediniz
    4- en son adresi siliniz
     */

    @Test
    void addAddress() {
        WebDriverWait bkl = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        Action click1 = actions.moveToElement(addressBook).click().build();
        click1.perform();


        WebElement addButton = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New Address")));
        Action click2 = actions.moveToElement(addButton).click().build();
        click2.perform();

        WebElement nameBox = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        Action input1 = actions.moveToElement(nameBox).click().sendKeys("Erdem").build();
        input1.perform();

        WebElement lastBox = driver.findElement(By.id("input-lastname"));
        Action input2 = actions.moveToElement(lastBox).click().sendKeys("Buke").build();
        input2.perform();

        WebElement cmpBox = driver.findElement(By.id("input-company"));
        Action input3 = actions.moveToElement(cmpBox).click().sendKeys("Group13").build();
        input3.perform();

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        Action input4 = actions.moveToElement(address1).click().sendKeys("New Jersey").build();
        input4.perform();

        WebElement address2 = driver.findElement(By.id("input-address-2"));
        Action input5 = actions.moveToElement(address2).click().sendKeys("United States").build();
        input5.perform();

        WebElement cityBox = driver.findElement(By.id("input-city"));
        Action input6 = actions.moveToElement(cityBox).click().sendKeys("New Jersey").build();
        input6.perform();

        WebElement postBox = driver.findElement(By.id("input-postcode"));
        Action input7 = actions.moveToElement(postBox).click().sendKeys("34709").build();
        input7.perform();

        WebElement countrySelect = driver.findElement(By.id("input-country"));
        WebElement regionSelect = driver.findElement(By.id("input-zone"));
        Select country = new Select(countrySelect);
        Select region = new Select(regionSelect);
        country.selectByValue("215");
        //belki bekle gerekebilir.
        bkl.until(ExpectedConditions.elementToBeClickable(countrySelect));
        region.selectByValue("3354");

        WebElement defaultAddressNo = driver.findElement(By.xpath("//input[@name='default' and @value='0']"));
        Action click3 = actions.moveToElement(defaultAddressNo).click().build();
        click3.perform();

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        Action click4 = actions.moveToElement(continueBtn).click().build();
        click4.perform();

        WebElement displayTxt = bkl.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        Assert.assertTrue(displayTxt.getText().toLowerCase().contains("successfull"));

    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress() throws AWTException {
        WebDriverWait bkl = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);
        Robot rbt = new Robot();

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        Action click1 = actions.moveToElement(addressBook).click().build();
        click1.perform();

        WebElement editBtn = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
        Action click2 = actions.moveToElement(editBtn).click().build();
        click2.perform();

        WebElement nameBox = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        Action input1 = actions.moveToElement(nameBox).doubleClick().sendKeys("Mustafa").build();
        input1.perform();

        WebElement lastBox = driver.findElement(By.id("input-lastname"));
        Action input2 = actions.moveToElement(lastBox).doubleClick().sendKeys("Gecer").build();
        input2.perform();

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        Action click5 = actions.moveToElement(continueBtn).click().build();
        click5.perform();

        WebElement displayTxt = bkl.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        Assert.assertTrue(displayTxt.getText().toLowerCase().contains("successfully updated"));
    }

    @Test(dependsOnMethods = {"addAddress" , "editAddress"})
    void deleteAddress() {
        WebDriverWait bkl = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        Action click1 = actions.moveToElement(addressBook).click().build();
        click1.perform();

        List<WebElement> deleteButtons = bkl.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Delete")));

        WebElement deletable = deleteButtons.get(deleteButtons.size()-1);
        Action click2 = actions.moveToElement(deletable).click().build();
        click2.perform();

        WebElement displayTxt = bkl.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        Assert.assertTrue(displayTxt.getText().toLowerCase().contains("successfully deleted"), "You tried to delete default address");
    }
}
