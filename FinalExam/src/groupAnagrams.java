import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class groupAnagrams {
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dict = new HashMap<>();

        for (String str: strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedTemp = new String(temp);

            if (dict.containsKey(sortedTemp)) dict.get(sortedTemp).add(str);
            else {
                List<String> newList = new LinkedList<>();
                newList.add(str);
                dict.put(sortedTemp, newList);
            }
        }

        return new LinkedList<>(dict.values());
    }
}
