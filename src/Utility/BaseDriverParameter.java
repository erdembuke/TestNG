package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public WebDriver driver; // her classin kendi driveri olsun
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void startingMethod(String browserName) {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (browserName.toLowerCase()) {
            case "firefox" :
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                break;
            case "safari" :
                driver = new SafariDriver();
                break;
            case "edge" :
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
        }

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
