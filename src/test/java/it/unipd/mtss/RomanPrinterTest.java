package it.unipd.mtss;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanPrinterTest {

        @Test
        public void singleRomanNumber() {
                assertEquals(RomanPrinter.printAsciiArt("I"), RomanPrinter.letters.get("I"));
                assertEquals(RomanPrinter.printAsciiArt("V"), RomanPrinter.letters.get("V"));
                assertEquals(RomanPrinter.printAsciiArt("X"), RomanPrinter.letters.get("X"));
                assertEquals(RomanPrinter.printAsciiArt("L"), RomanPrinter.letters.get("L"));
                assertEquals(RomanPrinter.printAsciiArt("C"), RomanPrinter.letters.get("C"));
                assertEquals(RomanPrinter.printAsciiArt("D"), RomanPrinter.letters.get("D"));
                assertEquals(RomanPrinter.printAsciiArt("M"), RomanPrinter.letters.get("M"));
        }

        @Test
        public void MultipleRomanNumber() {
                assertEquals(RomanPrinter.printAsciiArt("II"),
                " _____  _____ \n" +
                "|_   _||_   _|\n" +
                "  | |    | |  \n"+
                "  | |    | |  \n"+
                " _| |_  _| |_ \n" +
                "|_____||_____|" );
                assertEquals(RomanPrinter.printAsciiArt("XXXIII"),
                "__   __  __   __  __   __   _____  _____  _____ \n" +
                "\\ \\ / /  \\ \\ / /  \\ \\ / /  |_   _||_   _||_   _|\n" +
                " \\ V /    \\ V /    \\ V /     | |    | |    | |  \n"+
                "  > <      > <      > <      | |    | |    | |  \n"+
                " / . \\    / . \\    / . \\    _| |_  _| |_  _| |_ \n" +
                "/_/ \\_\\  /_/ \\_\\  /_/ \\_\\  |_____||_____||_____|" );
                assertEquals(RomanPrinter.printAsciiArt("IV"),
                " _____ __      __ \n"+
                "|_   _|\\ \\    / / \n"+
                "  | |   \\ \\  / /  \n"+
                "  | |    \\ \\/ /   \n"+
                " _| |_    \\  /    \n" +
                "|_____|    \\/     " );
               
        }


        @Test(expected = IllegalArgumentException.class)
    public void characterNotPresentInRomanFormat() {
        RomanPrinter.printAsciiArt("KK");
        RomanPrinter.printAsciiArt("il");
    }


       @Test(expected = IllegalArgumentException.class)
    public void nullParameterException() {
        RomanPrinter.printAsciiArt(null);
    }
   
    @Test(timeout = 100) 
    public void performance() {
        RomanPrinter.printAsciiArt("DCCCLXXXVIII");
    }

}
