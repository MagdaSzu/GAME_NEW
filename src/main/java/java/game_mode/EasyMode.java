package java.game_mode;


import words.Word;
import words.WordsCreator;

import java.util.ArrayList;
import java.util.List;

class EasyMode implements GameMode {

    private static final int PROPORTION_OF_EASY_MODE = 24;
    private final WordsCreator wordsCreator;
    private final List<Word> easyModWords;

    EasyMode (WordsCreator wordsCreator){
        this.wordsCreator = wordsCreator;
        this.easyModWords = getProportionEasyModWords();
    }

    @Override
    public List<Word> words() {
        return easyModWords;
    }

    private List<Word> getProportionEasyModWords() {
        List<Word> words = new ArrayList<>();
        List<Word> wordsFromWordsCreator = wordsCreator.getWordsEasy();
        for (int i = 0; i < PROPORTION_OF_EASY_MODE; i++) {
            words.add(RandomWord.getRandomItem(PROPORTION_OF_EASY_MODE - i,
                    wordsFromWordsCreator));
        }
        return words;
    }
}
