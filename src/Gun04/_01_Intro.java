package Gun04;

import org.testng.annotations.*;

public class _01_Intro {
    /*
     @BeforeSuit
       @BeforeTest
         @BeforeGroup
           @BeforeClass
             @BeforeMethod
                 @Test1 method
                 @Test2 method
             @AfterMethod
           @AfterClass
         @AfterGroup
       @AfterTest
     @AfterSuit
   */

    @BeforeSuite
    void bSuite() {
        System.out.println("before suite");
    }

    @BeforeTest
    void bTest() {
        System.out.println("before test");
    }

    @BeforeGroups
    void bGroups() {
        System.out.println("before groups");
    }

    @BeforeClass
    void bClass() {
        System.out.println("before class");
    }

    @BeforeMethod
    void bMethod() {
        System.out.println("before method");
    }

    @Test
    void Intro1_Test1() {
        System.out.println("Intro_1 -> Test1");
    }

    @Test
    void Intro1_Test2() {
        System.out.println("Intro_1 -> Test2");
    }

    @AfterMethod
    void aMethod() {
        System.out.println("after method");
    }

    @AfterClass
    void aClass() {
        System.out.println("after class");
    }

    @AfterGroups
    void aGroups() {
        System.out.println("after groups");
    }

    @AfterTest
    void aTest() {
        System.out.println("after test");
    }

    @AfterSuite
    void aSuite() {
        System.out.println("after suite");
    }
}
