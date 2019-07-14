package Units;

/**
 *
 * @author JaredWicklein
 */
public class Cavalry extends Unit
{
    public Cavalry(int team, int xPosition, int yPosition)
    {
        this.team = team;
        unitType = "Cavalry";
        
        maxHealth = 50;
        health = 50;
        weaponDamage = 15;
        percentArmor = 25;
        maxCooldown = 3;
        currentCooldown = 0;
        attackRange = 2;
        numAttacksPerAction = 1;
        attackHitPercentChance = 80;
        unitSize = 2;
        movementSpeed = 100;
        pointValue = 50;
        initiative = rng.nextInt(10) + 1;
        
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        
        damageDealt = 0;
        unitsKilled = 0;
        
    }
}
