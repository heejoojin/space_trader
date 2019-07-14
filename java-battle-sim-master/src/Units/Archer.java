package Units;

/**
 *
 * @author JaredWicklein
 */
public class Archer extends Unit
{
    public Archer(int team, int xPosition, int yPosition)
    {
        this.team = team;
        unitType = "Archer";
        
        maxHealth = 15;
        health = 15;
        weaponDamage = 5;
        percentArmor = 15;
        maxCooldown = 1;
        currentCooldown = 0;
        attackRange = 100;
        numAttacksPerAction = 5;
        attackHitPercentChance = 60;
        unitSize = 1;
        movementSpeed = 25;
        pointValue = 15;
        initiative = rng.nextInt(15) + 1;
        
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        
        damageDealt = 0;
        unitsKilled = 0;
        
    }

}
