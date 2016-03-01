import main.com.obg.wordfrequency.WordFrequencyProcessor;
import main.com.obg.wordfrequency.WordFrequencyReader;
import main.com.obg.wordfrequency.WordFrequencyWriter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Runner {

    private final static String INPUT_FILE = "in_file.txt";
    private final static String OUTPUT_FILE = "out_file.csv";

    public static void main(String[] args) {
        WordFrequencyReader wordFrequencyReader = new WordFrequencyReader();
        String input = wordFrequencyReader.read(INPUT_FILE);

        WordFrequencyProcessor wordFrequencyProcessor = new WordFrequencyProcessor();
        Map<String, Long> wordsCountMap = wordFrequencyProcessor.process(input);
        LinkedHashMap<String, Long> sortedWordsCountMap = wordFrequencyProcessor.sortByFrequency(wordsCountMap, WordFrequencyProcessor.SORTING.DESC);

        WordFrequencyWriter wordFrequencyWriter = new WordFrequencyWriter();
        wordFrequencyWriter.write(sortedWordsCountMap, OUTPUT_FILE);

    }


}
