package java.words;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WordsCreatorTest {

    @Mock
    private WordsCollector wordsCollector;

    @InjectMocks
    private WordsCreator sut;

    private Map<String, String> createEasyWords() {
        Map<String, String> expectedWords = new HashMap<>();
        expectedWords.put("jabłko", "apple");
        expectedWords.put("drewno", "wood");
        expectedWords.put("kamień", "stone");
        expectedWords.put("zamek", "castle");

        return expectedWords;
    }

    @Test
    void shouldCreateWordsEasy() {
        Mockito.when(wordsCollector.getEasyWords()).thenReturn(createEasyWords());

        List<Word> result = sut.getWordsEasy();
        List<Word> expected = Arrays.asList(new Word("jabłko", "apple", Point.EASY),
                new Word("drewno", "wood", Point.EASY),
                new Word("kamień", "stone", Point.EASY),
                new Word("zamek", "castle", Point.EASY));

        Assertions.assertNotNull(result);
        Assertions.assertTrue(expected.containsAll(result));
    }
}