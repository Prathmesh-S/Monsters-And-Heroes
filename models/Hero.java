package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.Inventory;
import controllers.LegendsOfValor;
import ui.BoardPiece;
import ui.GamePiece;
import ui.BoardGame;

//This class is responsible for helping creat any Hero for our HeroesAndMonsters Game through subclasses.
public abstract class Hero {
    private String name;
    private int level;
    private int experiencePoints;
    private int HP;
    private int maxHP;
    private int maxMana;
    private int MP;
    private double baseDefense;
    private double strength;
    private double dexterity;
    private double agility;
    private int gold;
    // private List<Item> inventory;
    private final Inventory inventory = new Inventory();
    private String heroType;
    private Weapon leftHand = null;
    private Weapon rightHand = null;
    private Armor armor = null;
    private int currentX; // Row Value
    private int currentY; // Column Value
    private String terrainType;
    private int nexusX;
    private int nexusY;
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Hero(String name, int level, int experiencePoints, int mp, int hp, int strength, int dexterity, int agility,
                double baseDefense,
                int gold) {
        this.name = name;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.HP = hp;
        this.maxHP = hp;
        this.maxMana = hp;
        this.MP = mp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.baseDefense = baseDefense;
        this.terrainType = "Plain";
    }

    public void applyTerrainBonus() {
        switch (terrainType) {
            case "B":
                System.out.println("\nYour hero has entered a bush and has received extra dexterity.");
                this.dexterity *= 1.1;
                break;
            case "C":
                System.out.println("\nYour hero has entered a cave and has received extra agility.");
                this.agility *= 1.1;
                break;
            case "K":
                System.out.println("\nYour hero has entered a koulou and has received extra strength.");
                this.strength *= 1.1;
                break;
            default:
                break;
        }
    }

    public void resetTerrainBonus() {
        switch (terrainType) {
            case "B":
                System.out.println("\nYour hero has left a bush and has lost its extra dexterity.");
                this.dexterity /= 1.1;
                break;
            case "C":
                System.out.println("\nYour hero has left a cave and has lost its extra agility.");
                this.agility /= 1.1;
                break;
            case "K":
                System.out.println("\nYour hero has left a koulou and has lost its extra strength.");
                this.strength /= 1.1;
                break;
            default:
                break;
        }
    }

    // Movement method with validation
    public boolean move(int newX, int newY, String[][] gameGrid, boolean isMonsterAhead) {
        if (isMonsterAhead || gameGrid[newX][newY].equals("Inaccessible") ||
                gameGrid[newX][newY].equals("Obstacle")) {
            System.out.println("Move not allowed.");
            return false;
        }
        resetTerrainBonus(); // Remove current terrain bonuses
        this.currentX = newX;
        this.currentY = newY;
        this.terrainType = gameGrid[newX][newY];
        applyTerrainBonus(); // Apply new terrain bonuses
        return true;
    }

    // Teleport action
    public boolean teleport(Hero targetHero, LegendsOfValor game) {
        int targetX = targetHero.getCurrentX();
        int targetY = targetHero.getCurrentY();

        // Ensure teleportation is between different lanes
        if (Math.abs(targetY - this.getCurrentY()) <= 1) {
            System.out.println("\nTeleport not allowed: Must teleport to a different lane.");
            return false;
        }

        // Collect possible adjacent positions in the target lane
        BoardPiece[][] board = game.getBoard();
        List<int[]> validPositions = new ArrayList<>();
        int[][] directions = {{1, 0}, {0, -1}, {0, 1}}; // Adjacent directions: North, South,
        // West,East
        for (int[] dir : directions) {
            int newX = targetX + dir[0];
            int newY = targetY + dir[1];

            // Check board boundaries
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
                continue;
            }

            BoardPiece targetPiece = board[newX][newY];

            //Continue if a hero exists in the space
            if ((targetPiece.getGamePieces() != null) && (targetPiece.getGamePieces().stream().anyMatch(piece -> piece.getName().startsWith("H")))) {
                continue;
            }

            // Check all teleportation conditions
            if (newX >= targetX && // Not ahead of target hero
                    targetPiece.isAccessible()) { // Not behind monsters
                validPositions.add(new int[]{newX, newY});
            }
        }
        // Abort if no valid positions
        if (validPositions.isEmpty()) {
            System.out.println("\nTeleport failed: No valid positions adjacent to the target hero.");
            return false;
        }
        // Display options to the user
        System.out.println("\nSelect a position to teleport to (Row, Column), using zero-indexing:");
        for (int i = 0; i < validPositions.size(); i++) {
            int[] pos = validPositions.get(i);
            System.out.printf("%d: (%d, %d)%n", i, pos[0], pos[1]);
        }
        // Get user choice
        Scanner scanner = new Scanner(System.in);
        int choice = BoardGame.getNumberResponse(0, validPositions.size() - 1, "index of the position you would like to teleport to.",
                "Invalid Index ", "Invalid Index ", "Please enter a valid index. ");
        // Validate choice
        if (choice < 0 || choice >= validPositions.size()) {
            System.out.println("\nInvalid choice. Teleport canceled.");
            return false;
        }
        // Perform teleport
        int[] selectedPosition = validPositions.get(choice);
        int newX = selectedPosition[0];
        int newY = selectedPosition[1];

        BoardPiece currentPiece = board[this.getCurrentX()][this.getCurrentY()];
        currentPiece.getGamePieces().removeIf(piece -> piece.getName().equals(this.getIdentifier())); // Remove hero

        BoardPiece targetPiece = board[newX][newY];
        targetPiece.addGamePiece(new GamePiece(this.getIdentifier(), "\u001B[1m\u001B[92m")); // Add hero

        this.setCurrentX(newX);
        this.setCurrentY(newY);
        this.setTerrainType(targetPiece.getType().name()); // Update terrain type
        applyTerrainBonus();

        System.out.printf("%s successfully teleported to (%d, %d).%n", this.getIdentifier(), newX, newY);
        return true;
    }

    // Recall action
    public void recall() {

        // Replace Hero X,Y coords with its nexus coords
        this.currentX = this.nexusX;
        this.currentY = this.nexusY;

        // Reset any terrain-related bonuses or effects
        resetTerrainBonus();

        // Update the hero's current terrain type to "Hero Nexus"
        setTerrainType("Hero Nexus");

        // Notify the player that the hero has successfully recalled
        System.out.printf("%s has recalled to their Nexus at (%d, %d).%n", name, currentX, currentY);
    }

    // End-of-round recovery
    public void endOfRoundRecovery() {
        this.HP = Math.min(maxHP, (int) (this.HP * 1.1));
        this.MP = Math.min(maxMana, (int) (this.MP * 1.1));
        System.out.println("\n" + name + " has recovered HP and MP.");
    }

    // Respawn after death
    public void respawn(int nexusX, int nexusY) {
        this.HP = maxHP;
        this.MP = maxMana;
        this.currentX = nexusX;
        this.currentY = nexusY;
        System.out.println(name + " has respawned at the Nexus.");
    }

    // Getters and setters for new attributes
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

    public int getNexusX() {
        return nexusX;
    }

    public void setNexusX(int nexusX) {
        this.nexusX = nexusX;
    }

    public int getNexusY() {
        return nexusY;
    }

    public void setNexusY(int nexusY) {
        this.nexusY = nexusY;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }

    public void levelUp() {
        if (experiencePoints > 10) {
            int additionalLevels = experiencePoints / 10;
            int remainder = experiencePoints % 10;
            level += additionalLevels;
            experiencePoints = remainder;
            System.out.println(name + " has leveled up " + additionalLevels
                    + " times due to winning the battle and have gained boosted stats!");

            double skillIncrease = 0.05 * (additionalLevels) + 1;
            maxHP = (int) (maxHP * skillIncrease);
            HP = maxHP;
            maxMana = (int) (maxMana * skillIncrease);
            strength = (int) (strength * skillIncrease);
            dexterity = (int) (dexterity * skillIncrease);
            agility = (int) (agility * skillIncrease);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Hero x = (Hero) o;
        if (this.name.equals(x.getName())) {
            return true;
        }
        return false;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public Inventory getInventoryObject() {
        return inventory;
    }

    public int getLevel() {
        return level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int hp) {
        HP = hp;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int mp) {
        MP = mp;
    }

    public double getStrength() {
        return strength;
    }

    public double getDexterity() {
        return dexterity;
    }

    public double getAgility() {
        return agility;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public String getHeroType() {
        return heroType;
    }

    public double getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(double baseDefense) {
        this.baseDefense = baseDefense;
    }

    public double getDefense() {
        // Calculate total defense including armor
        double totalDefense = baseDefense;
        if (armor != null) {
            totalDefense += armor.getDamageReductionValue();
        }
        return totalDefense;
    }

    public void takeDamage(double damage) {
        this.HP -= damage;
        if (this.HP < 0) {
            this.HP = 0; // Ensure HP doesn't go negative
        }
    }

    public boolean isAlive() {
        return this.HP > 0;
    }

    public void addItemToInventory(Item item) {
        this.inventory.addItemToInventory(item);
    }

    public void removeItemFromInventory(Item item) {
        this.inventory.removeItemFromInventory(item);
    }

    public void subtractGold(double gold) {
        this.gold -= (int) gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void addLevel(int level) {
        this.level += level;
    }

    public List<Item> getItemsByType(Class<?> itemType) {
        List<Item> items = new ArrayList<>();
        for (Item item : inventory.getInventory()) {
            if (itemType.isInstance(item)) {
                items.add(item);
            }
        }
        return items;
    }

    public void applyChosenPotion(Potion chosenPotion) {
        int effectAmount = chosenPotion.getEffectAmount();

        if (chosenPotion.getEffectType().contains("Health")) {
            this.HP += effectAmount;
        }
        if (chosenPotion.getEffectType().contains("Mana")) {
            this.MP += effectAmount;
        }
        if (chosenPotion.getEffectType().contains("Strength")) {
            this.strength += effectAmount;
        }
        if (chosenPotion.getEffectType().contains("Dexterity")) {
            this.dexterity += effectAmount;
        }
        if (chosenPotion.getEffectType().contains("Agility")) {
            this.agility += effectAmount;
        }
    }

    public Weapon getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Weapon leftHand) {
        this.leftHand = leftHand;
    }

    public Weapon getRightHand() {
        return rightHand;
    }

    public void setRightHand(Weapon rightHand) {
        this.rightHand = rightHand;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void equipLeftHandedWeapon(Weapon newWeapon) {
        if (this.leftHand != null && this.leftHand.equals(this.rightHand)) {
            inventory.getInventory().add(this.leftHand);
            this.rightHand = null;
        } else if (this.leftHand != null) {
            inventory.getInventory().add(this.leftHand);
        }
        inventory.getInventory().remove(newWeapon);
        this.leftHand = newWeapon;
    }

    public void equipRightHandedWeapon(Weapon newWeapon) {
        if (this.rightHand != null && this.leftHand.equals(this.rightHand)) {
            inventory.getInventory().add(this.rightHand);
            this.leftHand = null;
        } else if (this.rightHand != null) {
            inventory.getInventory().add(this.rightHand);
        }
        inventory.getInventory().remove(newWeapon);
        this.rightHand = newWeapon;
    }

    public void equipTwoHandedWeapon(Weapon newWeapon) {
        if (this.leftHand != null)
            inventory.getInventory().add(this.leftHand);
        if (this.rightHand != null && this.rightHand != this.leftHand)
            inventory.getInventory().add(this.rightHand);

        inventory.getInventory().remove(newWeapon);
        this.leftHand = newWeapon;
        this.rightHand = newWeapon;
    }

    public void dequipLeftHandedWeapon() {
        if (this.leftHand != null && (this.leftHand.isUsable())) {
            if (this.leftHand.equals(this.rightHand))
                this.rightHand = null;
            inventory.getInventory().add(this.leftHand);
            this.leftHand = null;
        } else if (this.leftHand != null && !(this.leftHand.isUsable())) {
            this.leftHand = null;
        }
    }

    public void dequipRightHandedWeapon() {
        if (this.rightHand != null && (this.rightHand.isUsable())) {
            if (this.rightHand.equals(this.leftHand))
                this.leftHand = null;
            inventory.getInventory().add(this.rightHand);
            this.rightHand = null;
        } else if (this.rightHand != null && !(this.rightHand.isUsable())) {
            this.rightHand = null;
        }
    }

    public void dequipTwoHandedWeapon() {
        if (this.leftHand != null && (this.leftHand.isUsable())) {
            inventory.getInventory().add(this.leftHand);
            this.leftHand = null;
            this.rightHand = null;
        } else if (this.leftHand != null && !(this.leftHand.isUsable())) {
            this.leftHand = null;
            this.rightHand = null;
        }
    }

    public List<Item> getEquippedWeapons() {
        List<Item> weaponList = new ArrayList<>();
        if (this.leftHand != null) {
            weaponList.add(this.leftHand);
        }
        if (this.rightHand != null && this.rightHand != this.leftHand) {
            weaponList.add(this.rightHand);
        }
        return weaponList;
    }
}
