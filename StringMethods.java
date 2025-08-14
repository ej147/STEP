import java.util.Scanner;

public class StringMethods {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inputs
        System.out.print("Enter your full name (First Last): ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine();

        System.out.print("Enter a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        // Process
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";

        int charCount = experience.replace(" ", "").length();
        String favLangUpper = favLang.toUpperCase();

        // Output
        System.out.println("\n=== Summary ===");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + favLangUpper);
        System.out.println("Sentence Character Count (no spaces): " + charCount);

        scanner.close();
    }
}
