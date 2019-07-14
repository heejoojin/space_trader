package Units;

/**
 *
 * @author JaredWicklein
 */
public class Infantry extends Unit
{
    public Infantry(int team, int xPosition, int yPosition)
    {
        this.team = team;
        unitType = "Infantry";
        
        maxHealth = 25;
        health = 25;
        weaponDamage = 5;
        percentArmor = 35;
        maxCooldown = 0;
        currentCooldown = 0;
        attackRange = 2;
        numAttacksPerAction = 2;
        attackHitPercentChance = 80;
        unitSize = 1;
        movementSpeed = 30;
        pointValue = 25;
        initiative = rng.nextInt(20) + 1;
        
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        
        damageDealt = 0;
        unitsKilled = 0;
        
    }
}
