//A factory class responsible for creating instances of Warrior.
public class Warrior extends Hero {
    public Warrior(String name, int level, int experiencePoints, int mp, int hp, int strength, int dexterity,
            int agility, double baseDefense, int gold) {
        super(name, level, experiencePoints, mp, hp, strength, dexterity, agility, baseDefense, gold);
    }

    @Override
    public double getStrength() {
        double strengh = super.getStrength();
        strengh = strengh * 1.1;
        return strengh;
    }

    @Override
    public double getAgility() {
        double agility = super.getAgility();
        agility = agility * 1.1;
        return agility;
    }

}