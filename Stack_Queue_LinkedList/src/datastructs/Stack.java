/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructs;

public class Stack {
    private final int SIZE = 5;
    
    private final int data[];
    private int top;
    
    public Stack(){
        data = new int[SIZE];
        top = -1;
    }
    
    public void push(int value){
        data[++top] = value;
    }
    
    public int pop(){
        return data[top--];
    }
}
