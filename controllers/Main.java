package controllers;

import java.util.*;
import utils.ScannerSingleton;

//This class hold the main method which kick-starts our program by calling gameController!
public class Main {

    public static void main(String[] args) {

        //Start GameController
        GameController gameController = new GameController();
        gameController.startGameController();
        ScannerSingleton.closeScanner();
    }
}