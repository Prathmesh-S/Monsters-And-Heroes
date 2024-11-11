//A concrete class representing a spirit-type monster with unique attributes and behaviors.
public class Spirit extends Monster {
    public Spirit(String name, int level, int HP, int baseDamage, int defense, double dodgeAbility) {
        super(name, level, HP, baseDamage, defense, dodgeAbility);
    }

    @Override
    public double getDodgeAbility() {
        double dodgeAbility = super.getDodgeAbility();
        dodgeAbility = dodgeAbility * 1.1;
        return dodgeAbility;
    }
}