package JewelChaseTests;

import com.example.jewelchase230.vectors.DoubleVector2D;
import com.example.jewelchase230.vectors.IntVector2D;
import org.junit.jupiter.api.Test;

/**
 * Tests functions of the vector classes.
 *
 * @author Will Kaye
 */
public class VectorTests {
    IntVector2D intVectorOne = new IntVector2D(5, 6);
    IntVector2D intVectorTwo = new IntVector2D(5, 6);
    IntVector2D intVectorThree = new IntVector2D(5, 10);

    DoubleVector2D doubleVectorOne = new DoubleVector2D(5.5, 6.6);
    DoubleVector2D doubleVectorTwo = new DoubleVector2D(5.5, 6.6);
    DoubleVector2D doubleVectorThree = new DoubleVector2D(56, 66);

    @Test
    public void multiplyTest() {
        DoubleVector2D multipliedVector = new DoubleVector2D(5 * 5.5, 6 * 6.6);

        assert(doubleVectorOne.multiply(intVectorOne.toDouble()).equals(multipliedVector));
        assert(doubleVectorOne.multiply(1).equals(doubleVectorOne));
        assert(doubleVectorOne.multiply((double) 1).equals(doubleVectorOne));
        assert(doubleVectorOne.multiply(intVectorOne).equals(multipliedVector));
    }

    @Test
    public void divideTest() {
        assert(doubleVectorOne.divide(doubleVectorTwo).equals(new DoubleVector2D(1, 1)));
        assert(doubleVectorOne.divide(1).equals(doubleVectorOne));
        assert(doubleVectorOne.divide((double) 1).equals(doubleVectorOne));
    }

    @Test
    public void minusTest() {
        assert(doubleVectorThree.minus(doubleVectorTwo).equals(new DoubleVector2D(50.5, 59.4)));
    }

    @Test
    public void addTest() {
        // Int Vector tests
        assert(intVectorOne.add(intVectorTwo).equals(new IntVector2D(10, 12)));
        assert(intVectorOne.add(intVectorThree).equals(new IntVector2D(10, 16)));

        // Double Vector tests
        assert(doubleVectorOne.add(doubleVectorTwo).equals(new DoubleVector2D(11, 13.2)));
        assert(doubleVectorOne.add(5.5).equals(new DoubleVector2D(11, 12.1)));
    }

    @Test
    public void equalTest() {
        // Int Vector tests
        assert(intVectorOne.equals(intVectorTwo));
        assert(!intVectorOne.equals(intVectorThree));

        // Double Vector tests
        assert(!doubleVectorOne.equals(intVectorTwo));
        assert(doubleVectorOne.equals(doubleVectorTwo));
        assert(!doubleVectorOne.equals(doubleVectorThree));
    }
}
