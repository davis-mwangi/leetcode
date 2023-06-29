package arrays_and_hashing;
import java.util.*;
/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * [1,1,1,2,2,3] ,  k = 2
 * [1:3, 2:2, 3]
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int [] nums, int k){
        HashMap<Integer, Integer>map = new HashMap<>();

        for(int num: nums){
            if(!map.containsKey(num)){
               map.put(num, 0);
            }
            map.put(num,  map.get(num) +1 );
        }

        PriorityQueue<Map.Entry<Integer, Integer>>pq = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Integer,Integer>entry:  map.entrySet()){
            pq.add(entry);
        }
        int[] result =  new int[k];
        int i = k - 1;
        while(i >= 0){
             result[i] = pq.poll().getKey();
             i--;
        }
        return result;
    }
    
}
