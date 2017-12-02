package filescannertest;

import com.smdg.anagrams.filescanner.FileScanner;
import com.smdg.anagrams.OutputDisplay;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author haran
 */
public class FileScannerTest {

    public FileScannerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void scaneFileTest() {
        OutputDisplay outputDisplay = new OutputDisplay();
        FileScanner fileScanner = new FileScanner();
        String fileLocation = "/Users/haran/Downloads/sample.txt";
        List<String> wordList = new ArrayList<>();
        wordList.add("act");
        wordList.add("cat");
        wordList.add("tree");
        wordList.add("race");
        wordList.add("care");
        wordList.add("acre");
        wordList.add("bee");

        try {
            Stream<String> wordsStream = fileScanner.scaneFile(fileLocation);
            List<String> expectedAnagram = wordsStream.collect(Collectors.toList());
            assertEquals(expectedAnagram.size(), 7);
            assertEquals(expectedAnagram.get(0), wordList.get(0));
            assertEquals(expectedAnagram.get(1), wordList.get(1));
            assertEquals(expectedAnagram.get(2), wordList.get(2));
            assertEquals(expectedAnagram.get(3), wordList.get(3));
            assertEquals(expectedAnagram.get(4), wordList.get(4));
            assertEquals(expectedAnagram.get(5), wordList.get(5));
            assertEquals(expectedAnagram.get(6), wordList.get(6));
        } catch (Exception e) {
            outputDisplay.print("ERROR: The Location or filename you have enter is wrong \n" + e);
        }
    }
}
