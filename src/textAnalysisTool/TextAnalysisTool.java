package textAnalysisTool;
import java.util.*;

public class TextAnalysisTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. User Input
        System.out.println("Enter a paragraph or lengthy text:");
        String text = scanner.nextLine().trim();

        // 2. Character Count
        int totalCharacters = text.length();
        System.out.println("\nTotal number of characters: " + totalCharacters);

        // 3. Word Count
        String[] words = text.split("\\s+");
        int totalWords = words.length;
        System.out.println("Total number of words: " + totalWords);

        // 4. Most Common Character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommonChar = ' ';
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostCommonChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        System.out.println("Most common character: " + mostCommonChar);

        // 5. Character Frequency
        System.out.println("\nEnter a character to find its frequency:");
        char charToCheck = scanner.next().toLowerCase().charAt(0);
        int charCount = charFrequency.getOrDefault(charToCheck, 0);
        System.out.println("The character '" + charToCheck + "' appears " + charCount + " times.");

        // 6. Word Frequency
        scanner.nextLine(); // Clear the scanner buffer
        System.out.println("\nEnter a word to find its frequency:");
        String wordToCheck = scanner.nextLine().trim().toLowerCase();
        int wordCount = 0;
        for (String word : words) {
            if (word.toLowerCase().equals(wordToCheck)) {
                wordCount++;
            }
        }
        System.out.println("The word '" + wordToCheck + "' appears " + wordCount + " times.");

        // 7. Unique Words
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        int uniqueWordCount = uniqueWords.size();
        System.out.println("\nNumber of unique words: " + uniqueWordCount);

        scanner.close();
    }
}
