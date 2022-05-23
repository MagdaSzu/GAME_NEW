package java.game_mode;


import words.Word;
import words.WordsCreator;

import java.util.ArrayList;
import java.util.List;


class MidMode implements GameMode {

    private static final int PROPORTION_OF_MID_MODE = 12;
    private final WordsCreator wordsCreator;
    private final List<Word> midModWords;

    public MidMode(WordsCreator wordsCreator) {
        this.wordsCreator = wordsCreator;
        this.midModWords = getProportionMediumWords();
    }

    @Override
    public List<Word> words() {
        return midModWords;
    }


    private List<Word> getProportionMediumWords() {
        List<Word> words = new ArrayList<>();
        List<Word> wordsFromWordsCreator = wordsCreator.getWordsMedium();
        for (int i = 0; i < PROPORTION_OF_MID_MODE; i++) {
            words.add(RandomWord.getRandomItem(PROPORTION_OF_MID_MODE - i,
                    wordsFromWordsCreator));
        }
        wordsFromWordsCreator = wordsCreator.getWordsEasy();
        for (int i = 0; i < PROPORTION_OF_MID_MODE; i++) {
            words.add(RandomWord.getRandomItem(PROPORTION_OF_MID_MODE - i,
                    wordsFromWordsCreator));
        }
        return words;
    }
}
