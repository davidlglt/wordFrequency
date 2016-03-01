package main.com.obg.wordfrequency;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class WordFrequencyWriter {

    private final static String WORD_HEADER = "Word";
    private final static String FREQUENCY_HEADER = "Frequency";

    public void write(Map<String, Long> inputMap, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.append(WORD_HEADER).append(",").append(FREQUENCY_HEADER).append(System.lineSeparator());

            for (String key : inputMap.keySet()) {
                if (!"".equals(key) && key.length() > 1) {
                    fileWriter.append(key).append(',').append(Long.toString(inputMap.get(key))).append(System.lineSeparator());
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
