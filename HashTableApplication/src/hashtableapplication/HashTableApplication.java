package hashtableapplication;

/**
 *
 * @author Kasun Gamage
 */
public class HashTableApplication {

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

        System.out.println(ht.findItem(123456774));
        System.out.println(ht.findItem(789456160));
       
    }

}
