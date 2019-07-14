package Units;

import java.util.Random;
import java.math.*;

/**
 *
 * @author JaredWicklein
 */
public abstract class Unit implements Comparable<Unit>
{
    protected int team;
    protected String unitType;
    
    protected int maxHealth;
    protected int health;
    protected int weaponDamage;
    protected int percentArmor;
    protected int maxCooldown;
    protected int currentCooldown;
    protected int attackRange;
    protected int numAttacksPerAction;
    protected int attackHitPercentChance;
    protected int unitSize;
    protected int movementSpeed;
    protected Integer xPosition;
    protected Integer yPosition;
    protected int pointValue;
    protected Integer initiative;
    
    protected Integer damageDealt;
    protected Integer unitsKilled;
    
    protected Random rng = new Random();
    
    //returns true if the target is killed, false if not.
    public Boolean attack(Unit target)
    {
        if (this.currentCooldown == 0)
        {
            for (int index = 0; index < this.numAttacksPerAction; index++)
            {
                int generateHitChance = rng.nextInt(100) + 1;
                
                if (generateHitChance <= this.attackHitPercentChance)
                {
                    int generateBlockChance = rng.nextInt(100) + 1;
                    
                    if (generateBlockChance >= target.percentArmor)
                    {
                        target.health -= this.weaponDamage;
                        this.damageDealt += this.weaponDamage;
                    }
                }
            }
            
            this.resetCooldown();
        }
        else if (this.currentCooldown > 0)
        {
            this.decreaseCooldown();
        }
        
        if (target.isDead())
        {
            this.unitsKilled++;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public int getHealth()
    {
        return this.health;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }
    
    public boolean isDead()
    {
        return (health <= 0);
    }
    
    public void resetCooldown()
    {
        currentCooldown = maxCooldown;
    }
    
    public void decreaseCooldown()
    {
        currentCooldown--;
    }
    
    public int getTeam()
    {
        return team;
    }
    
    public Integer getX()
    {
        return xPosition;
    }
    
    public Integer getY()
    {
        return yPosition;
    }
    
    public int getUnitSize()
    {
        return unitSize;
    }
    
    public int getAttackRange()
    {
        return attackRange;
    }
    
    public Integer getDamageDealt()
    {
        return damageDealt;
    }
    
    public Integer getUnitsKilled()
    {
        return unitsKilled;
    }
    
    public String getUnitType()
    {
        return unitType;
    }
    
    public int getPointValue()
    {
        return pointValue;
    }
    
    //returns the distance from this unit to target unit as a double.
    public Double calculateDistanceFrom(Unit target)
    {
        Double distance;
        
        distance = Math.sqrt(((target.getX() - this.getX())*((target.getX() - this.getX())))  +  ((target.getY() - this.getY())*((target.getY() - this.getY()))));
        return distance;
    }
    
    //moves this unit closer to target unit, up to this units movement speed.
    public void moveTowards(Unit target)
    {
        
        if (this.calculateDistanceFrom(target) <= movementSpeed)
        {
            this.xPosition = target.xPosition;
            this.yPosition = target.yPosition;
        }
        
        
        else
        {
            int stepsRemaining = movementSpeed;
            
            if (this.xPosition < target.xPosition)
            {
                while (stepsRemaining > 0 && this.xPosition < target.xPosition)
                {
                    this.xPosition++;
                    stepsRemaining--;
                }
            }
            
            if (this.xPosition > target.xPosition)
            {
                while (stepsRemaining > 0 && this.xPosition > target.xPosition)
                {
                    this.xPosition--;
                    stepsRemaining--;
                }
            }
            
            if (this.yPosition < target.yPosition)
            {
                while (stepsRemaining > 0 && this.yPosition < target.yPosition)
                {
                    this.yPosition++;
                    stepsRemaining--;
                }
            }
            
            if (this.yPosition > target.yPosition)
            {
                while (stepsRemaining > 0 && this.yPosition > target.yPosition)
                {
                    this.yPosition--;
                    stepsRemaining--;
                }
            }
        }
    }
    
    //compares this unit's initiative to another unit's.
    @Override
    public int compareTo(Unit o)
    {
        return this.initiative.compareTo(o.initiative);
    }
    
    //returns a string representation of this unit and its most important values.
    @Override
    public String toString()
    {
        String returnString = ("Team: " + team);
        returnString += ("\nUnit Class: " + unitType);
        returnString += ("\nHealth: " + health);
        returnString += ("\nDamage Dealt: " + damageDealt);
        returnString += ("\nEnemies Killed: " + unitsKilled);
        
        return returnString;
    }
}
