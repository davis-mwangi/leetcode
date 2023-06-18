package arrays_and_hashing;
/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class ReplaceElementWithGreatestElementOnRightSide {
    // arr [17,18,5,4,6,1] 
    // <------ move from right to left
    public int[] replaceElements(int[] arr){
        int max = -1;
        int n =   arr.length;
        for(int i = n-1; i>=0; i--){ 
            int newMax = Math.max(max, arr[i]);
            arr[i] = max; 
            max = newMax;
            
        }
        return arr;
    }
    
}
