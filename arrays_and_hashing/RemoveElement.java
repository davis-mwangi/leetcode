package arrays_and_hashing;

/**
 *  https://leetcode.com/problems/remove-element/
 * 
 * [1, 3, 5, 6, 3],  val =3 => [1, _ , 5, 6, _]
 * 
 *     ^        ^
 */   
public class RemoveElement {

    public int  removeElement(int[] nums,  int val){

        int l = 0;
        int i = 0;

        while(i < nums.length){
            if(nums[i] != val){
                //swap
                int temp =  nums[l];
                nums[l] =  nums[i];
                nums[i] = temp;
                l++;
            }
            i++;
        }
        return l;
        
    }
    
    
}
