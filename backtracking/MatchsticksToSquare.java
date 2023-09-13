package backtracking;

import java.util.Arrays;

/*
 Leetcode: https://leetcode.com/problems/matchsticks-to-square/

 YouTub: https://www.youtube.com/watch?v=hUe0cUKV-YY

 Approach:
 Since we need to form a square with all the sticks provided,

 First we dtermine the length of the side each will have, this can be done 
 by summing up all sides and dividing by 4

 Since we can only have integers if we sum and dvide by 4 n get
 a value that is not integer, then we return immediately
 since we cannot for a valid side.

 Also we need to sort the array, in this case to eliminate any length
 that is not equal or less than side length we calculate;

 We will do backtracking and try all  four sides i.e
 top, bottom, left, right,
 So every time will make 4 decisions either and current matchstick
 length to each side and see if it forms the length we calculated
  if we ever get a match will return that immmediately, else 
  we continue and if we dont get a valid we return false.

Time Complexity : O(4 ^ n) since we making 4 decisions each time and the 
height of the decision tree will be n  
 
 */
public class MatchsticksToSquare {
     public boolean makesquare(int[] matchsticks) {
        int sum = calSum(matchsticks);
        int sideLen = sum / 4;
        int[] sides = new int[4]; // left, right, top,  bottom

        if( (sum / sideLen) != 4){
            return false;
        }
        //Sort to have the largest values first(ASCENDING order)
        Arrays.sort(matchsticks);
        //Reverse
        reverseArray(matchsticks);

        return backtrack(matchsticks, 0, sides, sideLen);
    }
    private boolean backtrack(int[] m, int i, int[]sides, int sideLen){
        //Base case is when we have exhausted all lengths
        if(i == m.length){
            return true;
        }

        for(int j = 0; j < 4; j++){
            int side = sides[j] + m[i];
            if(side <= sideLen){
                sides[j] += m[i];
                boolean possible = backtrack(m, i + 1, sides, sideLen);
                if(possible){
                    return true;
                }
                sides[j] -= m[i];
            }
        }
        return false;
    }

    private int calSum(int[] arr){
       int sum = 0;
       for(int n : arr){
           sum += n;
       }
       return sum;
    }
    private void reverseArray(int [] arr){
       int l = 0;
       int r =  arr.length -1;
       while(l <=  r){
           int temp =  arr[l];
           arr[l] = arr[r];
           arr[r] = temp;
           l++;
           r--;
       }
    }
}
