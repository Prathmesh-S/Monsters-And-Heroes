package strategies;

import models.MonstersAndHeroesPlayer;
import models.Hero;
import models.Monster;

//Defines an interface that all battle strategies must implement.
public interface BattleStrategy {
    void executeStrategy(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero, Monster monster);
}
