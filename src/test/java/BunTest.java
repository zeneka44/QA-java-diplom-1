import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final Bun bun;
    public BunTest(String name, float price) {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100},
                {null, 0},
                {"12345", 0.5f},
                {"", -300}
        };
    }

    @Test
    public void testGetName() {
        assertEquals(bun.name, bun.getName());
    }
    @Test
    public void testGetPrice() {
        assertEquals(bun.price, bun.getPrice(), 0.001f);
    }
}
