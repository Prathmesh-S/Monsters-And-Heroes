//This class is responsible for helping creat any Monster for our HeroesAndMonsters Game through subclasses.
public abstract class Monster  {
    private String name;
    private int level;
    private int HP;
    private double baseDamage;
    private double defense;
    private double dodgeAbility;
    private String monsterType;

    public Monster(String name, int level, int HP, int baseDamage, int defense, double dodgeAbility) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.dodgeAbility = dodgeAbility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public double getDodgeAbility() {
        return dodgeAbility;
    }

    public void setDodgeAbility(double dodgeAbility) {
        this.dodgeAbility = dodgeAbility;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public boolean equals(Object o) {
        Monster x = (Monster) o;
        if (this.name.equals(x.getName())) {
            return true;
        }
        return false;
    }

}
