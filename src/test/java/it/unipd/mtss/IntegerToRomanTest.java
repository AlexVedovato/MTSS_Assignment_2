package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;

import org.junit.Test;

public class IntegerToRomanTest {

    @Test
    public void first3NumberConversion() {
        assertEquals(IntegerToRoman.convert(1), "I");
        assertEquals(IntegerToRoman.convert(2), "II");
        assertEquals(IntegerToRoman.convert(3), "III");
    }

    @Test
    public void first6NumberConversion() {
        assertEquals(IntegerToRoman.convert(4), "IV");
        assertEquals(IntegerToRoman.convert(5), "V");
        assertEquals(IntegerToRoman.convert(6), "VI");
    }

    @Test
    public void first10NumberConversion() {
        assertEquals(IntegerToRoman.convert(7), "VII");
        assertEquals(IntegerToRoman.convert(8), "VIII");
        assertEquals(IntegerToRoman.convert(9), "IX");
        assertEquals(IntegerToRoman.convert(10), "X");
    }

    @Test
    public void first20NumberConversion() {
        assertEquals(IntegerToRoman.convert(11), "XI");
        assertEquals(IntegerToRoman.convert(16), "XVI");
        assertEquals(IntegerToRoman.convert(19), "XIX");
        assertEquals(IntegerToRoman.convert(20), "XX");
    }

    @Test
    public void first50NumberConversion() {
        assertEquals(IntegerToRoman.convert(49), "XLIX");
        assertEquals(IntegerToRoman.convert(50), "L");
    }

    @Test
    public void first100NumberConversion() {
        assertEquals(IntegerToRoman.convert(57), "LVII");
        assertEquals(IntegerToRoman.convert(69), "LXIX");
        assertEquals(IntegerToRoman.convert(91), "XCI");
        assertEquals(IntegerToRoman.convert(99), "XCIX");
        assertEquals(IntegerToRoman.convert(100), "C");
    }

    @Test
    public void first500NumberConversion() {
        assertEquals(IntegerToRoman.convert(150), "CL");
        assertEquals(IntegerToRoman.convert(212), "CCXII");
        assertEquals(IntegerToRoman.convert(399), "CCCXCIX");
        assertEquals(IntegerToRoman.convert(500), "D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void overRangeThrowsIllegalArgumentException() {
        IntegerToRoman.convert(1001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void underRangeThrowsIllegalArgumentException() {
        IntegerToRoman.convert(0);
    }

    @Test(timeout = 200)
    public void performance() {
        IntegerToRoman.convert(888); // 888 è il numero romano più lungo tra 1 e 1000
    }

    @Test
    public void checkInverseRelationship() {
        // arrange
        Random rand = new Random();
        int min = 1;
        int max = 1000;
        int randomNumber = rand.nextInt(max - min + 1) + min;
        Map<Character, Integer> romanNumerals = new HashMap<Character, Integer>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
        int result = 0;
        int prevValue = 0;

        // act
        String s = IntegerToRoman.convert(randomNumber);
        for (int i = s.length() - 1; i >= 0; i--) {
            int curValue = romanNumerals.get(s.charAt(i));
            if (curValue < prevValue) {
                result -= curValue;
            } else {
                result += curValue;
            }
            prevValue = curValue;
        }

        // assert
        assertEquals(randomNumber, result);
    }

}
