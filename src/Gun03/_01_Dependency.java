package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    // arabanın hareketi : start, driver,park,stop hareket sırası

    @Test
    void startCar() {
    }

    @Test (dependsOnMethods = {"startCar"}) // bu testin calismasi , startCar ın hatasiz calismasina bagli
    void driveCar() {
    }

    @Test (dependsOnMethods = {"driveCar" , "startCar"} )
    void parkCar() {
    }

    // alwaysRun = true bagimliliklari var ama hata cikarsa da yine calistir
    @Test (dependsOnMethods = {"parkCar"} , alwaysRun = true)
    void stopCar() {
    }

    // ayni seviyedeki testler icin priority verilebilir
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.

}
