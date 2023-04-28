package Gun05;

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Task_CrossBrowser_Parallel extends BaseDriverParameter {

    @Test(dataProvider = "getData")
    void searchTest(String word) {
        WebElement searchInput= driver.findElement(By.cssSelector("[name='search']"));
        searchInput.clear();
        searchInput.sendKeys(word);

        WebElement searchButton= driver.findElement(
                By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> captions=driver.findElements(
                By.cssSelector("div[class='caption']>h4"));

        for(WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(word.toLowerCase()));
    }

    @DataProvider
    public Object[] getData() {
        Object[] words = {"mac" , "ipod" , "samsung"};

        return words;
    }
}
