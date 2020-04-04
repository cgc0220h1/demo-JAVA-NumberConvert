import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    private Converter converter;

    @DisplayName("Đổi cơ số nhị phân với sô thập phân dương")
    @Test
    void testToBinaryPositiveDecimal() {
        converter = new Converter(12);
        int[] expectedResult = {0, 1, 1, 0, 0};
        int[] actualResult = converter.toBinary();
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Đổi cơ số nhị phân với số thập phân âm")
    @Test
    void testToBinaryNegativeDecimal() {
        converter = new Converter(-12);
        int[] expectedResult = {1, 1, 1, 0, 0};
        int[] actualResult = converter.toBinary();
        assertArrayEquals(expectedResult, actualResult);
    }

    @DisplayName("Đổi cơ số nhị phân sang số thập phân dương")
    @Test
    void testToPositiveDecimal() {
        converter = new Converter("01100");
        int expectedResult = 12;
        int actualResult = converter.toDecimal();
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Đổi cơ số nhị phân sang số thập phân âm")
    @Test
    void testToNegativeDecimal() {
        converter = new Converter("11100");
        int expectedResult = -12;
        int actualResult = converter.toDecimal();
        assertEquals(expectedResult, actualResult);
    }

    @DisplayName("Đổi cơ số nhi phân khi chuỗi nhập vào là ký tự")
    @Test
    void setConverter() {
        converter = new Converter("abcd123");
        assertNull(converter.toDecimal());
    }
}