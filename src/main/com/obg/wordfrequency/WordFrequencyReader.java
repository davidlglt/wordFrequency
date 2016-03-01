package main.com.obg.wordfrequency;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordFrequencyReader {

    public String read(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName), Charset.forName("ISO-8859-1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer();
        lines.forEach(stringBuffer::append);
        return stringBuffer.toString();
    }

}
