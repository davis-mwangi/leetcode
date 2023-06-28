package arrays_and_hashing;
import java.util.*;

/**
 * https://leetcode.com/problems/design-hashmap/
 */
class DesignHashMap {

    private static final  int size = 10000;
    private Node [] data;

    public DesignHashMap() {  
      this.data = new Node [size];    
    }
    private int hash(int key){
        return (int) (key % size); 
    }
    
    public void put(int key, int value) {
        remove(key);
        int hash =  hash(key);
        Node node =  new Node(key, value, data[hash]);
        data[hash] = node;
        
    }
    
    public int get(int key) {
        int hash = hash(key);
        Node node = data[hash];
        while(node != null){
            if(node.key == key){
                return node.value;
            }
            node = node.next;
        } 
        return -1;
    }
    
    public void remove(int key) {
        int hash =  hash(key);
        Node node =  data[hash];
       
        if(node == null) return;

        if(node.key == key) {
            data[hash] = node.next;
        }else for(; node.next != null; node = node.next){  
            if(node.next.key == key){
                node.next = node.next.next;
                return;
            }
        }
    }

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
}
