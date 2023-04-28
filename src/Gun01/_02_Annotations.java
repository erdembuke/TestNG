package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

    @BeforeClass
    public void beforeClass() {
        System.out.println("->>>><<<<- beforeClass Method calisti ->>>><<<<-");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("->>>><<<<- afterClass Method calisti ->>>><<<<-");
    }

    @BeforeMethod // her method dan once calisir
    public void beforeMethod() {
        System.out.println("beforeMethod calisti");
    }

    @AfterMethod // her method dan sonra calisir
    public void  afterMethod() {
        System.out.println("afterMethod calisti");
    }

    @Test
    public void test1() {
        System.out.println("test1 calisti");
    }

    @Test
    public void test2() {
        System.out.println("test2 calisti");
    }

}
