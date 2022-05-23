package java.game_mode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import words.Point;
import words.Word;
import words.WordsCreator;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EasyModeTest {
    @Mock
    private WordsCreator wordsCreator;

    private EasyMode sut;

    @BeforeEach
    public void setUp() {
        Mockito.when(wordsCreator.getWordsEasy()).thenReturn(createWords(40));
        sut = new EasyMode(wordsCreator);
    }

    private List<Word> createWords(int size) {
        List<Word> wordsAll = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            wordsAll.add(new Word("łatwe", "easy", Point.EASY));
        }
        return wordsAll;
    }

    @Test
    void shouldCreateEasyMode() {
        List<Word> result = sut.words();
        List<Word> expectedWords = createWords(24);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.containsAll(expectedWords));
        Assertions.assertEquals(result.size(), 24);
    }

}