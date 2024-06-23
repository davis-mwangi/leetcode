package Neetcode_450_Questions.MEDIUM;

/*

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
}
