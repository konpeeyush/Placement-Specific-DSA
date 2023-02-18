import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombinations {
    public static void main(String[] args) {
        String digits = "23";
//        Make a function to return valid number of combinations from the following digit
        System.out.println(combinations(digits));
    }

    private static String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", ",mno", "pqrs", "tuv", "wxyz"};

    private static List<String> combinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        solve(0,"",ans,digits);
        return ans;
    }
    private static void solve(int idx, String combination, List<String> ans, String digits){
        if(idx>=digits.length()){
            ans.add(combination);
            return;
        }

        String letters=KEYS[digits.charAt(idx)-'0'];
        for (int i = 0; i < letters.length(); i++) {
            solve(idx+1,combination+letters.charAt(i),ans,digits);
        }
    }
}
