package strategies;

import models.MonstersAndHeroesPlayer;
import models.Hero;
import models.Monster;
import models.Weapon;

//Responsible for the Attack Battle Strategy A Hero inflicts on a Monster.
public class AttackStrategy implements BattleStrategy {

    @Override
    public void executeStrategy(MonstersAndHeroesPlayer monstersAndHeroesPlayer, Hero hero, Monster monster) {

        Weapon leftHandWeapon = hero.getLeftHand();
        Weapon rightHandWeapon = hero.getRightHand();
        double attackDamage = 0;

        //If we have no weapons equipped, we can't attack!
        if (leftHandWeapon == null && rightHandWeapon == null) {
            System.out.println("\nYour hero " + hero.getName() + " had no equipped weapon! They just stared at the monster!\n");
            return;
        }

        //Check if the monster has dodged!
        double dodgeChange = monster.getDodgeAbility() * 0.2 / 100;
        double randomDecimal = Math.random();
        if (randomDecimal < dodgeChange) {
            System.out.println("\nThe monster " + monster.getName() + " dodged your attack!\n");
            return;
        }

        //Check if you wield a 2 handed weapon!
        if (leftHandWeapon == rightHandWeapon) {
            attackDamage = leftHandWeapon.getDamageValue() * 1.2 + hero.getStrength();
            leftHandWeapon.useItem();
            if (!leftHandWeapon.isUsable()) {
                System.out.println("\nYour main weapon has broke and will no longer be usable next round!\n");
                hero.dequipTwoHandedWeapon();
            }
        } else {
            if (rightHandWeapon != null) {
                attackDamage = rightHandWeapon.getDamageValue() + hero.getStrength();
                rightHandWeapon.useItem();
                if (!rightHandWeapon.isUsable()) {
                    System.out.println("\nYour right-handed weapon has broke and will no longer be usable next round!\n");
                    hero.dequipRightHandedWeapon();
                }
            }

            if (leftHandWeapon != null) {
                attackDamage = leftHandWeapon.getDamageValue() + hero.getStrength();
                leftHandWeapon.useItem();
                if (!leftHandWeapon.isUsable()) {
                    System.out.println("\nYour left-handed weapon has broke and will no longer be usable next round!\n");
                    hero.dequipLeftHandedWeapon();
                }
            }
        }

        //Else, the attack was successful!

        //Damage only affected the defense of the monster!
        if (monster.getDefense() >= attackDamage) {
            System.out.println("\nYour hero " + hero.getName() + " did " + attackDamage + " damage to monster " + monster.getName() + "'s defence!\n");
            monster.setDefense((int) (monster.getDefense() - attackDamage));
        } else {
            //Damage effected the HP of the monster.

            attackDamage = attackDamage - monster.getDefense();

            System.out.println("\nYour hero " + hero.getName() + " did " + monster.getDefense() + " damage to monster " + monster.getName() + "'s defence!\n");
            monster.setDefense(0);


            System.out.println("\nYour hero " + hero.getName() + " did " + attackDamage + " damage to monster " + monster.getName() + "'s HP!\n");
            monster.setHP((int) (monster.getHP() - attackDamage));
        }

        if (monster.getHP() <= 0) {
            System.out.println("\nThe Monster has been defeated as it has lost all of its HP!\n");
        }
    }
}