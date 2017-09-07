/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtableapplication;

/**
 *
 * @author Kasun Gamage
 */
public class HashTableApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        HashTable ht = new HashTable(37);
//
//        ht.addItem(789456123);
//        ht.addItem(123456774);
//        ht.addItem(123456775);
//
//        ht.addItem(789456160);
//        HashTableLinear ht = new HashTableLinear(37);
//
//        ht.addItem(789456123);
//        ht.addItem(123456774);
//        ht.addItem(123456775);
//
//        ht.addItem(789456160);
//        System.out.println("SEARCH");
//
//        ht.findItem(123456774);
//        ht.findItem(789456160);
        HashTableSC ht = new HashTableSC(37);

        ht.addItem(789456123);
        ht.addItem(123456774);
        ht.addItem(123456775);

        ht.addItem(789456160);
        System.out.println("SEARCH");

        ht.findItem(123456774);
        ht.findItem(789456160);


        /*
        System.out.println("Search");
        int searchedItem = ht.findItem(789456123);
        System.out.println(searchedItem);
        searchedItem = ht.findItem(789456124);
        System.out.println(searchedItem);
         */
    }

}
