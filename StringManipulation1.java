import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with mixed formatting:");
        String input = sc.nextLine();

        // 1. Trim
        String trimmed = input.trim();

        // 2. Replace spaces with underscores
        String replaced = trimmed.replace(" ", "_");

        // 3. Remove digits
        String noDigits = replaced.replaceAll("\\d", "");

        // 4. Split into words
        String[] words = noDigits.split("_");

        // 5. Join words
        String joined = String.join(" | ", words);

        System.out.println("Processed: " + joined);

        // Extra features
        System.out.println("No punctuation: " + removePunctuation(input));
        System.out.println("Capitalized: " + capitalizeWords(input));
        System.out.println("Reversed order: " + reverseWordOrder(input));
        countWordFrequency(input);

        sc.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
              .append(w.substring(1).toLowerCase())
              .append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        System.out.println("Word Frequency: " + freq);
    }
}
