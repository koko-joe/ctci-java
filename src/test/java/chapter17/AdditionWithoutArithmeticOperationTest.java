package chapter17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdditionWithoutArithmeticOperationTest {

    private static AdditionWithoutArithmeticOperation adder;

    @BeforeAll
    static void setupBeforeAll() {
        adder = new AdditionWithoutArithmeticOperation();
    }

    @Test
    void testEveryAddendBetweenXAndMinusX() {
        int x = 10;
        int minusX = -x;
        int firstAddend;
        int secondAddend;
        int sum;

        for (firstAddend = minusX; firstAddend <= x; ++firstAddend) {
            for (secondAddend = minusX; secondAddend <= x; ++secondAddend) {
                sum = adder.add(firstAddend, secondAddend);
                Assertions.assertEquals(firstAddend + secondAddend, sum);
            }
        }
    }

    @Test
    void testThatMaxIntPlusZeroIsMaxInt() {
        int sum = adder.add(Integer.MAX_VALUE, 0);
        Assertions.assertEquals(Integer.MAX_VALUE, sum);

        sum = adder.add(0, Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE, sum);
    }

    @Test
    void testThatMinIntPlusZeroIsMinInt() {
        int sum = adder.add(Integer.MIN_VALUE, 0);
        Assertions.assertEquals(Integer.MIN_VALUE, sum);

        sum = adder.add(0, Integer.MIN_VALUE);
        Assertions.assertEquals(Integer.MIN_VALUE, sum);
    }

    @Test
    void testThatMaxIntPlusMinIntIsMinusOne() {
        int sum = adder.add(Integer.MAX_VALUE, Integer.MIN_VALUE);
        Assertions.assertEquals(-1, sum);

        sum = adder.add(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Assertions.assertEquals(-1, sum);
    }

    @Test
    void testOverflow() {
        Assertions.assertThrows(ArithmeticException.class, () -> adder.add(Integer.MAX_VALUE, 1));
        Assertions.assertThrows(ArithmeticException.class, () -> adder.add(1, Integer.MAX_VALUE));
    }

    @Test
    void testUnderflow() {
        Assertions.assertThrows(ArithmeticException.class, () -> adder.add(Integer.MIN_VALUE, -1));
        Assertions.assertThrows(ArithmeticException.class, () -> adder.add(-1, Integer.MIN_VALUE));
    }
}
