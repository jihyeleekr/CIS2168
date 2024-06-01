package DSAssingo9;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		String filePath = "/Users/jihyelee/Downloads/mobydick.txt";

        try {
            String file = readFile(filePath);

            // Task 1: Three-letter words in Moby-Dick beginning with "a"
            int task1 = letterWithA(file);
            System.out.println("The number of three-letter words that begin with 'a' is: " + task1);

            // Task 2: Words occurring less than 10 times and more than 2000 times
            wordFreq(file);

            // Task 3: Unique words and their frequencies
            uniqueWord(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	private static String readFile(String filePath) throws IOException {
		// read the file
        StringBuilder file = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        	//Convert txt file into a String
            String line;
            while ((line = reader.readLine()) != null) {
                file.append(line).append(" ");
            }
        }
        return file.toString();
    }

    private static int letterWithA(String file) {
    	// Split the text and put every words in an array (punctuation is not included)
        String[] words = file.split("\\s+|\\p{Punct}");
        int count = 0;
        //Chec each words in the array
        for (String word : words) {
        	// If the length of the word is 3 and starts with a then we increase the count
            if (word.length() == 3 && word.startsWith("a")) {
                count++;
            }
        }
        return count;
    }

    private static void wordFreq(String file) {
    	//Split the text and put every words in an array(punctuation is not included)
        String[] words = file.split("\\s+|\\p{Punct}");

        // Create TreeMap
        TreeMap<String, Integer> wordFrequency = new TreeMap<>();

        for (String word : words) {
        	// Add each words in words array
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        int count2000 = 0;
        int count10 = 0;
        for (int frequency : wordFrequency.values()) {
            if (frequency > 2000) {
                count2000++;
            } else if (frequency < 10) {
                count10++;
            }
        }

        System.out.println("The number of words that occur less than 10 times is: " + count10);
        System.out.println("The number of words that occur more than 2000 times is: " + count2000);
    }

    private static void uniqueWord(String file) {
    	//Split the text and put every words in an array(punctuation is not included)
        String[] words = file.split("\\s+|\\p{Punct}");

        // Create TreeSet
        TreeSet<String> uniqueWords = new TreeSet<>();
        TreeMap<String, Integer> wordFrequency = new TreeMap<>();
        
     // Add words in TreeSet and count frequency in TreeMap
        for (String word : words) {
        	// Ignore empty strings (result of splitting consecutive punctuation marks)
            if (!word.isEmpty()) {
                uniqueWords.add(word);
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
     // Return the size of the set
        System.out.println("Number of unique words: " + uniqueWords.size());
     // Print unique words with its frequency
        System.out.println("\nUnique words and their frequencies:");
        for (String word : uniqueWords) {
            System.out.println(word + ": " + wordFrequency.get(word));
        }
    }

}
