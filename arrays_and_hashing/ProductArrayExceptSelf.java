package arrays_and_hashing;
/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
//Time Complexity: O(n)
//Space Complexity: O(n)
public class ProductArrayExceptSelf {
    //         [1, 2, 3, 4]
    //Prefix 1 [1, 2, 6,24]
    //Postfix  [24,24,12,4] 1
    //Final   max((i +1),(i -1)) => [24,12,8,6]
    public int[] productExceptSelf1(int[] nums) {
        int n =  nums.length;
        int[] prefix = new  int [n];
        int[] postfix = new int[n];
        int[] result = new int[n];

        int pre = 1;

        for(int i = 0; i < n; i++){
            prefix[i] = pre * nums[i];
            pre = prefix[i];
        }
        int pos = 1;
        for(int i = n -1; i>=0; i--){
            postfix[i] = pos * nums[i];
            pos = postfix[i];
        }

        //Compute product
        pre = 1;
        pos = 1;
        for(int i = 0; i < n; i++){
            pre =  (i-1 < 0 ?  1: prefix[i-1]);
            pos = (i +1 > n-1 ? 1: postfix[i+1]);

            result[i] = pre * pos;
        }
        return result;
    }
    public int[] productExceptSelf2(int[] nums) {
        int n =  nums.length;
        int[] result = new int[n];

        int pre = 1;
        for(int i =0; i<  n; i++){
            result[i] =  pre;
            pre *=  nums[i];
        }
        int pos = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] *= pos;
            pos *= nums[i];
        }
        return result;

    }
}
