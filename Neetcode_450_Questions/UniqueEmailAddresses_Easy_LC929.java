package Neetcode_450_Questions;

import java.util.*;

public class UniqueEmailAddresses_Easy_LC929 {
    class Solution {
        /*
         * "test.email+alex@leetcode.com", => testemail@leetcode.com
         * "test.e.mail+bob.cathy@leetcode.com", => testemail@leetcode.com
         * "testemail+david@lee.tcode.com"
         * 
         * 
         */
        public int numUniqueEmails(String[] emails) {
            Set<String> unique = new HashSet<>();
            for (String email : emails) {
                StringBuilder cleaned = new StringBuilder();
                boolean ignore = false;
                for (char ch : email.toCharArray()) {
                    if (ch == '.')
                        continue;
                    if (ch == '+') {
                        ignore = true;
                    }
                    if (ch == '@') {
                        break;
                    }
                    if (!ignore) {
                        cleaned.append(ch);
                    }
                }
                cleaned.append('@');
                cleaned.append(email.split("@")[1]);
                // System.out.println(cleaned);
                unique.add(cleaned.toString());

            }
            return unique.size();

        }
    }
}
