package arrays_and_hashing;
/**
 * https://leetcode.com/problems/unique-email-addresses/
 * 
 * davidmwangi@gmail.com
 * david.mwangi@gmail.com => davidmwangi@gmail.com  <-----
 * 
 * m.y+name@email.com => my@email.com
 *    ^
 */
//Solution 1
public class UniqueEmailAddresses {
    public int numUniqueEmails(String [] emails){
        Set<String>result =  new HashSet<>();

        for(String email: emails ){
            String [] localDomain =  email.split("@");
            String domain = localDomain[1];
            String local =  localDomain[0];
            String newLocal = local.split("\\+")[0].replace(".","");
            String finalEmail = newLocal.concat("@").concat(domain);
            result.add(finalEmail);

        }
        return result.size();
    }
}

//Solution 2 
public class UniqueEmailAddresses {
    public int numUniqueEmails(String [] emails){
        Set<String>result =  new HashSet<>();

        for(String email: emails ){
            int i = 0;
            StringBuilder localSb = new StringBuilder();

            while(email.charAt(i) != '@' && email.charAt(i) != '+'){
                if(email.charAt(i) != '.'){
                    localSb.append(email.charAt(i));
                }
                i++;
            }
            
            while(email.charAt(i) != '@'){
                i++;
            }
            
            result.add(localSb.toString()+"@" + email.substring(i));

        }
        return result.size();
    }
}
