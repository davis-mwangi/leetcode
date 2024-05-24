package Neetcode_450_Questions.MEDIUM;
/*

https://leetcode.com/problems/validate-ip-address/description/

*/
public class ValidateIPAddress_Medium_LC468 {
    
class Solution {
    /*
input: queryIp = 
output: Ipv4, Ipv6, Neither

ipv4 = x1.x2.x3.x4 0 <= xi<= 255
ipv6: x1.x2....x.8  :   1<= xi .len <=4, digits, letters(lower & upper), leading xeros allowed
    02001:0db8:85a3:0000:0000:8a2e:0370:7334
    *.

    clarifications : 
     - contains special characters, i*$#@@
     - digits +ve or have -ves

     1. Split  size 4 => ipv4, 8 ipv6
     2. Ipv4
           0 -> 255, 
           all digits
      3. Ipv6:
            len  1 <= 4  
            no special characters   

"192.168.01.1"

"192.168@1.1

"192.168.1.00"

Time Complexity: O(N) ~ with some constants which we drop off
Space Complexity: (1)
*/
    public  String validIPAddress(String IP){
        //Identify whether v4 or v6
        if( getDelimiterCount(IP, '.') == 3){//v4

           if(IP.startsWith(".") || IP.endsWith(".") ){
              return "Neither";
           }
           String [] parts = IP.split("\\.");
           for(String part : parts){
                
                // Validate part size
                if(part.length() > 3 || part.length() == 0){
                    return "Neither";
                }
                //Validate digit
                for(char ch : part.toCharArray() ) {
                    if(!Character.isDigit(ch) ){
                        return "Neither";
                    }
                }
                //Trailing zeros
                if(part.startsWith("0") && part.length() > 1){
                   return "Neither";
                }

                //Size between 0 to 255
                if( Integer.parseInt(part) > 255){
                   return "Neither";
                }

           }
           return "IPv4";

        } else if( getDelimiterCount(IP, ':') == 7 ){//v6

            if(IP.startsWith(":") || IP.endsWith(":")){
              return "Neither";
           }
            String [] parts = IP.split(":");
            
            for(String part : parts){
                   //Validate size
                    if(part.length() > 4 || part.length() == 0){
                        return "Neither";
                    }
                  //Validate characters
                   for(char ch : part.toCharArray() ) {
                        if( !( ch >= '0'  && ch <= '9' || ch >= 'a' && ch <= 'f' || ch >= 'A' && ch <= 'F') ){
                            return "Neither";
                        }
                   }
                }
            return "IPv6";
        }else {
             return "Neither";
        }

    }

    private int getDelimiterCount(String ip, char delimiter){
        int  count = 0;
        for(int i = 0; i < ip.length(); i++){
             if( ip.charAt(i) == delimiter){
                count += 1;
             }
        }
        return count;
    }
    
}
}
