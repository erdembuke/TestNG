package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {

    /**
     * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
     * XML filer file gruplama, pararalel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
     */

    @Test(dataProvider = "myData")
    void userNameTest(String username) {
        System.out.println(username);
    }

    @DataProvider // bu metoda dataprovider görevi verildi
    public Object[] myData () { // DataProvider olarak kullanilacak metodun tipi object olmak zorunda
        Object[] users = {"Nurhayat" , "Alper" , "Ugur" , "Hakan"};
        return users;
    }
}
