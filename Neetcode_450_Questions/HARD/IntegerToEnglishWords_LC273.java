package Neetcode_450_Questions.HARD;

/*
Question : https://leetcode.com/problems/integer-to-english-words/description/


"Maintain three arrays 
  1. words of less than 20 matching the index E.g index 2 => ""Two"", 19 => ""Nineteen""
  2.words ending with ty => [""Twenty"", ""Thirty...]
  3. Dex words = [""Billion"", ""Million"", ""Thousand"", ""Hundred""]
  4. Radix(Corresponding values of (3) above [1000,000,00, 1000,000, 1,000, 100]

Iterate throught the radix  dividing  the number by radix if, zero pass else recursive pass the number , 
Return  less than 20 words, then ""Dex word"" , then, handle cases for less than 20 and more 
  "

*/

public class IntegerToEnglishWords_LC273 {
    class Solution {
        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            String[] lessThan20Words = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                    "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
            String[] tyWords = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
            String[] dexWords = { "Billion", "Million", "Thousand", "Hundred" };

            int[] radix = { 1000000000, 1000000, 1000, 100 };

            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int i = 0; i < radix.length; i++) {
                count = num / radix[i];
                if (count == 0)
                    continue;
                sb.append(numberToWords(count) + " ");
                sb.append(dexWords[i] + " ");
                num %= radix[i];
            }

            if (num < 20) {
                sb.append(lessThan20Words[num]);
            } else {
                sb.append(tyWords[num / 10 - 2] + " ");
                sb.append(lessThan20Words[num % 10]);
            }
            return sb.toString().trim();

        }
    }
}
