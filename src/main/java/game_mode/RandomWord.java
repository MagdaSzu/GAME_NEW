package game_mode;

import words.Word;

import java.util.List;
import java.util.Random;

class RandomWord {
    private static Random random = new Random();

    static Word getRandomItem(int range, List<Word> words) {
        Word wordFromEasy = words.get(random.nextInt(range));
        Word word = new Word(wordFromEasy.getPl(), wordFromEasy.getEng(),
                wordFromEasy.getValue());
        words.remove(wordFromEasy);
        return word;
    }
}
