package Gun02;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable {

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test(enabled = false) // var ama şimdilik aktif degil , sadece 1,3 calisacak
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }
    public static WebDriver driver;
    @BeforeClass
    void baslangicIslemleri() {
        System.out.println("baslangic islemleri yapiliyor");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY , "true");

        driver = new ChromeDriver();
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        driver.manage().window().maximize();
    }

    @AfterClass
    void bitisIslemleri() {
        System.out.println("bitis islemleri yapiliyor");
        MyFunc.waitForIt(3);
        driver.quit();
    }


}
