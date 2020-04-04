import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryConverterTest {
    @DisplayName("Đổi cơ số nhị phân với sô nguyên dương")
    @Test
    void testToBinaryPositiveDecimal() {
        BinaryConverter binaryConverter = new BinaryConverter(12);
        int[] expectedResult = {0,1,1,0,0};
        int[] actualResult = binaryConverter.toBinary();
        assertArrayEquals(expectedResult,actualResult);
    }

    @DisplayName("Đổi cơ số nhị phân với số nguyên âm")
    @Test
    void testToBinaryNegativeDecimal() {
        BinaryConverter binaryConverter = new BinaryConverter(-12);
        int[] expectedResult = {1,1,1,0,0};
        int[] actualResult = binaryConverter.toBinary();
        assertArrayEquals(expectedResult,actualResult);
    }
}