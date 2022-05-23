package java.presenter;

import game.Game;
import game.GameMenager;
import words.WordsCollector;
import words.WordsCreator;

import java.io.IOException;
import java.util.Scanner;

public class GameConsolePresenter implements Presenter {

    String chooseLevel;
    String answer;

    @Override
    public void showGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witamy w grze, wybierz poziom pomiędzy Easy, Mid, Hard" );
        this.chooseLevel = scanner.nextLine();
        WordsCollector wordsCollector = new WordsCollector();
        WordsCreator wordsCreator = new WordsCreator(wordsCollector);
        Game game = new Game(chooseLevel, wordsCreator);
        GameMenager gameMenager = new GameMenager(game);


        while (!game.getListWithWords().isEmpty()){
            System.out.println("Podaj angielskie słówko");
            System.out.println(gameMenager.getCurrentWord().getPl());
            this.answer = scanner.nextLine();
            if (gameMenager.checkAnswer(answer)){
                gameMenager.setNewCurrentWord();
                System.out.println("Twoja liczba punktów: " + gameMenager.getPoints());
                gameMenager.clearHint();
            } else {
                System.out.print("Twoja odpowiedz jest zła, oto podpowiedź: ");
                System.out.println(gameMenager.giveHint());
                System.out.println("Został Ci odjęty punkt, pozostała liczba punktów: " + gameMenager.getPoints());
            }
        }
        if (game.getListWithWords().isEmpty()) {
            System.out.println("Gra skończona, twoja liczba punktów: " + gameMenager.getPoints());
        }
    }

    //Wyświetlanie slowek
    //Wyświetlanie czy odpowiedz byla dobra lub zła
    //Wyświetlanie podpowiedzi
    //Wyswietlanie ilosci punktow
    //wyswietlanie ostatecznego wyniku uzytkownika na danym poziomie
}
