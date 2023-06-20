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
