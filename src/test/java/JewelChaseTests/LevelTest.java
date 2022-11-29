package JewelChaseTests;

import com.example.jewelchase230.Bomb;
import com.example.jewelchase230.Gate;
import com.example.jewelchase230.Item;
import com.example.jewelchase230.Level;
import com.example.jewelchase230.vectors.IntVector2D;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test various functions in the level class.
 */
public class LevelTest {
    @Test
    public void addItemTest() {
        Level testLevel = new Level(new IntVector2D(5, 5));

        IntVector2D itemPos = new IntVector2D(0, 0);
        testLevel.addItem(itemPos, new Bomb(0, 0, "Bomb", "?", 5));

        assertNotNull(testLevel.getItem(itemPos));
    }

    @Test
    public void getItemsOfTypeTest() {
        Level testLevel = new Level(new IntVector2D(5, 5));

        testLevel.addItem(new IntVector2D(0, 0), new Bomb(0, 0, "Bomb", "?", 5));
        testLevel.addItem(new IntVector2D(0, 1), new Bomb(0, 1, "Bomb2", "?", 5));
        testLevel.addItem(new IntVector2D(0, 2), new Gate(0, 2, "Gate", "?", "Red"));

        ArrayList<Bomb> bombs = testLevel.getAllItemsOfType(Bomb.class);
        assertEquals(2, bombs.size());
    }

    @Test
    public void getAllItemsTest() {
        Level testLevel = new Level(new IntVector2D(5, 5));

        testLevel.addItem(new IntVector2D(0, 0), new Bomb(0, 0, "Bomb", "?", 5));
        testLevel.addItem(new IntVector2D(0, 1), new Bomb(0, 1, "Bomb2", "?", 5));
        testLevel.addItem(new IntVector2D(0, 2), new Gate(0, 2, "Gate", "?", "Red"));

        ArrayList<Item> items = testLevel.getAllItems();
        assertEquals(3, items.size());
    }
}
