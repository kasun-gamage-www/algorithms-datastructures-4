/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtableapplication;

import java.util.Arrays;

/**
 *
 * @author Kasun Gamage
 */
public class HashTable {

    private int[] studentIDs;

    public HashTable(int size) {
        studentIDs = new int[size];
        Arrays.fill(studentIDs, -1);
    }

    public int generateHash(int input) {
        return input % studentIDs.length;
    }

    public void addItem(int item) {
        int hash = generateHash(item);
        System.out.println("Item " + item + " added to " + hash);
        studentIDs[hash] = item;
    }

    public int findItem(int item) {
        int hash = generateHash(item);
        int value = studentIDs[hash];
        
        if (value == -1) {
            System.out.println("Item not found");
        } else {
            System.out.println("Item found at : " + hash);
        }
        
        return value;
    }

}
