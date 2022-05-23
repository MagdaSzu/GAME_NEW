package game_mode;

import words.Word;
import words.WordsCreator;

import java.util.ArrayList;
import java.util.List;


class HardMode implements GameMode {

    private static final int PROPORTION_OF_HARD_MODE = 8;
    private final WordsCreator wordsCreator;
    private final List<Word> hardModWords;

    public HardMode(WordsCreator wordsCreator) {
        this.wordsCreator = wordsCreator;
        this.hardModWords = getProportionHardModWords();
    }

    @Override
    public List<Word> words() {
        return hardModWords;
    }

    private List<Word> getProportionHardModWords() {
        List<Word> words = new ArrayList<>();
        List<Word> wordsFromWordsCreator = wordsCreator.getWordsHard();
        for (int i = 0; i < PROPORTION_OF_HARD_MODE; i++) {
            words.add(RandomWord.getRandomItem(PROPORTION_OF_HARD_MODE - i,
                    wordsFromWordsCreator));
        }
        wordsFromWordsCreator = wordsCreator.getWordsMedium();
        for (int i = 0; i < PROPORTION_OF_HARD_MODE; i++) {
            words.add(RandomWord.getRandomItem(PROPORTION_OF_HARD_MODE - i,
                    wordsFromWordsCreator));
        }
        wordsFromWordsCreator = wordsCreator.getWordsEasy();
        for (int i = 0; i < PROPORTION_OF_HARD_MODE; i++) {
            words.add(RandomWord.getRandomItem(PROPORTION_OF_HARD_MODE - i,
                    wordsFromWordsCreator));
        }
        return words;
    }
}
