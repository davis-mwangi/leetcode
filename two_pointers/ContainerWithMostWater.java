package two_pointers;
/***
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;

        int max = 0;
        while(l <  r){
           int min  = Math.min(height[l], height[r]);
           int area = ((r - l ) * min );
           max = Math.max(max,  area );
          
           if(height[l] < height[r]){
               l++;
           }else{
               r--;
           }
        }
        return max;
    }
}
