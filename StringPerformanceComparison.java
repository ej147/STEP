public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        // String test
        long start = System.nanoTime();
        concatenateWithString(5000);
        long end = System.nanoTime();
        System.out.println("String time: " + (end - start) + " ns");

        // StringBuilder test
        start = System.nanoTime();
        concatenateWithStringBuilder(5000);
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");

        // StringBuffer test
        start = System.nanoTime();
        concatenateWithStringBuffer(5000);
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");

        demonstrateStringBuilderMethods();
        compareStringComparisonMethods();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i;
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append("!");
        sb.insert(6, "Java ");
        sb.delete(0, 5);
        sb.reverse();
        System.out.println("After StringBuilder ops: " + sb);
    }

    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("== : " + (str1 == str2)); // true
        System.out.println("== (new): " + (str1 == str3)); // false
        System.out.println("equals: " + str1.equals(str3)); // true
        System.out.println("equalsIgnoreCase: " + str1.equalsIgnoreCase("hello"));
        System.out.println("compareTo: " + str1.compareTo(str3));
    }
}
