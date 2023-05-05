////////////////////////////////////////////////////////////////////
// Andrea Barutta 2042355
// Alex Vedovato 2042353
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC_NUMERALS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 1000;

    public static String convert(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Number must be between " + MIN_VALUE + " and " + MAX_VALUE);
        }
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            while (number >= ARABIC_NUMERALS[i]) {
                roman.append(ROMAN_NUMERALS[i]);
                number -= ARABIC_NUMERALS[i];
            }
        }
        return roman.toString();
    }

}
