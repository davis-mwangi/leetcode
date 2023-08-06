package linked_list;
/**
 * https://leetcode.com/problems/design-linked-list/description/
 */
public class DesignLinkedList {
    Node left;
    Node right;
    public DesignLinkedList() {
       this.left=  new Node();
       this.right = new Node();

       this.left.next = this.right;
       this.right.prev =  this.left;
    }
    
    public int get(int index) {
       Node curr =  this.left.next;
       while(curr != null && index > 0){
           curr = curr.next;
           index -= 1;
       }
       if(curr != null && curr != this.right && index == 0){
           return curr.val;
       }
       return -1;
    }
    
    public void addAtHead(int val) {
       Node node = new Node(val);
       Node next = this.left.next;
       Node prev =  this.left;
       prev.next = node;
       next.prev = node;

       node.next = next;
       node.prev = prev;
    }
    
    public void addAtTail(int val) {
       Node node = new Node(val);
       Node next = this.right;
       Node prev =  this.right.prev;
       prev.next = node;
       next.prev = node;

       node.next = next;
       node.prev = prev;
    }
    
    public void addAtIndex(int index, int val) {
       Node curr = this.left.next;
       while(curr != null && index > 0){
            curr =  curr.next;
            index -= 1;
       }
       if(curr != null && index == 0){
           Node node = new Node(val);
           Node next = curr;
           Node prev = curr.prev;
           
           prev .next = node;
           next.prev =  node;
           node.next = next;
           node.prev = prev;
       }
        
    }
    
    public void deleteAtIndex(int index) {
        Node curr = this.left.next;
        while(curr != null && index > 0){
            curr = curr.next;
            index -= 1;
        }
        //Check if at the right point to del
        if(curr != null && curr != this.right  && index == 0){
             Node next = curr.next;
             Node prev =  curr.prev;

             prev.next = next;
             next.prev = prev;
        }
    }



    static class Node {
        int val;
        Node next;
        Node prev;
        public Node(){
            this.val = 0;
            this.next = null;
            this.prev =  null;
        }
        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
         public Node(int val,Node prev,Node next){
            this.val = val;
            this.prev=  prev;
            this.next = next;
        }
        
    }
}
