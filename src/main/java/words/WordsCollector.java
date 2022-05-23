package words;

import downloader.DownloaderFactory;

import java.io.IOException;
import java.util.Map;

public class WordsCollector {

    final private Map<String, String> easyWords;
    final private Map<String, String> mediumWords;
    final private Map<String, String> hardWords;

    public WordsCollector() throws IOException {
        easyWords = DownloaderFactory.buildDownloader("txt").download("src\\wordsEasy.txt");
        mediumWords = DownloaderFactory.buildDownloader("txt").download("src\\wordsMid.txt");
        hardWords = DownloaderFactory.buildDownloader("txt").download("src\\wordsHard.txt");
    }

    Map<String, String> getEasyWords() { return easyWords; }

    Map<String, String> getMediumWords() {
        return mediumWords;
    }

    Map<String, String> getHardWords() {
        return hardWords;
    }


}
