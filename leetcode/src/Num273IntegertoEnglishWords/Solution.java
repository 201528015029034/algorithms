package Num273IntegertoEnglishWords;

/**
 * Created by silence on 2017/3/19.
 */
public class Solution {
    String[] smallUnit = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Forteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String[] largeUnit = new String[]{"Zero", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] wordUnit = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int[] digits = new int[(int)Math.ceil((Integer.valueOf(num).toString()).length()/3.0)];
        String words = "";
        for(int i=0; num>0; i++) {
            digits[i] = num % 1000;
            num = num / 1000;
        }
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] != 0) {
                words = words + " " + intoStr(digits[i]) + " " + wordUnit[i];
            }
        }

        return words.substring(1);
    }

    private String intoStr(int num) {
        String hundredStr = (num/100) == 0 ? "" : smallUnit[num/100] + " Hundred";
        int ten = num % 100;
        String tenStr;
        if(ten == 0) tenStr = "";
        else if(ten <= 20) tenStr = smallUnit[ten];
        else if(ten%10 == 0) tenStr = largeUnit[ten/10];
        else tenStr = largeUnit[ten/10] + " " + smallUnit[ten%10];

        if(hundredStr == "") return tenStr;
        else if(tenStr == "") return hundredStr;
        else return hundredStr + " " + tenStr;
    }
}
