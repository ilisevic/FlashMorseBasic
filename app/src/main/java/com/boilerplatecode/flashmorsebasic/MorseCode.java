package com.boilerplatecode.flashmorsebasic;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

public class MorseCode {
   static String temp;
    static String [] ALPHA = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?"," " };
    static  String [] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.."," "};


    public  static HashMap <String, String> ALPHA_TO_MORSE = new HashMap<>();
    public static HashMap <String,String> MORSE_TO_ALPHA = new HashMap<>();


    static
    {
        for (int i=0; i<ALPHA.length && i<MORSE.length; i++)
        {
            ALPHA_TO_MORSE.put(ALPHA[i], MORSE[i]);
            MORSE_TO_ALPHA.put(MORSE[i],ALPHA[i]);




        }


    }

    public static String morseToAlpha ( String morseCodeInput)
    {
        StringBuilder builder = new StringBuilder();
        String[] words = morseCodeInput.trim().split(" ");//prebacuje String u niz stringova odovjenih sa tab ili space
        for(String word:words)
        {
            for (String letter:word.split(" ")){

               String alphaConvert =  MORSE_TO_ALPHA.get(letter) ;
               builder.append(alphaConvert);


            }
            builder.append(" ");
        }
return  builder.toString().toUpperCase();
    }

public static  String alphaToMorse (String englishCode)
{
    StringBuilder builder = new StringBuilder();
    String[] words = englishCode.trim().split(" ");

    for (String word: words)
    {
        for (int i = 0; i< word.length(); i++) {
//try {
    temp  = word.substring(i,i+1);

      if (ALPHA_TO_MORSE.containsKey(temp)){
            String morse = ALPHA_TO_MORSE.get(temp).toLowerCase();
            builder.append(morse).append(" ");}
      else  return "Pogrešan unos";
//}
//catch (Exception e)
//{
//    Log.e("Pogrešan unos", temp);
//}
        }
        builder.append(" ");

    }
    return builder.toString();
}
//TODO izbaciti - nepotrebno
//public static void showToast(Context context, String message)
//{
//
//    Toast.makeText(context,message, Toast.LENGTH_LONG).show();
//}
}
