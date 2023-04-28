package Utility;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MyFunc {
    public static void waitForIt(int milisecond) {

        try {
            Thread.sleep(1000*milisecond);  // ms bekledigi
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static int randomGenerator(int max) { // including max
        return (int)(Math.random()*(max));
    }

    public static void listContainsString(List<WebElement> list , String word) {
        boolean found = false;
        for (WebElement e : list) {
            if(e.getText().toLowerCase().contains(word.toLowerCase())) {
                found = true;
                break;
            }
        }
        if(!found) {
            Assert.fail();
        }
    }
}
