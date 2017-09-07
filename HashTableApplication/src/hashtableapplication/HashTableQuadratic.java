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
public class HashTableQuadratic {

    private int[] studentIDs;

    public HashTableQuadratic(int size) {
        studentIDs = new int[size];
        Arrays.fill(studentIDs, -1);
    }

    public int generateHash(int input) {
        return input % studentIDs.length;
    }

    public void addItem(int item) {
        int hash = generateHash(item);
        int exponent = 0;
        for (int i = hash; i <= studentIDs.length; i = i + (exponent * exponent)) {
            int index = i % studentIDs.length;
            System.out.println("checking index " + index);
            if (studentIDs[index] == -1) {
                System.out.println("Item inserted at " + index);
                studentIDs[index] = item;
                break;
            } else {
                System.out.println("Collision Occured!");
            }
            exponent++;
        }
    }

    public int findItem(int item) {
        int hash = generateHash(item);
        int exponent = 0;
        for (int i = hash; i <= studentIDs.length; i = i + (exponent * exponent)) {
            int index = i % studentIDs.length;
            System.out.println("checking index " + index);
            if (studentIDs[index] == item) {
                System.out.println("Item found at " + index);
                return studentIDs[index];
            }
            exponent++;
        }
        return -1;
    }

}
