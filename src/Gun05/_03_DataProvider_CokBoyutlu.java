package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_CokBoyutlu {

    @Test(dataProvider = "userData")
    void usernameTest(String username , String password) {
        System.out.println("user = " + username + " " + password);
    }

    @DataProvider
    public Object[][] userData() {
        Object[][] data = {
                {"Emrah" , "gun1993"} ,
                {"Erdem" , "buk1999"} ,
                {"Enes" , "buk1998"} ,
                {"Ali" , "duv1985"}
        };

        return data;
    }
}
