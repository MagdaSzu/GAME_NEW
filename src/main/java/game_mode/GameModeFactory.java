package game_mode;

import words.WordsCreator;

public class GameModeFactory {
    public static GameMode selectGameMode(String level, WordsCreator wordsCreator) {
        if (level.equals("Easy")) {
            return new EasyMode(wordsCreator);
        } else if (level.equals("Mid")) {
            return new MidMode(wordsCreator);
        } else if (level.equals("Hard")) {
            return new HardMode(wordsCreator);
        } else {
            System.out.println("Zły wybór to masz najtrudniejszy poziom");
            return new HardMode(wordsCreator);
        }
    }
}
