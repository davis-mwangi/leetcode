package trees;
/***
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * For this particular problem, if you see the pattern it's following catalan
 *  number which can be solved in O(n) time & O(1) space.
 */
public class UniqueBinarySearchTrees {

    //Time complexity: O(n ^ 2)
    //Space Complexity: O(n)
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int nodeCount = 2; nodeCount <= n; nodeCount++) {
            int total = 0;
            for (int root = 1; root <= nodeCount; root++) {
                int left = root - 1;
                int right = nodeCount - root;
                total += dp[left] * dp[right];
            }
            dp[nodeCount] = total;
        }
        return dp[n];
    }
}
