/* 
https://www.codingninjas.com/studio/problems/partition-equal-subset-sum_892980

This questions uses the same approach subset sum, the only difference if the target
Since we want to find two subsets which are equal, we can can assume if we find a single a 
subset equal 
to half of the sum of the entire array then we can say the entire array have two subsets that are equal


*/

public class PartitionEqualSubsetSum {
    
  //Bottom-up Solution
  //SC: O(n *  k)
  //TC: O(n *  k)  + O(N)
    public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
	    int sum = 0;
		for(int num: arr){
			sum += num;
		}
		if(sum % 2 != 0) return false;
		
		int target = sum / 2;

		return subsetSumToK(n, target, arr);
	}

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
       boolean [][] dp = new boolean [n][k+1];
       //when target is zero, then the  first col with true
       for(int i = 0; i < n; i++){
           dp[i][0] = true;
       }
       if(arr[0] <= k){
            dp[0][arr[0]] = true;
       } 
       for(int i = 1; i < n; i++){
           for(int target = 1; target <= k; target++){
                boolean notTake = dp[i - 1][ target];
                boolean take = false;
                //We only take it if the target is greater or equal to the current value
                if(target >= arr[i]){
                    take = dp[i -1][target - arr[i] ];
                }
                //since we only need one subset/subsequence to ascertain is subset
                dp[i][target] = notTake || take;
            }
       }
       return dp[n -1][k];
    }
}
