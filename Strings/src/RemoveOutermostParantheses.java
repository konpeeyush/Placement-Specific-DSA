public class RemoveOutermostParantheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
    private static String removeOuterParentheses(String s){
        StringBuilder sb = new StringBuilder();
        int open=0;
        int close=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }
            else{
                close++;
            }
            if(open==close){
                sb.append(s.substring(start+1,i));
                start=i+1;
            }
        }
        return sb.toString();
    }
}
