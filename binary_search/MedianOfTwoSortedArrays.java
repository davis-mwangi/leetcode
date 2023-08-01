package binary_search;
/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 * 
 */
public class MedianOfTwoSortedArrays {

    /***
     * Guide Using Binary Search: Take U forward(https://www.youtube.com/watch?v=NTop3VTjmxk)
     * l1 ---> r1
     * l2 -----r2
     * Check if l1 <= r2 and l2 <= r1, 
     * if it stastifies the correction then we are at the correct cut, where the values on the left are less
     * than values on the right
     * 
     * then, max(l1,l2) and min (r1, r2)
     * 
     * For even length combination we take (max(l1, l2) + min(r1, r2)) / 2
     * For odd length combination when calculating mid, we take (n + m +  1)/ 2,
     * then once we find corrent cut off point we just pick max(l1,l2)
     * 
     * 
     * @param nums1
     * @param nums2
     * @return
     * 
     * Time Complexity: O(log min(n1, n2))
     * Space Complexity: O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n1 = nums1.length;
      int n2 = nums2.length;
      int low = 0;
      int high = n1;

      while(low <=  high){
          int cut1 = (low + high) / 2;
          int cut2 = (n1+n2+1)/ 2 - cut1;

          int left1 =  cut1 == 0  ? Integer.MIN_VALUE: nums1[cut1 -1];
          int left2 =  cut2 == 0  ? Integer.MIN_VALUE: nums2[cut2 -1];

          int right1 = cut1 == n1 ? Integer.MAX_VALUE: nums1[cut1];
          int right2 = cut2 == n2 ? Integer.MAX_VALUE: nums2[cut2];

          if(left1 <= right2 && left2 <=  right1){
              //Even combined length
              if( (n1+n2) % 2 == 0){
                 return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
              }else{
                  return Math.max(left1, left2);
              }
          }else if(left1 > right2){
              high = cut1 - 1;
          }else{
              low = cut1  + 1;
          }
      }
      return 0.0;
    }

    //Solving using two pointers
    //Space Complexity: O(m+n)
    //Time Complexity: O(m+n)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int [] merged  = merged(nums1, nums2);
        int n =  merged.length;
        
        int mid = n / 2;
       
        if(n % 2 == 0){
           return ((double) (merged[mid] + merged[mid-1])) / 2.0;
        }else{
            return merged[mid];
        }

    }
    private int[] merged(int[] nums1, int[]nums2){
        int  n1 = nums1.length;
        int  n2 = nums2.length;

        int [] merged = new int[n1+n2];
        
        int i1 = 0;
        int i2 = 0;
        int  k = 0;
        
        while(i1 < n1 && i2 < n2){
            
            if(nums1[i1] < nums2[i2]){
                merged[k] = nums1[i1];
                i1 += 1;
            }else{
                merged[k] = nums2[i2];
                i2 += 1;
            }
            k++;
        }
        while(i1 < n1){
            merged[k] = nums1[i1];
            i1 += 1;
            k++;
        }

        while(i2 < n2){
            merged[k] = nums2[i2];
            i2 += 1;
            k++;
        }
       
        return merged;

    }
}
