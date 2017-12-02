package servicetest;

import com.smdg.anagrams.AnagramResults;
import com.smdg.anagrams.OutputDisplay;
import com.smdg.anagrams.service.AnagramsMatcher;
import com.smdg.anagrams.service.AnagramsMatcherImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author haran
 */
public class AnagramsMatcherImplTest {

    public AnagramsMatcherImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Test
    public void matchAnagramSHouldSuccess() {

        OutputDisplay outputDisplay = new OutputDisplay();
        AnagramResults anagramResults = new AnagramResults();
        List<String> wordList = new ArrayList<>();
        wordList.add("act");
        wordList.add("cat");

        AnagramsMatcher anagramsMatcher = new AnagramsMatcherImpl();
        anagramsMatcher.matchAnagram(wordList, anagramResults);
        List<List<String>> result = anagramResults.getResults();
        result.forEach(resultItem -> {
            assertEquals(resultItem.size(), 2);
        });

    }

    @Test
    public void matchAnagramShouldFail() {

        OutputDisplay outputDisplay = new OutputDisplay();
        AnagramResults anagramResults = new AnagramResults();
        List<String> wordList = new ArrayList<>();
        wordList.add("adt");
        wordList.add("cat");

        AnagramsMatcher anagramsMatcher = new AnagramsMatcherImpl();
        anagramsMatcher.matchAnagram(wordList, anagramResults);
        List<List<String>> result = anagramResults.getResults();
        result.forEach(resultItem -> {
            assertEquals(resultItem.size(), 0);
        });

    }

    @Test(expected = NullPointerException.class)
    public void matchAnagramNullWordListShouldFail() {

        OutputDisplay outputDisplay = new OutputDisplay();
        AnagramResults anagramResults = new AnagramResults();
        List<String> wordList = null;
        AnagramsMatcher anagramsMatcher = new AnagramsMatcherImpl();
        anagramsMatcher.matchAnagram(wordList, anagramResults);
        List<List<String>> result = anagramResults.getResults();
    }

    @Test
    public void matchAnagramShouldSuccessSmapletext() {

        OutputDisplay outputDisplay = new OutputDisplay();
        AnagramResults anagramResults = new AnagramResults();
        List<String> wordList = new ArrayList<>();
        wordList.add("act");
        wordList.add("cat");
        wordList.add("tree");
        wordList.add("race");
        wordList.add("care");
        wordList.add("acre");
        wordList.add("bee");

        List<String> firstExpectedAnagram = new ArrayList<>();
        firstExpectedAnagram.add("act");
        firstExpectedAnagram.add("cat");

        List<String> secondExpectedAnagram = new ArrayList<>();
        secondExpectedAnagram.add("acer");
        secondExpectedAnagram.add("care");
        secondExpectedAnagram.add("race");

        AnagramsMatcher anagramsMatcher = new AnagramsMatcherImpl();
        anagramsMatcher.matchAnagram(wordList, anagramResults);
        List<List<String>> result = anagramResults.getResults();
        assertEquals(result.size(), 2);
        result.get(0).containsAll(firstExpectedAnagram);
        result.get(1).containsAll(secondExpectedAnagram);
    }
}
   