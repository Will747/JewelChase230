package JewelChaseTests;

import com.example.jewelchase230.items.Bomb;
import com.example.jewelchase230.items.Gate;
import com.example.jewelchase230.items.Item;
import com.example.jewelchase230.items.LeverGateColour;
import com.example.jewelchase230.Level;
import com.example.jewelchase230.vectors.IntVector2D;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test various functions in the level class.
 *
 * @author Will Kaye
 */
public class LevelTest {
    @Test
    public void addItemTest() {
        Level testLevel = new Level(new IntVector2D(5, 5), 1);

        IntVector2D itemPos = new IntVector2D(0, 0);
        testLevel.addItem(itemPos, new Bomb());

        assertNotNull(testLevel.getItem(itemPos));
    }

    @Test
    public void getItemsOfTypeTest() {
        Level testLevel = new Level(new IntVector2D(5, 5), 1);

        testLevel.addItem(new IntVector2D(0, 0), new Bomb());
        testLevel.addItem(new IntVector2D(0, 1), new Bomb());
        testLevel.addItem(new IntVector2D(0, 2), new Gate(LeverGateColour.Red)); 

        ArrayList<Bomb> bombs = testLevel.getAllItemsOfType(Bomb.class);
        assertEquals(2, bombs.size());
    }

    @Test
    public void getAllItemsTest() {
        Level testLevel = new Level(new IntVector2D(5, 5), 1);

        testLevel.addItem(new IntVector2D(0, 0), new Bomb());
        testLevel.addItem(new IntVector2D(0, 1), new Bomb());
        testLevel.addItem(new IntVector2D(0, 2), new Gate(LeverGateColour.Red));

        ArrayList<Item> items = testLevel.getAllItems();
        assertEquals(3, items.size());
    }
}
