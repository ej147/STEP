import java.util.*;

public class TextProcessor {

    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
              .append(w.substring(1).toLowerCase())
              .append(" ");
        }
        return sb.toString().trim();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replace(" ", "").length();

        String longestWord = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (String w : words) {
            String cleanWord = w.replaceAll("\\p{Punct}", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
            for (char c : cleanWord.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("\n=== Text Analysis ===");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommonChar);
    }

    public static String[] getWordsSorted(String text) {
        String[] words = text.replaceAll("\\p{Punct}", "").split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\nWords in alphabetical order: " + Arrays.toString(sortedWords));

        System.out.print("\nSearch for a word: ");
        String searchWord = scanner.nextLine();
        boolean found = Arrays.stream(sortedWords)
                .anyMatch(w -> w.equalsIgnoreCase(searchWord));
        System.out.println(found ? "Word found!" : "Word not found.");

        scanner.close();
    }
}
