package Units;

/**
 *
 * @author JaredWicklein
 */
public class HeavyKnight extends Unit
{
    public HeavyKnight(int team, int xPosition, int yPosition)
    {
        this.team = team;
        unitType = "Heavy Knight";
        
        maxHealth = 100;
        health = 100;
        weaponDamage = 50;
        percentArmor = 75;
        maxCooldown = 2;
        currentCooldown = 0;
        attackRange = 3;
        numAttacksPerAction = 1;
        attackHitPercentChance = 40;
        unitSize = 2;
        movementSpeed = 10;
        pointValue = 100;
        initiative = rng.nextInt(100) + 1;
        
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        
        damageDealt = 0;
        unitsKilled = 0;
        
    }
}
