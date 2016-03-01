package test.com.obg.wordfrequency;

import main.com.obg.wordfrequency.WordFrequencyProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class WordFrequencyProcessorTest {

    WordFrequencyProcessor wordFrequencyProcessor = new WordFrequencyProcessor();

    @Test
    public void testProcess() throws Exception {
        Map<String, Long> result = wordFrequencyProcessor.process("kenzi is there is he?who?kenzi!\nwhere?" +
                "there.");
        Map<String, Long> expected = new HashMap<>();

        expected.put("kenzi", 2l);
        expected.put("is", 2l);
        expected.put("there", 2l);
        expected.put("he", 1l);
        expected.put("where", 1l);
        expected.put("he", 1l);
        expected.put("who", 1l);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSortingByFrequencyDesc() {
        Map<String, Long> inputMap = new HashMap<String, Long>();
        inputMap.put("the", 4l);
        inputMap.put("end", 8l);
        inputMap.put("there", 1l);
        inputMap.put("is", 2l);
        LinkedHashMap<String, Long> expectedMap = new LinkedHashMap<>();
        expectedMap.put("end", 8l);
        expectedMap.put("the", 4l);
        expectedMap.put("is", 2l);
        expectedMap.put("there", 1l);
        List<Map.Entry<String, Long>> expectedList = new LinkedList<>(expectedMap.entrySet());
        Assert.assertEquals(expectedList, new LinkedList<>(wordFrequencyProcessor.sortByFrequency(inputMap, WordFrequencyProcessor.SORTING.DESC).entrySet()));
    }

    @Test
    public void testSortingByFrequencyAsc() {
        Map<String, Long> inputMap = new HashMap<String, Long>();
        inputMap.put("the", 4l);
        inputMap.put("end", 8l);
        inputMap.put("there", 1l);
        inputMap.put("is", 2l);
        LinkedHashMap<String, Long> expectedMap = new LinkedHashMap<>();
        expectedMap.put("there", 1l);
        expectedMap.put("is", 2l);
        expectedMap.put("the", 4l);
        expectedMap.put("end", 8l);
        List<Map.Entry<String, Long>> expectedList = new LinkedList<>(expectedMap.entrySet());
        Assert.assertEquals(expectedList, new LinkedList<>(wordFrequencyProcessor.sortByFrequency(inputMap, WordFrequencyProcessor.SORTING.ASC).entrySet()));
    }

    @Test
    public void testRemoveSpecialCharacters() throws Exception {
        String textWithSpecialChars = "Oualid est-il dans la cuisine ?il y est ?qui?Oualid!ou ça ???dans la cuisine!!!";
        String expected = "Oualid est il dans la cuisine il y est qui Oualid ou a dans la cuisine";

        Assert.assertEquals(expected, wordFrequencyProcessor.removeSpecialCharacters(textWithSpecialChars));
    }



    @Test
    public void testRemoveEndOfLine() throws Exception {
        String textWithSpecialChars = "Oualid est dans la cuisine\nOualid Bg";
        String expected = "Oualid est dans la cuisine Oualid Bg";

        Assert.assertEquals(expected, wordFrequencyProcessor.removeEndofLine(textWithSpecialChars));
    }

    @Test
    public void testRemoveMultipleEndOfLine() throws Exception {
        String textWithSpecialChars = "Oualid est dans la cuisine\n\n\n\nOualid Bg";
        String expected = "Oualid est dans la cuisine Oualid Bg";

        Assert.assertEquals(expected, wordFrequencyProcessor.removeEndofLine(textWithSpecialChars));
    }


    @Test
    public void testRemoveMultipleSpaces() throws Exception {
        String textWithSpecialChars = "Oualid        est dans la cuisine Oualid Bg";
        String expected = "Oualid est dans la cuisine Oualid Bg";

        Assert.assertEquals(expected, wordFrequencyProcessor.removeMultipleSpacesAndTrim(textWithSpecialChars));
    }

    @Test
    public void testRemoveSpecialCharactersWithManyDots() throws Exception {
        String textWithSpecialChars = "Oualid est dans la cuisine..... Oualid Bg.";
        String expected = "Oualid est dans la cuisine Oualid Bg";

        Assert.assertEquals(expected, wordFrequencyProcessor.removeSpecialCharacters(textWithSpecialChars));
    }

    @Test
    public void testcleanTextWithMultipleSpaces() throws Exception {
        String textWithSpecialChars = "Oualid est dans la      cuisine Oualid Bg";
        String expected = "Oualid est dans la cuisine Oualid Bg";

        Assert.assertEquals(expected, wordFrequencyProcessor.cleanText(textWithSpecialChars));
    }

    @Test
    public void testcleanTextWithEndOfLine() throws Exception {
        String textWithSpecialChars = "Oualid est dans la cuisine\n\n\n\nOualid Bg";
        String expected = "Oualid est dans la cuisine Oualid Bg";

        Assert.assertEquals(expected, wordFrequencyProcessor.cleanText(textWithSpecialChars));
    }

    @Test
    public void testCleanTextWithManyDots() throws Exception {
        String textWithSpecialChars = "Oualid est dans la cuisine..... Oualid Bg.";
        String expected = "Oualid est dans la cuisine Oualid Bg";

        Assert.assertEquals(expected, wordFrequencyProcessor.cleanText(textWithSpecialChars));
    }

}