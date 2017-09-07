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
public class HashTableSC {

    private Node[] studentIDs;

    public HashTableSC(int size) {
        studentIDs = new Node[size];
    }

    public int generateHash(int input) {
        return input % studentIDs.length;
    }

    public void addItem(int item) {
        int hash = generateHash(item);
        Node currNode = studentIDs[hash];
        while (true) {
            if (currNode == null) {
                studentIDs[hash] = new Node(item);
                break;
            }
            currNode = currNode.next;
        }
    }

    public Node findItem(int item) {
        int hash = generateHash(item);
        Node currNode = studentIDs[hash];
        while (true) {
            if (currNode.value == item) {
                return currNode;
            }
            currNode = currNode.next;
        }
    }

}
