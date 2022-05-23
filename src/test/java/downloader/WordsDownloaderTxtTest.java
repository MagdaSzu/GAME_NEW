package downloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsDownloaderTxtTest {

    private WordsDownloaderTxt sut = new WordsDownloaderTxt();

    @Test
    void shouldDownloadWordsFromTxtEasy() throws IOException {

        Map<String, String> result = sut
                .download("src\\test\\wordsEasyTest.txt");
        Map<String, String> expectedWords = new HashMap<>();
        expectedWords.put("apple", "jabłko");
        expectedWords.put("wood", "drewno");
        expectedWords.put("stone", "kamień");
        expectedWords.put("castle", "zamek");

        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals(expectedWords, result);
    }

    @Test
    void shouldNotFindFile() {
        FileNotFoundException thrown = assertThrows(FileNotFoundException.class,
                () -> sut.download("src\\test\\wrdsEasyTest.txt"));
    }

}