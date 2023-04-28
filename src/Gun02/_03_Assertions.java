package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void equalsOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba";

        // Actual (gercekte olan) , expected (beklenen) , mesaj(opsiyonel)
        Assert.assertEquals(s1, s2, "karsilastirma basarisiz oldu.");
    }

    @Test
    void notEqualsOrnek() {
        String s1 = "Devexperts";
        String s2 = "Devexperts";

        Assert.assertNotEquals(s1, s2, "Olusan ve beklenen esit oldu, olmamaliydi"); // s1 s2 ye eşitse hata ver
    }

    @Test
    void trueOrnek() {
        int s1 = 55;
        int s2 = 56;

        Assert.assertEquals(s2, s1, "olusan ve beklenen esit olmadı, olmaliydi"); // s1 s2 ye esit degilse hata
    }

    @Test
    void nullOrnek() {
        String s1 = null;

        Assert.assertNull(s1,"olusan null olmadi"); // s1 null degilse hata ver
    }

    @Test
    void instantFail() {
        int a = 55;
        if (a == 55)
            Assert.fail();
    }
}
