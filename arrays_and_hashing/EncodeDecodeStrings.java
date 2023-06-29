package arrays_and_hashing;
/**
 * https://www.lintcode.com/problem/659/
 * 
 * 
Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
 */
import java.util.*;

public class EncodeDecodeStrings {

// 4#lint4#code4#love3#love
public static String encode(String[] strs){
    
    StringBuilder sb = new StringBuilder();
    for(String str: strs){
        int len = str.length();
       sb.append( (len+"#"+str) );
    }
    return sb.toString();
}

//   4#lint400#code4#love3#love]

public static List<String> decode(String str){
  List<String>result= new ArrayList<>();
  
  int i = 0;
  int n = str.length();
  while(i < n){
      
      if(str.charAt(i) == '#'){
          String lenStr = "";
          int d = i - 1;
          //Cater for numbers E.g 10000
          while(d>=0 && Character.isDigit(str.charAt(d) ) ){
              lenStr = str.charAt(d) + lenStr;
            d--;
          }
          int  len = Integer.parseInt(lenStr);
          result.add( str.substring(i+1, i+1+len) );
          i = i + len;

      }
      i++;

  }
  return result;

}
}
