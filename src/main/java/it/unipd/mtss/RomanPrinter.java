////////////////////////////////////////////////////////////////////
// Andrea Barutta 2042355
// Alex Vedovato 2042353
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import java.util.HashMap;
import java.util.Map;


public class RomanPrinter {
    public static Map<String, String> letters;


    static {
          letters   = new HashMap<String, String>();
          letters.put("I", " _____ \n" +
                               "|_   _|\n" +
                               "  | |  \n"+
                               "  | |  \n"+
                               " _| |_ \n"+
                               "|_____|");
  
          letters.put("V",  "__      __ \n" +
                            "\\ \\    / / \n" +
                            " \\ \\  / /  \n" +
                            "  \\ \\/ /   \n"+
                            "   \\  /    \n"+
                            "    \\/     ");
  
          letters.put("X",  "__   __  \n" +
                                "\\ \\ / /  \n" +
                                " \\ V /   \n"+
                                "  > <    \n"+
                                " / . \\   \n"+
                                "/_/ \\_\\  ");
  
  
          letters.put("L",  " _      \n" +
                                "| |     \n" +
                                "| |     \n"+
                                "| |     \n"+
                                "| |____ \n"+
                                "|______|");
  
          letters.put("C", "  _____ \n"
                             + " / ____|\n"
                             + "| |     \n"
                             + "| |     \n"
                             + "| |____ \n"
                             + " \\_____|");
  
          letters.put("D", " _____   \n"
                              +"|  __ \\  \n"
                              +"| |  | | \n"
                              +"| |  | | \n"
                              +"| |__| | \n"
                              +"|_____/  ");
  
  
          letters.put("M", " __  __  \n" +
                               "|  \\/  | \n" +
                               "| \\  / | \n"+
                               "| |\\/| | \n"+
                               "| |  | | \n"+
                               "|_|  |_| ");
    }
  
  

    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    public static String printAsciiArt(String s) {
      if(s == null) {
        throw new  IllegalArgumentException("Null parameter");
      }
        String art="";
      for(int i = 0 ; i< 6;i++){
          for(int j = 0; j<s.length();j++){
            try{
              art+= letters.get(String.valueOf(s.charAt(j))).split("\\r?\\n")[i];
            }catch(NullPointerException Ne){
                throw new  IllegalArgumentException("There is a letter not present in the roman number format");
            }
          }
          if(i<5){
            art+='\n';
          }
      }
      return art;
    }

}
