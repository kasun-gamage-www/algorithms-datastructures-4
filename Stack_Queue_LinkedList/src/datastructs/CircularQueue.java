/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructs;

/**
 *
 * @author userB12
 */
public class CircularQueue {

    private final int SIZE = 5;

    private int data[];
    private int head;
    private int tail;

    private int currSize;

    public CircularQueue() {
        currSize = 0;
        data = new int[SIZE];
        head = -1;
        tail = -1;
    }

    public void enqueue(int value) {
       //if (currSize < SIZE) {
            tail = (tail + 1) % SIZE;
            data[tail] = value;
            currSize++;
       // } else {
          //  System.out.println("q is full");
     //   }
    }

    public int dequeue() throws Exception {
        if (currSize != 0) {
            head = (head + 1) % SIZE;
            currSize--;
            return data[head]; 
        } else {
            throw new Exception("q is empty");
        }
    }
}
