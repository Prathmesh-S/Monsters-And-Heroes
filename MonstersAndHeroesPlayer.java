import java.util.ArrayList;
import java.util.List;

//This class is responsible for creating players for the board game MonstersAndHeroes
// and houses information specific to each player for that game, such as the player's location.
public class MonstersAndHeroesPlayer extends Player {
    int currentBoxID;
    List<Hero> heroes = new ArrayList<Hero>();
    public MonstersAndHeroesPlayer(String name, int numHeroes) {
        super(name);
        HeroFactoryManager heroFactory = new HeroFactoryManager(numHeroes);
        heroes = heroFactory.getHeroes();
    }

    public int getCurrentBoxID() {
        return currentBoxID;
    }

    public void setCurrentBoxID (int currentBoxID) {
        this.currentBoxID = currentBoxID;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void displayHeroesInTableFormat(){
        HeroFactoryManager.displayHeroesInTableFormat(heroes);
    }
}
