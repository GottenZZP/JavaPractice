package Data_;

public class Homework01 {
    public static void main(String[] args) {
        String s = "Hello World!";
        String res = Homework01.reverse2(s, 3, 7);
        System.out.println(res);
    }

    public static String reverse(String str, int start, int end) {
        StringBuilder buffer = new StringBuilder(str);
        for (; start <= end; start++, end--) {
            char tmp1 = buffer.charAt(end);
            char tmp2 = buffer.charAt(start);
            buffer.setCharAt(start, tmp1);
            buffer.setCharAt(end, tmp2);
        }
        return buffer.toString();
    }

    public static String reverse1(String str, int start, int end) {
        char[] strs = str.toCharArray();
        for (; start <= end; start++, end--) {
            char tmp1 = strs[end];
            strs[end] = strs[start];
            strs[start] = tmp1;
        }
        return new String(strs);
    }

    public static String reverse2(String str, int start, int end) {
        return str.substring(0, start) + new StringBuilder(str.substring(start, end)).reverse().toString() +
                str.substring(end + 1);
    }
}