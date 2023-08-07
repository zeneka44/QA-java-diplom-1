import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);

    @Test
    public void getIngredientTypeTest() {
        assertEquals(ingredient.getType(), SAUCE);
    }

    @Test
    public void getIngredientNameTest() {
        assertEquals(ingredient.getName(), "hot sauce");
    }

    @Test
    public void getIngredientPriceTest() {
        assertEquals(ingredient.getPrice(), 100, 0);
    }
}