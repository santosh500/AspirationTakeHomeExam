/*
 *   Problem 2:  Member Node Class
 *   Author: Paul Charles
 *   Description: This is a component that is used to manage the values in the DoubleSet class.
 *   Parameters and Requirements: value - Specific key as an integer, which signifies the Member. count - the total amount for the Member. The value can only be 1 or 2. The Member object is to only be used as nodes in the process.
 *   Notes: Although the member and the count is stored in the Map in the DoubleSet, the Member objects are just used to manage the process and allows for future scalability.
 */
package com.aspiration.coderexam.problemtwo;

public class Member
{
    private int value;
    private int count;

    /*
     * Description: Constructor for Member Object used within DoubleSet
     * Parameters: value -> key for the member; count -> total value count for member
     */
    public Member(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
