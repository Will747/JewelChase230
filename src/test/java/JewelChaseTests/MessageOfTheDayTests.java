package JewelChaseTests;

import com.example.jewelchase230.MessageOfTheDay;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Tests the solving of the message of the day.
 *
 * @author Will Kaye
 */
public class MessageOfTheDayTests {
    @Test
    public void basicPuzzleTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //https://www.baeldung.com/java-unit-test-private-methods
        Method puzzle = MessageOfTheDay.class.getDeclaredMethod("solvePuzzle", String.class);
        puzzle.setAccessible(true);

        assert("9BCYCS-230".equals(puzzle.invoke(null, "CAB")));
    }

    @Test
    public void FullMessageTest() {
        assert(MessageOfTheDay.getMessageOfTheDay().length() > 6);
    }
}
