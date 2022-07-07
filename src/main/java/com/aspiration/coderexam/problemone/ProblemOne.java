/*
 *   Problem 1:  Capitalize every nth character in a String
 *   Author: Paul Charles
 *   Description: Insert the original string to have every nth character capitalized and return that string.
 */
package com.aspiration.coderexam.problemone;

public class ProblemOne {

    /*
     *  Functionality for Problem One: capitalizeCharacterString()
     *  Parameters: originalString -> String that will be changed based on the increment; nthIncrement -> Length to determine how many spaces to increment within string. Will increment every nth (nthIncrement) space.
     *  Return: Final string with every nth character capitalized.
     */
    public static String capitalizeCharacterString(String originalString, int nthIncrement)
    {
        int size = originalString.length();
        StringBuilder alteredString = new StringBuilder();
        int totalCount = 1;
        for(int i=0; i<size; i++)
        {
            if(!Character.isLetterOrDigit(originalString.charAt(i)))
            {
                alteredString.append(originalString.charAt(i));
            }
            else if(totalCount != nthIncrement)
            {
                alteredString.append(Character.toLowerCase(originalString.charAt(i)));
                totalCount++;
            }
            else
            {
                alteredString.append(Character.toUpperCase(originalString.charAt(i)));
                totalCount=1;
            }
        }
        return alteredString.toString();
    }
}
