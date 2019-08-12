package chapter5;

/*
Chapter 5
Question 1

Insert bits from source integer into target, starting from start position till end position.
 */
public class BitMerger {

    public int insertBitsAtPosition(int source, int target, int startPosition, int endPosition) {
        int clearBitMask = createClearBitMask(startPosition, endPosition);
        int insertBitMask = source << startPosition;
        return (target & clearBitMask) | insertBitMask;
    }

    private int createClearBitMask(int startPosition, int endPosition) {
        int bitMaskLeftFromEndPosition = 0;
        if (endPosition < (Integer.SIZE - 1)) {
            bitMaskLeftFromEndPosition = Integer.MAX_VALUE << endPosition;
        }
        int bitMaskRightFromStartPosition = 0;
        if (startPosition > 0) {
            bitMaskRightFromStartPosition = Integer.MAX_VALUE >> (Integer.SIZE - startPosition - 1);
        }
        return bitMaskLeftFromEndPosition | bitMaskRightFromStartPosition;
    }
}
