public class CheckPalindrome {
    public static void main(String[] args) {
        String testCase1 = "MADAM";
        int testCase2 = 1221;
//        For Strings
        System.out.println(checkPalindrome(0,testCase1) ? "Yes it's a palindrome" : "No it's not a palindrome");
//        For Integers
        System.out.println(checkPalindrome(0, String.format("%d", testCase2)) ? "Yes it's a palindrome" : "No it's not a palindrome");
    }

    private static boolean checkPalindrome(int idx, String testCase) {
        if (idx >= testCase.length() / 2) return true;
        if (testCase.charAt(idx) != testCase.charAt(testCase.length() - idx - 1)) return false;
        return checkPalindrome(idx + 1, testCase);
    }
}
