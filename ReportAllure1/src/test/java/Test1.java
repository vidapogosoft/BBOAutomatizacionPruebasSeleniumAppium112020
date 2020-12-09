

import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {


    @Test
    public void example1() {
        Assert.assertEquals(2, 3, "Esto fallara");
    }

    @Test
    public void example2() {
        Assert.assertEquals(2, 2);
    }

    @Test
    public void example3() {
        Assert.assertTrue(true, "Este test podria fallar ");
    }

    @Test
    public void example4() {
        Assert.fail("Este test podria fallar");
    }

    @Test(dependsOnMethods = "example1")
    public void skippedByDependencyTest() {

    }
}
