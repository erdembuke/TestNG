package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void startingMethod() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY , "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        loginTest();
    }

    void loginTest() {

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("erdem@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("erdem123");

        WebElement loginButton = driver.findElement(By.cssSelector("input[value=Login]"));
        loginButton.click();

        Assert.assertEquals(driver.getTitle(), "My Account", "Test1 (Login) failed");


    }

    @AfterClass
    public void endingMethod() {
        MyFunc.waitForIt(3);
        driver.quit();
    }
}
