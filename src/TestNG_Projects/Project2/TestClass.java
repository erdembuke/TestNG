package TestNG_Projects.Project2;

import Utility.BaseDriverProject2;
import Utility.MyFunc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TestClass extends BaseDriverProject2 {


    @Test
    void Test1() {
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    void Test2() {
        TestClassPOM tcp = new TestClassPOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));

        for (WebElement a : tcp.leftnavMenus) {
            a.click();
            MyFunc.waitForIt(1);
           for (WebElement b : tcp.underLeftnavMenus) {
                Assert.assertTrue(b.isDisplayed());
          }
        }


    }

    @Test
    @Parameters("mail")
    void Test3(String text) throws AWTException {
        Robot rbt = new Robot();
        TestClassPOM tcp = new TestClassPOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));
        tcp.leftnavMenus.get(2).click();
        wait.until(ExpectedConditions.elementToBeClickable(tcp.underLeftnavMenus.get(0)));
        tcp.underLeftnavMenus.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(tcp.addNewCustomer));
        tcp.addNewCustomer.click();
        if(tcp.customerCard.getAttribute("class").contains("collapsed")) {
            tcp.customerCard.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tcp.emailBox));
        tcp.emailBox.sendKeys(text);
        tcp.passwordBox.sendKeys("group10");
        tcp.firstNameBox.sendKeys("Erdem");
        tcp.lastNameBox.sendKeys("Buke");
        tcp.maleCheckbox.click();
        tcp.birthDate.sendKeys("11/16/1999");
        tcp.companyName.sendKeys("Group10");
        tcp.taxExemptBox.click();
        tcp.newsLetter.click();
        rbt.keyPress(KeyEvent.VK_DOWN);
        rbt.keyRelease(KeyEvent.VK_DOWN);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
        Select vendor = new Select(tcp.vendorSelect);
        vendor.selectByIndex(1);
        tcp.commentBox.sendKeys("group10");
        tcp.saveButton.click();
        Assert.assertTrue(tcp.successMsg.getText().contains("successfully"));
    }

    @Test
    @Parameters("mail")
    void Test4(String text) {
        TestClassPOM tcp = new TestClassPOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));
        tcp.leftnavMenus.get(2).click();
        tcp.underLeftnavMenus.get(0).click();
        if(!tcp.searchRowCustomer.getAttribute("class").contains("opened")) {
            tcp.searchRowCustomer.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tcp.searchEmail));
        tcp.searchEmail.sendKeys(text);
        tcp.searchFirstName.sendKeys("Erdem");
        tcp.searchLastName.sendKeys("Buke");
        tcp.customerSearchBtn.click();
        tcp.editBtn.click();
        if(tcp.customerCard.getAttribute("class").contains("collapsed")) {
            tcp.customerCard.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tcp.firstNameBox));
        tcp.firstNameBox.clear();
        tcp.firstNameBox.sendKeys("Emrah");
        tcp.saveButton.click();
        Assert.assertTrue(tcp.successMsg.getText().contains("successfully"));
    }

    @Test
    @Parameters("mail")
    void Test5(String text) {
        TestClassPOM tcp = new TestClassPOM();
        wait.until(ExpectedConditions.visibilityOf(tcp.leftnavMenus.get(0)));
        tcp.leftnavMenus.get(2).click();
        tcp.underLeftnavMenus.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(tcp.searchEmail));
        tcp.searchEmail.sendKeys(text);
        tcp.searchFirstName.sendKeys("Erdem");
        tcp.searchLastName.sendKeys("Buke");
        tcp.customerSearchBtn.click();
        tcp.editBtn.click();
        if(tcp.customerCard.getAttribute("class").contains("collapsed")) {
            tcp.customerCard.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tcp.customerDeleteBtn));
        tcp.customerDeleteBtn.click();
        tcp.customerDeleteBtn2.click();
        Assert.assertTrue(tcp.successMsg.getText().contains("successfully"));
    }

    @Test
    void Test6() {
        TestClassPOM tcp = new TestClassPOM();
        tcp.homepageSearch.sendKeys("Shipments");
        tcp.shipmentSearchOption.click();
        Assert.assertTrue(tcp.displayText.getText().contains("Shipments"));
    }
}
