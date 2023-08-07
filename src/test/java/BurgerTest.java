import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        assertTrue(burger.ingredients.contains(ingredientSauce));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(ingredientFilling);
        ingredient.add(ingredientSauce);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients, ingredient);
    }
    @Test
    public void getPrice(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(100F);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(100F);
        Assert.assertEquals(burger.getPrice(), 400, 1);
    }
    @Test
    public void getReceipt(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredientSauce.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientFilling.getName()).thenReturn("dinosaur");
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        String newGetReceipt = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= filling dinosaur =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 0,000000" + "\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(newGetReceipt.replace("\r\n", "\n"), actualReceipt.replace("\r\n", "\n"));
    }

}
