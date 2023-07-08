package arrays_and_hashing;
/**
 * https://leetcode.com/problems/naming-a-company/
 */
import java.util.*;

public class NamingACompany {
    public long distinctNames(String[] ideas) {
        //Group all names per first character
        Map<Character,HashSet<String>>map= new HashMap<>();
        for(String idea: ideas){
            char ch =  idea.charAt(0);
            String suffix = idea.substring(1);
            //Add name  minus first char
            if(!map.containsKey(ch)){
                map.put(ch, new HashSet<>());
            }
            map.get(ch).add(suffix);
        }

        long result = 0;
        for(Character ch1: map.keySet()){

            for(Character ch2: map.keySet()){
            
                if(ch1.equals(ch2)){
                    continue;
                }
                int intersect = 0;
                for(String sufix:  map.get(ch1)){
                    
                    if(map.get(ch2).contains(sufix)){
                       intersect += 1;
                    }
                }
                result += (map.get(ch1).size() - intersect) * (map.get(ch2).size()- intersect);

            }
        }
        return result;

    }
}
