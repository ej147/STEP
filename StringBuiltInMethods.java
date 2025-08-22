public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = "  Java Programming is Fun and Challenging!  ";

        // 1. Original length including spaces
        System.out.println("Original Length: " + sampleText.length());

        // 2. Trim and show new length
        String trimmed = sampleText.trim();
        System.out.println("Trimmed Length: " + trimmed.length());

        // 3. Character at index 5
        System.out.println("Char at index 5: " + sampleText.charAt(5));

        // 4. Extract "Programming"
        System.out.println("Substring: " + sampleText.substring(7, 18));

        // 5. Index of "Fun"
        System.out.println("Index of 'Fun': " + sampleText.indexOf("Fun"));

        // 6. Contains "Java"
        System.out.println("Contains 'Java': " + sampleText.contains("Java"));

        // 7. Starts with "Java" (after trimming)
        System.out.println("Starts with 'Java': " + trimmed.startsWith("Java"));

        // 8. Ends with "!"
        System.out.println("Ends with '!': " + trimmed.endsWith("!"));

        // 9. Uppercase
        System.out.println("Uppercase: " + sampleText.toUpperCase());

        // 10. Lowercase
        System.out.println("Lowercase: " + sampleText.toLowerCase());

        // Vowel count
        System.out.println("Vowel Count: " + countVowels(sampleText));

        // Occurrences of 'a'
        findAllOccurrences(sampleText, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        System.out.print("Occurrences of '" + target + "': ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
