/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructs;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author userB12
 */
public class DataStructs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /*
            Stack s = new Stack();
            
            s.push(358);
            s.push(778);
            s.push(444);
            
            System.out.println(s.pop()); //444
            
            s.push(121);
            s.push(745);
            
            System.out.println(s.pop()); //745
            System.out.println(s.pop()); //121
            System.out.println(s.pop()); //778
            
            LinkedList l = new LinkedList();
            
            l.addItemToBegining(789);
            l.addItemToBegining(-456);
            l.addItemToBegining(444);
            
            l.addItemToEnd(-999);
            l.addItemToEnd(123);
            
            
            l.printAll();
            
            System.out.println("item being removed");
            l.removeItemBegining();
            l.removeItemBegining();
            l.removeItemBegining();
            l.removeItemEnd();
            
            l.printAll();
             */
            CircularQueue q = new CircularQueue();
            q.enqueue(36);
            q.enqueue(97);
            q.enqueue(55);
            q.enqueue(78);
            q.enqueue(88);

            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            
            
            System.out.println("second round");
            q.enqueue(78);
            q.enqueue(33);
            
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());

        } catch (Exception ex) {
            Logger.getLogger(DataStructs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
