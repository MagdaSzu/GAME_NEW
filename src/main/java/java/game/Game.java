package java.game;

import game_mode.GameMode;
import game_mode.GameModeFactory;
import words.Word;
import words.WordsCreator;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Game {

    private GameMode gameMode;
    private Word currentWord;

    public Game(String level, WordsCreator wordsCreator) throws IOException {
        this.gameMode = GameModeFactory.selectGameMode(level, wordsCreator);
        this.currentWord = getWord();
    }

    private Word getWord() {
        Word wordFromGame = gameMode.words().get(0);
        Word word = new Word(wordFromGame.getEng(), wordFromGame.getPl(), wordFromGame.getValue());
        gameMode.words().remove(0);
        return word;
    }

    public void setNewCurrentWord() {
        currentWord = getWord();
    }

    public Word getCurrentWord() {
        return currentWord;
    }

    public boolean isGoodAnswer(String answer) {
        return Objects.equals(answer, currentWord.getEng());
    }

    public List<Word> getListWithWords() {
        return gameMode.words();
    }
}
