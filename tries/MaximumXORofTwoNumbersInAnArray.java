package tries;
/*
Leetcode : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127

Algorithm:
   1. Insert all the numbers into the trie in bits
   2. Take x and find the max number of array where XOR is maximum
*/
public class MaximumXORofTwoNumbersInAnArray {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            Trie trie = new Trie();
            for(int num : nums){
                trie.insert(num);
            }
    
            //Find maximun
            int maxi = 0;
            for(int num: nums){
                maxi = Math.max(maxi,  trie.getMax(num) );
            }
            return maxi;
        }
    
        static class Trie{
            private Node root;
    
            Trie(){
               root = new Node();
            }
    
            public void  insert(int num){
                Node node =  root;
                //32 bits from left to right
                for(int i = 31; i >=0; i--){
                    int bit = (num >> i) & 1;
                    if(!node.containsKey(bit)){
                      node.put(bit, new Node());
                    }
                    node = node.get(bit);
                }
            }
    
            public int getMax(int num){
                Node node = root;
                int maxNum = 0;
                for(int i = 31; i >= 0;i--){
                    int bit = (num >> i) & 1;
    
                    if(node.containsKey(1 - bit)){
                        maxNum = maxNum | (1 << i);
                        ///Look for opposite to maximize value
                        node = node.get(1-bit);
                    }else{
                        node =  node.get(bit);
                    }
                }
                return maxNum;
            }
        }
    
        static class Node {
            private  Node [] links;
            // private boolean flag;
    
            Node (){
                this.links = new Node[2];// 1 or 0
                // this.flag = false;
            }
    
            public boolean containsKey(int bit){
                return links[bit] != null;
            }
    
            public void  put(int bit, Node node){
                this.links[bit] = node;
            }
    
            public Node get(int bit){
                return this.links[bit];
            }
        }
    }
}
