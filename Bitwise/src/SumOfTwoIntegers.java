public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = -3;
        int b = -2;
        System.out.println(getSum(a, b));
    }
    private static int getSum(int a, int b) {
        int carry;
        while(b!=0){
            carry=a&b;
            a=a^b;
            b=(carry)<<1;
        }
        return a;
    }
}
