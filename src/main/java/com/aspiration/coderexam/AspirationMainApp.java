/*
 *   Aspiration Take-Home Coder Exam
 *   Author: Paul Charles
 *   Description: This is a set of two problems for the Take-Home Aspiration Coder Exam. The first problem, which is a function that returns a string that is capitalized for every nth character. This is available in the package com.aspiration.coderexam.promblemone which has the function: capitalizeCharacterString(). The second problem, which is implementing a DoubleSet data structure is variable in the collection package: com.aspiration.coderexam.problemtwo There are two classes: DoubleSet.java and Member.java that is used to implement this.
 *   Parameters and Requirements: The AspirationMainApp.class has two test suites to test both Problem 1 and Problem 2 of the Aspiration Coder Exam.
 */
package com.aspiration.coderexam;
import com.aspiration.coderexam.problemtwo.DoubleSet;
import com.aspiration.coderexam.problemtwo.Member;
import com.aspiration.coderexam.problemone.ProblemOne;

import static com.aspiration.coderexam.problemone.ProblemOne.capitalizeCharacterString;

public class AspirationMainApp
{
    public static void main(String[] args)
    {

        capitalizeCharacterStringTestSuite();
        doubleSetTestSuite();

    }


    /*
     *   Description:  This is the test suite for Problem 1 which tests the functionality of capitalizeCharacterStringTestSuite()
     *   Parameters: None
     */
    public static void capitalizeCharacterStringTestSuite()
    {
        System.out.println("---------------------------------------------");
        System.out.println("Problem One Tests");
        System.out.println("---------------------------------------------");
        //Test 1 - Input: banana, 3
        String inputString1 = "banana";
        int inputIncrement1 = 3;
        String output1 =  "baNanA";
        String test1 = capitalizeCharacterString(inputString1,inputIncrement1);
        if(output1.equals(test1)){
            System.out.println("Test Passed: " + output1 + " is equal to " + test1);
        }
        else
        {
            System.out.println("Test Failed: " + output1 + " is not equal to " + test1);
        }

        //Test 2 - Input: Aspiration.com, 3
        String output2 = "asPirAtiOn.cOm";
        String inputString2 = "Aspiration.com";
        int inputIncrement2 = 3;
        String test2 = capitalizeCharacterString(inputString2,inputIncrement2);
        if(output2.equals(test2)){
            System.out.println("Test Passed: " + output2 + " is equal to " + test2);
        }
        else
        {
            System.out.println("Test Failed: " + output2 + " is not equal to " + test2);
        }

        //Test 3 - Input: Aspiration.com, 4
        String output3 = "aspIratIon.cOm";
        String inputString3 = "Aspiration.com";
        int inputIncrement3 = 4;
        String test3 = capitalizeCharacterString(inputString3,inputIncrement3);
        if(output3.equals(test3)){
            System.out.println("Test Passed: " + output3 + " is equal to " + test3);
        }
        else
        {
            System.out.println("Test Failed: " + output3 + " is not equal to " + test3);
        }

        //Test 4 - Input: paul4 3charles123hi$hello, 3
        String output4 = "paUl4 3chArlEs123hI$heLlo";
        String inputString4 = "paul4 3charles123hi$hello";
        int inputIncrement4 = 3;
        String test4 = capitalizeCharacterString(inputString4,inputIncrement4);
        if(output4.equals(test4)){
            System.out.println("Test Passed: " + output4 + " is equal to " + test4);
        }
        else
        {
            System.out.println("Test Failed: " + output4 + " is not equal to " + test4);
        }
    }

    /*
     *   Description:  This is the test suite for Problem 2 which tests the functionality of DoubleSet operations of adding and subtracting.
     *   Parameters: None
     */
    public static void doubleSetTestSuite()
    {
        System.out.println("---------------------------------------------");
        System.out.println("Problem Two Tests");
        System.out.println("---------------------------------------------");
        //Test 1: Add two DoubleSets together:
        DoubleSet doubleSetOne = new DoubleSet(new Member[]{new Member(1,2),new Member(2,1)});
        DoubleSet doubleSetTwo = new DoubleSet(new Member[]{new Member(1,1),new Member(2,1),new Member(-3,1)});
        DoubleSet doubleSetTestOne = doubleSetOne.addDoubleSet(doubleSetTwo);
        System.out.println("Test 1 Expected: " +"{{1: 2}, {2: 2}, {-3: 1}}");
        System.out.print("Test 1 Actual: ");
        doubleSetTestOne.printContentsOfDoubleSet();

        //Test 2: Subtract Two DoubleSets
        DoubleSet doubleSetThree = new DoubleSet(new Member[]{new Member(1,2),new Member(2,1),new Member(4,1)});
        DoubleSet doubleSetFour = new DoubleSet(new Member[]{new Member(1,1),new Member(2,2),new Member(-3,1)});
        DoubleSet doubleSetTestTwo = doubleSetThree.subtractDoubleSet(doubleSetFour);
        System.out.println("Test 2 Expected: " +"{{1: 1}, {4: 1}}");
        System.out.print("Test 2 Actual: ");
        doubleSetTestTwo.printContentsOfDoubleSet();

    }

}
