package game;

import words.Word;

public class GameMenager {

    Game game;
    private int points = 0;
    private int numberOfHints = 0;
    private String currentHint = "";

    public GameMenager(Game game) {
        this.game = game;
    }


    public int getPoints() {
        return points;
    }

    public Word getCurrentWord() {
        return game.getCurrentWord();
    }

    public void setNewCurrentWord() {
        game.setNewCurrentWord();
    }

    public boolean checkAnswer(String answer) {
        if (game.isGoodAnswer(answer)) {
            points += game.getCurrentWord().getValue().getValue();
            return true;
        }
        return false;
    }

    public String giveHint() {
        points--;
        currentHint += game.getCurrentWord().getEng().charAt(numberOfHints++);
        return currentHint;
    }

    public void clearHint() {
        currentHint = "";
        numberOfHints = 0;
    }

}
