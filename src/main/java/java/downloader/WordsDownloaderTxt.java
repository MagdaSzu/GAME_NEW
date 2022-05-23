package java.downloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsDownloaderTxt implements Downloader {


    @Override
    public Map<String, String> download(String path) throws IOException {
        return getWordsFromFile(path);
    }

    private Map<String, String> getWordsFromFile(String filePath) throws IOException {

        Map<String, String> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = null;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(":");

            String key = parts[0].trim();
            String value = parts[1].trim();

            if (!key.equals("") && !value.equals(""))
                map.put(key, value);
        }
        return map;
    }
}
