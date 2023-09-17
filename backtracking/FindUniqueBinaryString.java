package backtracking;
import java.util.*;
/*
https://leetcode.com/problems/find-unique-binary-string/submissions/

Approach:
We  maintain a set to keep record of already existing unique subtring
We will perform backstracking on each substring, each time we either flip the character or skip the chracter
When we get out bounds for each substring we check if the formed substring is in the set, if its not we add it to the result
and return 

Time Complexity: O(2 ^ m) * n where m is length of the substring and n number of substrings
Space Complexity: O(mss)
*/

public class FindUniqueBinaryString {
    public static int n;
    public static void helper(int ind,HashSet<String>hs,ArrayList<String>ds,StringBuilder sb){
        if(ind==n){
            if(!hs.contains(sb.toString())) ds.add(sb.toString());
            return;
        }
        if(ds.size()>0) return;
        for(int i=ind;i<n;i++){
            //either flip the character at that index 
            sb.setCharAt(i,sb.charAt(i)=='0'?'1':'0');
            helper(i+1,hs,ds,sb);
            sb.setCharAt(i,sb.charAt(i)=='0'?'1':'0');
            //or skip the character at that index
            helper(i+1,hs,ds,sb);
        }
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String>hs=new HashSet<>();
        ArrayList<String>ds=new ArrayList<>();
        n=nums[0].length();
        for(String str:nums)    hs.add(str);
        for(String str:nums)
            helper(0,hs,ds,new StringBuilder(str));
        return ds.get(0);
    }
    
}
