package Hashtables;

public class HashTable {
    int size;
    Integer[] table;

    public HashTable(int size) {
        table = new Integer[size];
        this.size = size;
    }

    private int hash(int value) {
        
        return value % this.size;
    }

    private void addItem(int value) {
        table[hash(value)] = Integer.valueOf(value);
    }

    private void deleteItem(int value) {

    }

    private void print() {
        System.out.println("values are");
        for (Integer i : table) {

            System.out.println(i + "");
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.addItem(22);
        ht.addItem(10);
        ht.print();
    }
}
