import HW6.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestOne {

    Main m;

    @Before
    public void init(){
        m = new Main();
    }

    @Test
    public void testMethodOne1(){
        int[] inArr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] outArr = {1, 7};
        Assert.assertArrayEquals(outArr, m.methodOne(inArr));
    }

    @Test
    public void testMethodOne2(){
        int[] inArr = {1, 2, 4, 4, 2, 3, 1, 7};
        int[] outArr = {2, 3, 1, 7};
        Assert.assertArrayEquals(outArr, m.methodOne(inArr));
    }

    @Test(expected = RuntimeException.class)
    public void testMethodOne3(){
        Assert.assertNotNull(m.methodOne(null));
    }

    @Test(expected = RuntimeException.class)
    public void testMethodOne4(){
        int[] inArr = {1, 2, 2, 3, 1, 7};
        int[] outArr = {2, 3, 1, 7};
        Assert.assertArrayEquals(outArr, m.methodOne(inArr));
    }

    // тест второго метода

    @Test
    public void testMethodTwo1(){
        int[] arr = {1, 4, 2, 7, 5, 9};
        Assert.assertTrue(m.methodTwo(arr));
    }

    @Test
    public void testMethodTwo2(){
        int[] arr = {6, 4, 2, 7, 5, 9};
        Assert.assertFalse(m.methodTwo(arr));
    }

    @Test
    public void testMethodTwo3(){
        int[] arr = {0, 3, 2, 7, 5, 9};
        Assert.assertFalse(m.methodTwo(arr));
    }


}
