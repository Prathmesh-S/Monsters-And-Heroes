import java.util.ArrayList;
import java.util.List;

//This class is responsible for helping creat any Hero for our HeroesAndMonsters Game through subclasses.
public abstract class Hero  {
    private String name;
    private int level;
    private int experiencePoints;
    private int HP;
    private int maxHP;
    private int maxMana;
    private int MP;
    private double strength;
    private double dexterity;
    private double agility;
    private int gold;
    //private List<Item> inventory;
    private final Inventory inventory = new Inventory();
    private String heroType;
    private Weapon leftHand = null;
    private Weapon rightHand = null;
    private Armor armor = null;

    public Hero(String name, int level, int experiencePoints, int mp, int hp, int strength, int dexterity, int agility, int gold) {
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
    }

    public void levelUp() {
        if (experiencePoints > 10) {
            int additionalLevels = experiencePoints / 10;
            int remainder = experiencePoints % 10;
            level += additionalLevels;
            experiencePoints = remainder;
            System.out.println(name + " has leveled up " + additionalLevels + " times due to winning the battle and have gained boosted stats!");

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
        if (this.leftHand != null) inventory.getInventory().add(this.leftHand);
        if (this.rightHand != null && this.rightHand != this.leftHand)  inventory.getInventory().add(this.rightHand);

        inventory.getInventory().remove(newWeapon);
        this.leftHand = newWeapon;
        this.rightHand = newWeapon;
    }


    public void dequipLeftHandedWeapon() {
        if (this.leftHand != null && (this.leftHand.isUsable())) {
            if (this.leftHand.equals(this.rightHand)) this.rightHand = null;
            inventory.getInventory().add(this.leftHand);
            this.leftHand = null;
        } else if (this.leftHand != null && !(this.leftHand.isUsable())) {
            this.leftHand = null;
        }
    }

    public void dequipRightHandedWeapon() {
        if (this.rightHand != null && (this.rightHand.isUsable())) {
            if (this.rightHand.equals(this.leftHand)) this.leftHand = null;
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
