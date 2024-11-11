//Defines an interface that all battle strategies must implement.
public interface BattleStrategy {
    void executeStrategy(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero, Monster monster);
}
