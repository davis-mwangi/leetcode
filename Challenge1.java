import java.util.*;
import java.util.Collections;
class Challenge1 {
    // return VALID / INVALID
    public String solution(int[] A, int[] B, int Z) {
        // Create an adjacency lit
        List<int[]> lst = new ArrayList<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            lst.add(new int[] { A[i], B[i], i }); // [20, 3, 0]
        }
        // Sort per order of the next pointing index
        Collections.sort(lst, new MyComparator());
        if (lst.get(0)[1] != -1) {
            return "INVALID";
        }
        for (int i = 1; i < lst.size() - 1; i++) {
            if (Math.abs(lst.get(i)[0] - lst.get(i + 1)[0]) > Z) {
                return "INVALID";
            }
        }
        System.out.println(lst);
        return "VALID";
    }

    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] > b[1]) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}