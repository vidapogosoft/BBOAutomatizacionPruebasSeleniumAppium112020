
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {


    @Test
    public void test1() {
        Assert.assertEquals(2, 3);
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, 2);
    }

    @Test
    public void test3() {
        Assert.assertTrue(true, "Este test podria fallar");
    }

    @Test
    public void test4() {
        Assert.fail("Este test podria fallar");
    }

    @Test(dependsOnMethods = "test4")
    public void skippedByDependencyTest() {

    }


}
