package two_pointers;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * 
 * Guide : Ayushi Sharma : https://www.youtube.com/watch?v=drbtmYjZQHQ
 * 
 * pattern element != nums[ i - 2]
 * 
 */
public class RemoveDuplicatesSortedArrayII {

    public int removeDuplicates(int [] nums){
        int  i  = 0;
        for(int el : nums){
            if(i == 0 || i == 1 || (el != nums[i -2])  ){
              nums[i] =  el;
              i++;
            }
        }
        return i;
    }
    
}
