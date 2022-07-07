********************************************************************************************************************
AspirationMainApp.java
********************************************************************************************************************
---------------------------------------
Function/Purpose
---------------------------------------
Runs the testcases for both problems given in the exam. They include:
1. capitalizeCharacterStringTestSuite - tests different scenarios for Problem 1
2. doubleSetTestSuite() - tests different scenarios for Problem 2 (Some of them given in the prompt)


*********************************************************************************************************************************************************
Problem 1: Capitalize Every nth Character
*********************************************************************************************************************************************************
---------------------------------------
Codebase
---------------------------------------
Located in the package: com.aspiration.coderexam.problemone

Class: ProblemOne.java

Function: capitalizeCharacterString()
---------------------------------------
Design And Assumptions
---------------------------------------
1. Created the function: capitalizeCharacterString() This will take an original string (originalString) and a parameter to indicated at what nth character is to be capitalized.
2. Used a StringBuilder class in Java to re-add all the characters based on whether they should be capitalized or lower-cased.
3. Assumption made based on the problem statement is that only alphanumeric characters should be considered. Therefore if it is a period, comma, etc, then it should not count to be incremented.
4. Since it is alpha-numeric that count then that means that numbers can't be capitalized but they count as incremented.

*********************************************************************************************************************************************************
Problem 2: DoubleSet Implementation
*********************************************************************************************************************************************************
---------------------------------------
Codebase
---------------------------------------
Located in the package: com.aspiration.coderexam.problemtwo

Class(s): DoubleSet.java Member.java

Description: DoubleSet.java is the class that implements the functionality, such as createing the DoubleSet (constructor), addingTwoDoubleSets, subtractingTwoDoubleSets, etc. The Member.java class is used to manage the values within the DoubleSet.java.

---------------------------------------
Design And Assumptions
---------------------------------------
1. Because the DoubleSet resembles a key and a value, I decided to use a HashMap to store the member and the count. This would also make it more efficient since it is integer based as the key, as well as doing operations since it has the "contains()" feature for comparison.
2. I created a Member.java class since it would be easy to manage the members within the code. This also encourages encapsulation of the key/values of the member/count. I was debating this at first, but it made it easier within the code to use the Member objects to manage the operations.
3. I also assumed that for adding that if a Member (key) was in either double set and it wasn't in the other one then it should be in the final result. 
4. I also assumed when subtracting that if it isn't in the second double set, which is being subtracted, that it will not be available in the final result of the double set. This was seen in the example in the problem statement.
