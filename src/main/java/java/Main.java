package java;

import presenter.GameConsolePresenter;
import presenter.Presenter;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {


        Presenter presenter = new GameConsolePresenter();
        presenter.showGame();
    }
}
