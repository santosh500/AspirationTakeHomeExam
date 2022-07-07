/*
 *   Problem 2:  DoubleSet Collection
 *   Author: Paul Charles
 *   Description: This is a collection for the DoubleSet data structure that can be utilized. It is a map container that contains values of Integers and the total count.
 *   Parameters and Requirements: Need to use have a specific key as an integer with the total amount as the value. The value can only be 1 or 2. Utilizes the Member data structure to be used as nodes to manage the process and operations.
 */
package com.aspiration.coderexam.problemtwo;
import java.util.HashMap;
import java.util.Map;

public class DoubleSet
{
    //The Map<Integer,Integer> doubleSet is the main container (data structure) to hold the values of the member and the Count.
    private Map<Integer,Integer> doubleSet = new HashMap<Integer,Integer>();

    //Both of MINIMUM_COUNT and MAXIMUM_COUNT are used to determine the size boundaries of the members. Therefore, there can only be 1 or 2 for the total count for each member.
    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 2;

    /*
     *  Description: Constructor to declare an empty DoubleSet - Used for generic use cases within the class
     *  Parameters: None
     */
    public DoubleSet()
    {

    }

    /*
     *  Description: Constructor to declare a non-empty DoubleSet. Insert pre-made list of Members
     *  Parameters: Member[] array for individual members.
     */
    public DoubleSet(Member[] doubleSetArr)
    {
        populateDoubleSet(doubleSetArr);
    }

    /*
     *  Description: Adds two DoubleSets together.
     *  Parameters: The second DoubleSet that is to be added (doubleSetTwo)
     *  Return: newDoubleSet -> The new double set: Ex - The sum of doubleSetOne + doubleSetTwo should be returned.
     */
    public DoubleSet addDoubleSet(DoubleSet doubleSetTwo)
    {
        DoubleSet newDoubleSet = new DoubleSet();
        Map<Integer, Integer> doubleSetTwoMap = doubleSetTwo.getDoubleSet();
        //This is to add DoubleSet two and to confirm that we are adding all the keys in DoubleSetTwo which correlate to DoubleSetOne.
        // It also returns all the members that are in doubleSetTwo that are not in doubleSetOne by the "else" clause
        for(Map.Entry<Integer,Integer> entry : doubleSetTwoMap.entrySet())
        {
            if(getDoubleSet().containsKey(entry.getKey()))
            {
                Member newMember = addTwoMembers(entry.getKey(),getDoubleSet().get(entry.getKey()),entry.getValue());
                newDoubleSet.getDoubleSet().put(newMember.getValue(),newMember.getCount());
            }
            else
            {
                newDoubleSet.getDoubleSet().put(entry.getKey(), entry.getValue());
            }
        }
        // This is used to populate all the members that are in doubleSetOne that are not in doubleSetTwo.
        for(Map.Entry<Integer,Integer> entry : getDoubleSet().entrySet())
        {
            if(!newDoubleSet.getDoubleSet().containsKey(entry.getKey()))
            {
                newDoubleSet.getDoubleSet().put(entry.getKey(), entry.getValue());
            }
        }

        return newDoubleSet;
    }

    /*
     *  Description: Subtracts two DoubleSets together.
     *  Parameters: The first double set (doubleSetOne) that is to be subtracted from doubleSetTwo.
     *  Return: Ex - The difference of doubleSetOne - doubleSetTwo should be returned.
     *  Assumptions: If it is in doubleSetOne then it should be available in the final double set. If it is in doubleSetTwo but not in doubleSetOne, then it will be subtracted (removed).
     */
    public DoubleSet subtractDoubleSet(DoubleSet toAdd)
    {
        DoubleSet newDoubleSet = new DoubleSet();
        Map<Integer, Integer> doubleSetTwo = toAdd.getDoubleSet();

        // This is to subtract DoubleSet two from doubleSetOne by cycling through doubleSetOne and confirming if doubleSetTwo contains the same key (member).
        // If it does then we use the logic from subtractTwoMembers() to populate the final result.
        // It also returns all the members that are in doubleSetTwo that are not in doubleSetOne by the "else" clause
        for(Map.Entry<Integer,Integer> entry : getDoubleSet().entrySet())
        {
            if(doubleSetTwo.containsKey(entry.getKey()))
            {
                Member newMember = subtractTwoMembers(entry.getKey(), entry.getValue(), doubleSetTwo.get(entry.getKey()));
                if(newMember!=null)
                {
                    newDoubleSet.getDoubleSet().put(newMember.getValue(),newMember.getCount());
                }
            }
            // This is used to populate all the members that are in doubleSetOne that are not in doubleSetTwo, which is based on the assumptions from the instructions.
            else
            {
                newDoubleSet.getDoubleSet().put(entry.getKey(), entry.getValue());
            }

        }
        return newDoubleSet;
    }

    /*
     *  Description: Utility function used by addDoubleSet() to add two members together that are both in doubleSetOne and doubleSetTwo
     *  Parameters: Value or Key from the map (value). The total count from double set one (doubleSetOneCount) and the total count from double set two (doubleSetTwoCount).
     *  Return: Ex - The sum of an individual member that is both in doubleSetOne and  doubleSetTwo should be returned.
     */
    private Member addTwoMembers(int value, int doubleSetOneCount, int doubleSetTwoCount)
    {
        if((doubleSetOneCount + doubleSetTwoCount) > MAXIMUM_COUNT)
        {
            return new Member(value,MAXIMUM_COUNT);
        }
        else
        {
            return new Member(value, doubleSetOneCount + doubleSetTwoCount);
        }
    }

    /*
     *  Description: Utility function used by subtractDoubleSet() to subtract two members together that are both in doubleSetOne and doubleSetTwo
     *  Parameters: Value or Key from the map (value). The total count from double set one (doubleSetOneCount) and the total count from double set two (doubleSetTwoCount).
     *  Return: Ex - The difference of an individual member that is both in doubleSetOne and  doubleSetTwo should be returned.
     *  Assumptions: If the difference of doubleSetOne and doubleSetTwo is above MAXIMUM_COUNT or below MAXIMUM_COUNT it should return null as that is not to be added to the final doubleSet.
     */
    private Member subtractTwoMembers(int value, int doubleSetOneCount, int doubleSetTwoCount)
    {
        if(((doubleSetOneCount - doubleSetTwoCount) > MAXIMUM_COUNT) || ((doubleSetOneCount - doubleSetTwoCount) < MINIMUM_COUNT))
        {
            return null;
        }
        else
        {
            return new Member(value, doubleSetOneCount - doubleSetTwoCount);
        }
    }

    /*
     *  Description: Print the contents of a doubleSet.
     *  Parameters: None
     *  Return: None
     */
    public void printContentsOfDoubleSet()
    {
        System.out.print("{");
        for(Map.Entry<Integer,Integer> entry : doubleSet.entrySet())
        {

            System.out.print("{"+entry.getKey() + ": " + entry.getValue() + "}, ");
        }
        System.out.print("}");
        System.out.println("");
    }

    /*
     *  Description: Utility function used by paramaterized constructor DoubleSet() to populate the DoubleSet when given an array of Members
     *  Parameters: Member[] array that is a collection of all the Members that are to be added to a DoublSet (doubleSetArr)
     *  Return: None
     */
    private void populateDoubleSet(Member[] doubleSetArr)
    {

        for(int i=0; i<doubleSetArr.length; i++)
        {
            addMember(doubleSetArr[i]);
        }
    }

    /*
     *  Description: Utility function used by populateDoubleSet() to add individual members to a doubleSet. Also checks if the count is either 1 or 2.
     *  Parameters: Member
     *  Return: None
     */
    private void addMember(Member member)
    {
        int value = member.getValue();
        int count = member.getCount();
        if(count > MAXIMUM_COUNT || count < MINIMUM_COUNT)
        {
            System.out.println("Count for member " + value + " should be greater than 0 and less than 3. Not " +count);
        }
        else {
            getDoubleSet().put(value, count);
        }
    }

    /*
     *  Description: Function used to remove individual members to a doubleSet. Also checks if the doubleSet contains the key.
     *  Parameters: Member
     *  Return: None
     */
    private void removeMember(Member member)
    {
        int value = member.getValue();
        if(!getDoubleSet().containsKey(value))
        {
            System.out.println("Member: " + value + " not available in DoubleSet.");
        }
        else {
            getDoubleSet().remove(value);
            System.out.println("Member " + value + " removed from DoubleSet.");
        }
    }


    /*
     *  Description: Getter function used to retrieve the size of the doubleSet. This size is from the Map<Integer,Integer> doubleSet size.
     *  Parameters: None
     *  Return: Size (int)
     */
    private int getSize() {
        return getDoubleSet().size();
    }


    /*
     *  Description: Getter function used to retrieve the doubleSet. This is used throughout the class.
     *  Parameters: None
     *  Return: Map<Integer, Integer> doubleSet
     */
    private Map<Integer, Integer> getDoubleSet() {
        return doubleSet;
    }
}