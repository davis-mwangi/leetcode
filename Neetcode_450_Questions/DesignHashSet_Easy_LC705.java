package Neetcode_450_Questions;
/*
https://leetcode.com/problems/design-hashset/description/

*/
public class DesignHashSet_Easy_LC705 {

    class MyHashSet {

        int size;
        Node [] list;
    
        public MyHashSet() {
            this.size= 10000;
            this.list= new Node[size];
           
            for(int i=0; i < size; i++){
                list[i]= new Node(0);
            }
        }
        
        public void add(int key) {
            int index = key % size;
            Node curr = list[index];
    
            while(curr.next != null){
                if(curr.next.key == key){
                  return;
                }
                curr = curr.next;
            }
            curr.next = new Node(key);
    
        }
        
        public void remove(int key) {
            int index = key % size;
            Node curr = list[index];
    
            while(curr.next != null){
                if(curr.next.key == key){
                    curr.next = curr.next.next;
                    return;
                }
                curr = curr.next;
            }
        }
        
        public boolean contains(int key) {
            int index = key % size;
            Node curr = list[index];
    
            while(curr.next != null){
                if(curr.next.key == key){
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    
        class Node{
            int key;
            Node next;
    
            public Node(int key){
                this.key = key;
                this.next = null;
            }
        }
    }
    
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    
}
