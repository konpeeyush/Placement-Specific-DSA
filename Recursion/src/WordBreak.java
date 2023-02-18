import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s, wordDict));
    }
    private static boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict, 0);
    }
    private static boolean solve(String s, List<String> wordDict, int idx) {
        if (idx == s.length()) return true;
        for (int i = idx; i < s.length(); i++) {
            if (wordDict.contains(s.substring(idx, i + 1)) && solve(s, wordDict, i + 1)) return true;
        }
        return false;
    }
}
