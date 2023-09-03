package trees;
import java.util.*;

/*
https://leetcode.com/problems/operations-on-tree/

*/
public class OperationsOnTree {

    public static void main (String [] args){
        /**
         * Your LockingTree object will be instantiated and called as such:
         * LockingTree obj = new LockingTree(parent);
         * boolean param_1 = obj.lock(num,user);
         * boolean param_2 = obj.unlock(num,user);
         * boolean param_3 = obj.upgrade(num,user);
         */
    }

    //Solution

    private int[] parent;
    private int[] locked;
    private HashMap<Integer,List<Integer>>child;//{parent:[children]}

    public OperationsOnTree(int[] parent) {
        this.parent = parent;
        this.locked = new int[parent.length];
        this.child = new HashMap<>();
        //Set the default to unlocked (-1)
        Arrays.fill(locked, -1);
        
        for(int i = 0; i < parent.length; i++){
            if(!child.containsKey(parent[i])){
               this.child.put(parent[i], new ArrayList<>());
            }
            this.child.get(parent[i]).add(i);
        }
        
    }
    
    public boolean lock(int num, int user) {
        if(locked[num] != -1){//already locked
            return false;
        }
        this.locked[num]= user;//lock by user
        return true;   
    }
    
    public boolean unlock(int num, int user) {
        if(locked[num] != user){
            return false;
        }
        this.locked[num] = -1;//unlock
        return true; 
    }
    
    public boolean upgrade(int num, int user) {
        int i  =  num;
        //Check if ancestor is locked
        while(i != -1){
            if(locked[i] != -1){
                return false;
            }
            i = parent[i];
        }
        int lockedCount = 0;
        Deque<Integer>deque = new LinkedList<>();
        deque.add(num);
       
        while(!deque.isEmpty()){
            int n = deque.pollFirst();
            
            if(this.locked[n] != -1){// locked, unlock children 
                this.locked[n] = -1;
                lockedCount += 1;
            }
            if(child.get(n)== null){
                continue;
            }
            deque.addAll(child.get(n));
        }
        if(lockedCount > 0){
            locked[num] = user;
        }
        return lockedCount > 0;
    }
}
