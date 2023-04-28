package Gun02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _04_SubscribeNewsLetter extends BaseDriver {

    @Test
    void NewsLetterSubscribeYes() {
  /*
        -Senaryo
        -Siteyi aciniz
        -Newsletter Subscribe islemine abone olunuz (YES)
        - Ayri bir test ile Newsletter Subscribe islemini abonelikten cikin
        - Ayri bir test ile Newsletter Subscribe durumunu kontrol ediniz YES ise NO , NO ise YES

  */
        WebDriverWait bkl = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement newsLetter = driver.findElement(By.linkText("Newsletter"));
        newsLetter.click();

        WebElement checkbox = bkl.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='radio' and @value='1']")));
        checkbox.click();

        WebElement continueBtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']"));
        continueBtn.click();

        WebElement display = bkl.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        Assert.assertTrue(display.isDisplayed());

    }

    @Test
    void newsLetterSubscribeNo() {

        WebDriverWait bkl = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement newsLetter = driver.findElement(By.linkText("Newsletter"));
        newsLetter.click();

        WebElement checkbox = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='0']")));
        checkbox.click();

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueBtn.click();

        WebElement display = bkl.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        Assert.assertTrue(display.isDisplayed());
    }

    @Test
    void oppositeNewsLetterSubscribe() {

        WebDriverWait bkl = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement newsLetter = driver.findElement(By.linkText("Newsletter"));
        newsLetter.click();

        WebElement checkbox = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='0']")));
        WebElement checkbox2 = bkl.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='1']")));
        if (checkbox.isSelected()) {
            MyFunc.waitForIt(1);
            checkbox2.click();
        }else  {
            MyFunc.waitForIt(1);
            checkbox.click();
        }

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueBtn.click();

        WebElement display = bkl.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        Assert.assertTrue(display.isDisplayed());
    }



}
