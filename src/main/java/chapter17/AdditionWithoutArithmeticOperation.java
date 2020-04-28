package chapter17;

/*
Chapter 17
Question 1

Implement Addition without using + or any arithmetic operation.
Since the term 'arithmetic operation' can be ambiguous (in a polyglot environment),
following operators are not used:
+
-
*
/
%
--
++
+=
-=
*=
/=
%=
 */
public class AdditionWithoutArithmeticOperation {

    /**
     * Adds the given 2 addends.
     * It's assumed that integers are implemented as two's complement.
     * An exception is thrown if there was an overflow or underflow.
     */
    public int add(int firstAddend, int secondAddend) throws ArithmeticException {
        boolean areBothAddendsPositive = (firstAddend >= 0) && (secondAddend >= 0);
        boolean areBothAddendsNegative = (firstAddend < 0) && (secondAddend < 0);
        int carry;
        int tempSum;

        do {
            tempSum = calculateSumWithoutCarry(firstAddend, secondAddend);
            carry = calculateCarry(firstAddend, secondAddend);
            firstAddend = tempSum;
            secondAddend = carry;
        } while (carry != 0);

        if (areBothAddendsPositive && (tempSum < 0)) {
            throw new ArithmeticException("Overflow detected");
        }

        if (areBothAddendsNegative && (tempSum >= 0)) {
            throw new ArithmeticException("Underflow detected");
        }

        return tempSum;
    }

    private int calculateCarry(int firstAddend, int secondAddend) {
        return (firstAddend & secondAddend) << 1;
    }

    private int calculateSumWithoutCarry(int firstAddend, int secondAddend) {
        return firstAddend ^ secondAddend;
    }
}
