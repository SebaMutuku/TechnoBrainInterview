import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class TechnoBrain {

    private static int fibonacii(int n) {
        if (n <= 2) {
            return n;
        }
        return fibonacii(n - 1) + fibonacii(n - 2);
    }

    private static String reversedWords(String s) {
        if (s.isEmpty()) {
            return s;
        }
        s = s.trim();
        List<String> wordsinString = Arrays.asList(s.split("\\s"));
        for (int i = 0; i < wordsinString.size(); i++) {
            Collections.reverse(wordsinString);
        }
        if (wordsinString.size() > 1) {
            return String.join(" ", wordsinString).trim();
        }
        return wordsinString.toString();

    }

    private static String mostOccurredIpAddresse(String csvUrl) {
        try {
            String delimeter = ",";
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(csvUrl));
            HashMap<String, Integer> ipAddressMap = new HashMap<String, Integer>();
            while ((line = br.readLine()) != null) {
                String[] record = line.split(delimeter);
                String ipAddress = record[2];
                if (!ipAddressMap.containsKey(ipAddress)) {
                    ipAddressMap.put(ipAddress, 1);
                } else {
                    Integer ipAddressCount = ipAddressMap.get(ipAddress);
                    ipAddressCount = ipAddressCount + 1;
                    ipAddressMap.put(ipAddress, ipAddressCount);
                }
            }
            return Collections.max(ipAddressMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacii(10));
        System.out.println(reversedWords("Hey Sebastian, How are you?"));

    }
}
