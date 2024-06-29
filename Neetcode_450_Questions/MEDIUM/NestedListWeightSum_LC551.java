package Neetcode_450_Questions.MEDIUM;

/*
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.

Return the sum of each integer in nestedList multiplied by its depth.

 

Example 1:


Input: nestedList = [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
Example 2:


Input: nestedList = [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
Example 3:

Input: nestedList = [0]
Output: 0
 

Constraints:

1 <= nestedList.length <= 50
The values of the integers in the nested list is in the range [-100, 100].
The maximum depth of any integer is less than or equal to 50.


Question : https://mrleonhuang.gitbooks.io/lintcode/content/data-structure/nested-list-weight-sum.html
Guide : https://www.youtube.com/watch?v=jR2UC4K-q2U

*/
import java.util.*;

public class NestedListWeightSum_LC551 {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // BFS
    public int depthSum(List<NestedInteger> nestedList) {
        Deque<NestedInteger> deque = new LinkedList<>();

        for (NestedInteger ni : nestedList) {
            deque.add(ni);
        }
        int depth = 1;
        int sum = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                NestedInteger ni = deque.poll();
                if (ni.isInteger()) {
                    sum += (depth * ni.getInteger());
                } else {
                    // Break them into integer
                    List<NestedInteger> list = ni.getList();
                    // Add them to the last
                    for (NestedInteger nestedInt : list) {
                        deque.addFirst(nestedInt);
                    }

                }
            }
            depth += 1;

        }
        return sum;
    }

        // DFS SOLUTION 
        public int depthSum2(List<NestedInteger> nestedList) {
            return depthSum(nestedList, 1);
        }
        public int depthSum(List<NestedInteger> nestedList, int level) {
            int result = 0;
            for(NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    result = result + (level * ni.getInteger());
                }else {
                    result = result + depthSum(ni.getList(), level+1);
                }
            }
            return result;
        }
}
