package trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
 * 
 */
public class TimNeededToInformAllEmployees {
    
     /**
    Since a tree is a directed graph we map manager to employee
    We use BFS each time we add the time to inform down the tree
     
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>>adj= new HashMap<>();
        //Map manager to employees
        for(int i = 0; i < n; i++){
            if(!adj.containsKey(manager[i])){
                 adj.put( manager[i] , new ArrayList<>() );
            }
            adj.get(manager[i]).add(i);
        }

        //Traverse DFS
        Deque<int[]>deque =  new LinkedList<>();
        deque.add(new int[]{ headID, informTime[headID]}); //[emp, informTime]
        int res = 0;
        while(!deque.isEmpty()){
           
             int[] empTime = deque.pollFirst();
             int emp = empTime[0];
             int time = empTime[1];

             //max time to reach current employee
             res = Math.max(res, time);
             List<Integer>empList = adj.getOrDefault(emp, new ArrayList<>() );
            
             if(empList.isEmpty()){
                continue;
             }

            for(int e :empList ){
                 //add emp with curr time + time to reach to curr emp
                 deque.add(new int [] {e, time + informTime[e]} );
            } 
        }
        return res;

    }  
}
