package linked_list;
//ToDo: To be implmented with LRU problem.

import java.util.*;

public class LFUCache_LC146 {

   private Map<Integer,Node>cache;
   private int capacity;


    private Node left;
    private Node right;

    public LFUCache_LC146(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        //Link Left(Least Recently Used) and right(Most recent used)
        this.left = new Node(0, 0);
        this.right = new Node(0,0);

        this.left.next = this.right;
        this.right.prev = this.left;
        
    }
    private void remove(Node node){
       Node next =  node.next;
       Node prev =  node.prev;

       prev.next =  next;
       next.prev =  prev;
    }

    //We insert to the right(Most recent used)
    private void insert(Node node){
       Node prev = this.right.prev;
       Node next = this.right;

       prev.next = node;
       next.prev = node;

       node.next = this.right;
       node.prev = prev;

    }
    
    public int get(int key) {

        //We check if it is cache(map)
        if(cache.containsKey(key)){
             //Remove the node from its position
             remove(cache.get(key));

             //Add to the head(right- Most used)
             insert(cache.get(key));

             return cache.get(key).value;
       
            }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {

        //Remove the node from Linked list first if it exists
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        //Create a new Node and assign it to the key
        cache.put(key, new Node(key, value));

        //Add the node to the linked list as most recent used
        insert(cache.get(key));

        //If capacity is full, remove from the LRU
        if(cache.size() > capacity){
            Node lru = this.left.next;
            remove(lru);

            //Delete the LRU from cache using key
            cache.remove(lru.key);
        }

        
    }

    class Node {
        private int key;
        private int value;

        Node prev;
        Node next;

        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
