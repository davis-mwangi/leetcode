package Neetcode_450_Questions.MEDIUM;
/*
Question : https://leetcode.ca/2020-03-18-1570-Dot-Product-of-Two-Sparse-Vectors/
Guide :  https://www.youtube.com/watch?v=sQNN4xKC1mA
*/
import java.util.*;

public class DotProductOfTwoSparseVectors_LC1570 {

    //Using HashMap
    public class SparseVector {
        //We only store numbers that are not zero,
        public Map<Integer, Integer>map = new HashMap<>(); // {idx, num}
    
        SparseVector(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i++){
                if(nums[i] != 0){
                    this.map.put(i, nums[i]);
                }
            }
        }
    
        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            Map<Integer, Integer>map2 = vec.map;
            Map<Integer, Integer>map1 = this.map;
    
            System.out.println(map2);
            System.out.println(map1);
    
            int product = 0;
            for(Integer idx2 : map2.keySet() ){
                if(map1.containsKey(idx2)){
                    product += (map2.get(idx2) * map1.get(idx2));
                }
            }
            return product;
    
        }
    }

    // Your SparseVector object will be instantiated and called as such:
    // SparseVector v1 = new SparseVector(nums1);
    // SparseVector v2 = new SparseVector(nums2);
    // int ans = v1.dotProduct(v2);


    static class SparseVector2 {
        //We only store numbers that are not zero,
        List<List<Integer>>list =  new ArrayList<>();
    
        SparseVector2(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i++){
                if(nums[i] != 0){
                    this.list.add(Arrays.asList(i, nums[i]));
                }
            }
        }
    
        // Return the dotProduct of two sparse vectors
        /*
    
        { [1,3], [3,4]}
            0      0
         [ [0,1] [3,2], [4,3] ]
             0    1       2
         */
        public int dotProduct(SparseVector2 vec) {
            int i = 0; // v1
            int j = 0; // vec
            int product = 0;
    
            while( i < list.size() && j < vec.list.size()){
                   int idx1 = list.get(i).get(0);
                   int num1 = list.get(i).get(1);
    
                   int idx2 = vec.list.get(j).get(0);
                   int num2 = vec.list.get(j).get(1);
    
                   if(idx1 == idx2){
                       product += (num1 * num2);
                       i++;
                       j++;
                   }else if( idx1 < idx2){
                        i += 1;
                   }else {
                        j += 1;
                   }
            }
            return  product;
        }
    
        public static void main(String[] args) {
            int [] nums1 = new int[] {1,0,0,2,3};
            int[] nums2 = new int[]{ 0,3,0,4,0};
            SparseVector2 v1 = new SparseVector2(nums1);
            SparseVector2 v2 = new SparseVector2(nums2);
    
    
            System.out.println(v1.dotProduct(v2)); //Output : 8
        }
    }
}
