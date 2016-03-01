package main.com.obg.wordfrequency;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyProcessor {
    public enum SORTING {
        ASC,
        DESC;
    }


    public Map<String, Long> process(String text) {

        Stream<String> stream = Stream.of(cleanText(text).toLowerCase().split("\\W+"));

        return stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
    }

    public LinkedHashMap<String, Long> sortByFrequency(Map<String, Long> inputMap, Enum<SORTING> sorting) {
        LinkedList<Map.Entry<String, Long>> list = new LinkedList<>(inputMap.entrySet());

        if (SORTING.DESC.equals(sorting)) {
            Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        } else if (SORTING.ASC.equals(sorting)){
            Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        }
        LinkedHashMap<String, Long> result = new LinkedHashMap<>();
        for (Map.Entry<String, Long> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public String cleanText(String text) {
        String[] strings = removeSpecialCharacters(removeEndofLine(text)).split(",");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
            if (i < strings.length - 1) {
                stringBuffer.append(" ");
            }
        }
        return new String(stringBuffer.toString());
    }

    public String removeMultipleSpacesAndTrim(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public String removeEndofLine(String text) {
        return removeMultipleSpacesAndTrim(text.replaceAll(System.lineSeparator(), " "));
    }

    public String removeSpecialCharacters(String text) {
        return removeMultipleSpacesAndTrim(text.replaceAll("[^a-zA-Z]", " "));
    }



}
