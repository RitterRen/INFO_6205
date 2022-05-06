import java.util.HashMap;
import java.util.LinkedHashMap;

public class CompressString {
    public static void main(String[] args) {
        String str1 = "aabcccccaaa";
        System.out.println(compressString(str1));

    }

    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        int left = 0;

        while (left < str.length()) {
            int right = left + 1;
            while (right < str.length() && str.charAt(right) == str.charAt(left)) right++;
            sb.append(str.charAt(left));
            sb.append(right - left);
            left = right;
        }

        if (sb.length() > str.length()) return str;
        return sb.toString();
    }
}
