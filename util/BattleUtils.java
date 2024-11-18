package util;

public class BattleUtils {

    // Method to determine if a dodge is successful
    public static boolean isDodgeSuccessful(double dodgeAbility) {
        double dodgeChance = dodgeAbility * 0.2 / 100; // Adjust formula as needed
        return Math.random() < dodgeChance;
    }

    // Method to calculate effective damage after considering defense
    public static double calculateDamageAfterDefense(double attackDamage, double defense) {
        return Math.max(attackDamage - defense, 0);
    }

    // Optional: Method to apply terrain bonuses dynamically
    public static double applyTerrainBonus(double originalStat, String terrainType) {
        switch (terrainType) {
            case "Bush":
                return originalStat * 1.1;
            case "Cave":
                return originalStat * 1.1;
            case "Koulou":
                return originalStat * 1.1;
            default:
                return originalStat; // No bonus for other terrains
        }
    }

    // Optional: Method to remove terrain bonuses dynamically
    public static double removeTerrainBonus(double modifiedStat, String terrainType) {
        switch (terrainType) {
            case "Bush":
            case "Cave":
            case "Koulou":
                return modifiedStat / 1.1;
            default:
                return modifiedStat; // No changes for other terrains
        }
    }
}
