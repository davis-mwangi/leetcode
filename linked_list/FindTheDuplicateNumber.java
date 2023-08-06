package linked_list;
/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * 
 * Guide: https://www.youtube.com/watch?v=wjYnzkAhcNk (Neetcode)
 * 
 *
 */
public class FindTheDuplicateNumber {

    //Using Floyd's slow and fast pointer
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        //Find first Intersection
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        //Find second intersection ,
        // The distance between 1 intersection to second intersection
        //will always be equal to distance from start to start of intersection
        int slow2 = 0;
        do {
            slow2 = nums[slow2];
            slow = nums[slow];
        }while(slow2 != slow);

        return slow;
        
    }
    //Using indexes
    public int findDuplicate2(int[] nums) {
         
        for(int num :  nums){
            num = Math.abs(num);
            
            if(nums[num] < 0){
                return num;
            }
            
            nums[num] *= -1;
        }
        
        return -1;
       
    }

    //Using visited array
    //Time Complexity:  O(n)
    //Space Complexity: O(n)
    public int findDuplicate3(int[] nums) {
        boolean[] visited = new boolean[nums.length];
         
         int i = 0;
         while(i < nums.length){
             if(visited[nums[i]]){
                 return nums[i];
             }
             visited[nums[i]] = true;
             i++;
         }
         return -1;
     }
}
