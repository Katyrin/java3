package HW7;

public class TestClass {

    @BeforeSuite
    public void init(){
        System.out.println("BeforeSuite init");
    }

    @Test
    public void testOne(){
        System.out.println("testOne");
    }

    @Test (priority = 3)
    public void testTwo(){
        System.out.println("testTwo");
    }

    @Test (priority = 10)
    public void testThree(){
        System.out.println("testThree");
    }

    @Test (priority = 1)
    public void testFour(){
        System.out.println("testFour");
    }

    @AfterSuite
    public void finish(){
        System.out.println("AfterSuite finish");
    }

}
