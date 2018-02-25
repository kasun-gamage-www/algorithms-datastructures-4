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
public class LinkedList {

    private Node root;

    public void addItemToBegining(int value) {
        Node currRoot = root;
        root = new Node(value);

        root.setNext(currRoot);
    }

    public void removeItemBegining() {
        root = root.getNext();
    }

    public void removeItemEnd() {
        if (root != null) {
            Node prevNode = root;
            Node selNode = root;

            while (selNode.getNext() != null) {
                prevNode = selNode;
                selNode = selNode.getNext();
            }
            
            prevNode.setNext(null);
        }
    }

    public void addItemToEnd(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node selNode = root;

            while (selNode.getNext() != null) {
                selNode = selNode.getNext();
            }

            selNode.setNext(new Node(value));
        }
    }

    public void printAll() {
        Node currNode = root;
        while (currNode != null) {
            System.out.println(currNode.getValue());
            currNode = currNode.getNext();
        }
    }
}
