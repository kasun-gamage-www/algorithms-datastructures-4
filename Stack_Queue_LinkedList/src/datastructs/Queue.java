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
public class Queue {
    private final int SIZE = 5;
    
    private int data[];
    private int head;
    private int tail;
    
    public Queue(){
        data = new int[SIZE];
        head = -1;
        tail = -1;
    }
    
    public void enqueue(int value){
        data[++tail] = value;
    }
    
    public int dequeue(){
        return data[++head];
    }
}
