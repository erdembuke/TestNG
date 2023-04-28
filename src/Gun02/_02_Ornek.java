package Gun02;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _02_Ornek extends BaseDriver {

    @Test
    void Test1() {

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        Actions actions = new Actions(driver);
        WebDriverWait bkl = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement myAcc = driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));
        actions.moveToElement(myAcc).click().build().perform();

        WebElement loginMenu = driver.findElement(By.xpath("(//*[text()='Login'])[1]"));
        loginMenu.click();

        WebElement emailInput = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        emailInput.sendKeys("erdem@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("erdem123");

        WebElement loginButton = driver.findElement(By.cssSelector("input[value=Login]"));
        loginButton.click();

        Assert.assertEquals(driver.getTitle(), "My Account", "Test1 (Login) failed");


    }

    @Test
    void Test2() {
        System.out.println("Test2");
    }
}
