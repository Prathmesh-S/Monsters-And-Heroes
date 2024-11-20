//This class is responsible for helping creat any Monster for our HeroesAndMonsters Game through subclasses.

import util.BattleUtils;

public abstract class Monster {
    private String name;
    private int level;
    private int HP;
    private double baseDamage;
    private double defense;
    private double dodgeAbility;
    private String monsterType;
    private int currentX; // Row Value
    private int currentY; // Column Value

    public Monster(String name, int level, int HP, double baseDamage, double defense, double dodgeAbility) {
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

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public boolean equals(Object o) {
        Monster x = (Monster) o;
        if (this.name.equals(x.getName())) {
            return true;
        }
        return false;
    }

    public void takeDamage(double damage) {
        double effectiveDamage = damage - this.defense;
        if (effectiveDamage > 0) {
            this.HP -= effectiveDamage;
            if (this.HP < 0) {
                this.HP = 0; // Prevents HP from going negative
            }
        }
    }

    public boolean isAlive() {
        return this.HP > 0;
    }

    public void applyTerrainBonus(String terrainType) {
        this.baseDamage = BattleUtils.applyTerrainBonus(this.baseDamage, terrainType);
        this.defense = BattleUtils.applyTerrainBonus(this.defense, terrainType);
        this.dodgeAbility = BattleUtils.applyTerrainBonus(this.dodgeAbility, terrainType);
    }

    public void removeTerrainBonus(String terrainType) {
        this.baseDamage = BattleUtils.removeTerrainBonus(this.baseDamage, terrainType);
        this.defense = BattleUtils.removeTerrainBonus(this.defense, terrainType);
        this.dodgeAbility = BattleUtils.removeTerrainBonus(this.dodgeAbility, terrainType);
    }

    // Move the monster towards heroes' Nexus
    public boolean move(String[][] gameGrid, int currentX, int currentY) {
        int nextX = currentX + 1; // Move "down" towards Nexus
        if (nextX < gameGrid.length && !gameGrid[nextX][currentY].equals("Inaccessible")) {
            System.out.println(this.name + " moved to (" + nextX + ", " + currentY + ").");
            // Update current position
            return true;
        }
        System.out.println(this.name + " could not move.");
        return false;
    }

    // Check if monster has reached the heroes' Nexus
    public boolean reachedNexus(int currentX, int nexusRow) {
        return currentX == nexusRow;
    }

    public void respawn(int nexusX, int nexusY) {
        this.HP = level * 100; // Reset HP based on level
        System.out.println(this.name + " respawned at the Nexus (" + nexusX + ", " + nexusY + ").");
        // Reset position logic (if needed)
    }

    public Monster(String name, double baseDamage) {
        this.name = name;
        this.baseDamage = baseDamage;
    }

    // Attack method
    public String attack(Hero hero) {
        if (!hero.isAlive()) {
            return hero.getName() + " is already defeated!";
        }

        double attackDamage = this.baseDamage - hero.getDefense(); // Use Hero's getDefense()
        if (attackDamage < 0) {
            attackDamage = 0; // Ensure non-negative damage
        }

        hero.takeDamage(attackDamage); // Apply damage to Hero

        return this.name + " attacked " + hero.getName() + ", causing " + attackDamage + " damage. " +
                hero.getName() + "'s remaining HP: " + hero.getHP() + ".";
    }

}
