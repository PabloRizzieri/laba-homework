package extras.fileTask;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileProcessor {
    private static final Logger LOGGER = LogManager.getLogger(FileProcessor.class);

    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFile = "src/main/java/extras/fileTask/input.txt";
        String outputFile = "src/main/java/extras/fileTask/output.txt";

        try {
            // Read text from the input file
            String fileContent = FileUtils.readFileToString(new File(inputFile), "UTF-8");

            // Tokenize the text into words using StringUtils
            String[] words = StringUtils.split(fileContent);

            // Calculate the number of unique words
            int uniqueWordCount = countUniqueWords(words);

            // Write the result to the output file
            FileUtils.writeStringToFile(new File(outputFile), "Number of unique words: " + uniqueWordCount, "UTF-8");

            LOGGER.info("Operation completed successfully. The number of unique words are: " + uniqueWordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            // Ignore punctuation and convert to lowercase for case-insensitive comparison
            String cleanWord = StringUtils.strip(word, ".,;:\"'()[]{}!?").toLowerCase();
            if (!cleanWord.isEmpty()) {
                uniqueWords.add(cleanWord);
            }
        }
        return uniqueWords.size();
    }
}
