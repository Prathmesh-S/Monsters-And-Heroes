import java.util.List;

//The main class that starts a Legends of Valor Game, managing gameplay elements and interactions between Heroes and Monsters within the game.
public class LegendsOfValor extends BoardGame {

    public LegendsOfValor(List<Player> players) {
        super("Legends Of Valor (Single-Player)", players);

    }

    @Override
    public void startGame() {
        System.out.println("\nWelcome to Legends Of Valor!");
    }

    @Override
    public void startNewRoundOfGame() {

    }
}
