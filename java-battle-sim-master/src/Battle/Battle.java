package Battle;

import Units.*;
import lists.*;
import heap.*;

import java.util.Random;

/**
 *
 * @author JaredWicklein
 */
public class Battle
{
    //holds the first team
    private Unit[] team1;
    //holds the second team
    private Unit[] team2;
    
    //represents how many units are left in each team.
    private int team1Size;
    private int team2Size;
    
    //an ordered list of all units from both teams, ordered by their initiative
    private OrderedListADT<Unit> allUnits;
    
    private Random rng = new Random();
    
    public Battle()
    {
        
    }
    
    //generates two teams and places units randomly among the top and bottom of the battlefield, depending on their team.
    public void populateBattle() throws Exception
    {
        team1Size = 1000;
        team2Size = 1000;
        
        //team 1 is located on the bottom of the map.
        team1 = new Unit[1000];
        //team 2 is located at the top of the map.
        team2 = new Unit[1000];
        
        allUnits = new OrderedArrayList<>();
        
        
        //Add Infantry
        for (int index = 0; index < 500; index++)
        {
            //team 1
            Unit infantryTeam1 = new Infantry(1, rng.nextInt(2000) + 1, rng.nextInt(50) + 1);
            team1[index] = infantryTeam1;
            allUnits.add(infantryTeam1);
            
            
            //team 2
            Unit infantryTeam2 = new Infantry(2, rng.nextInt(2000) + 1, rng.nextInt(50) + 1951);
            team2[index] = infantryTeam2;
            allUnits.add(infantryTeam2);
        }
        
        //Add Cavalry
        for (int index = 500; index < 700; index++)
        {
            //team 1
            Unit cavalryTeam1 = new Cavalry(1, rng.nextInt(2000) + 1, rng.nextInt(50) + 1);
            team1[index] = cavalryTeam1;
            allUnits.add(cavalryTeam1);
            
            //team 2
            Unit cavalryTeam2 = new Cavalry(2, rng.nextInt(2000) + 1, rng.nextInt(50) + 1951);
            team2[index] = cavalryTeam2;
            allUnits.add(cavalryTeam2);
        }
        
        //add archers
        for (int index = 700; index < 900; index++)
        {
            //team 1
            Unit archerTeam1 = new Archer(1, rng.nextInt(2000) + 1, rng.nextInt(50) + 1);
            team1[index] = archerTeam1;
            allUnits.add(archerTeam1);
            
            //team 2
            Unit archerTeam2 = new Archer(2, rng.nextInt(2000) + 1, rng.nextInt(50) + 1951);
            team2[index] = archerTeam2;
            allUnits.add(archerTeam2);
        }
        
        //add heavy knights
        for (int index = 900; index < 1000; index++)
        {
            //team 1
            Unit heavyKnightTeam1 = new HeavyKnight(1, rng.nextInt(2000) + 1, rng.nextInt(50) + 1);
            team1[index] = heavyKnightTeam1;
            allUnits.add(heavyKnightTeam1);
            
            //team 2
            Unit heavyKnightTeam2 = new HeavyKnight(2, rng.nextInt(2000) + 1, rng.nextInt(50) + 1951);
            team2[index] = heavyKnightTeam2;
            allUnits.add(heavyKnightTeam2);
        }
        
    }
    
    //runs the battle, prints the results.
    public void runSimulation() throws Exception
    {
        
        populateBattle();
        
        //ensures that the Units keep taking turns until one of the teams runs out of alive units.
        while (team1Size > 0 && team2Size > 0)
            
            //iterates over the allUnits OrderedList, so that Units take turns in order of initiative.
            for (Unit currentUnit: allUnits)
            {
                //check to make sure this unit isn't dead.
                if (!currentUnit.isDead())
                {
                    Unit closestEnemy = null;
                    
                    //try to find the closest enemy unit.
                    //if no enemy unit is found, then there are no enemies left, and this units team has won.
                    try
                    {
                        closestEnemy = findClosestEnemy(currentUnit);
                    }
                    catch (ArrayIndexOutOfBoundsException exception)
                    {
                        
                        analyzeResults();
                        return;
                    }
                    
                    //move this unit towards the closest enemy.
                    currentUnit.moveTowards(closestEnemy);
                    
                    //check is this unit is within range of the closest enemy.
                    if (currentUnit.calculateDistanceFrom(closestEnemy) - closestEnemy.getUnitSize() < currentUnit.getAttackRange())
                    {
                        //attack the closest enemy
                        if (currentUnit.attack(closestEnemy))
                        {
                            if (closestEnemy.getTeam() == 1)
                            {
                                team1Size--;
                            }
                            
                            else if (closestEnemy.getTeam() == 2)
                            {
                                team2Size--;
                            }
                            
                            
                        }
                    }
                }
            }
        
    }
    
    //finds and returns the closest enemy Unit.
    private Unit findClosestEnemy(Unit currentUnit)
    {
        //team 1
        if (currentUnit.getTeam() == 1)
        {
            //chooses the first non dead enemy as its default currentclosest. If it can't find a non dead enemy, this will throw an Exception.
            Unit currentClosest = null;
            int i = 0;
            while (currentClosest == null)
            {
                if (!team2[i].isDead())
                {
                    currentClosest = team2[i];
                }
                i++;
            }
            
            
            //iterates through the rest of the enemy team array
            for (int index = 0; index < team2.length; index++)
            {
                //if this units distance is less than the currentClosest's distance, this unit becomes currentClosest.
                if (currentUnit.calculateDistanceFrom(team2[index]) < currentUnit.calculateDistanceFrom(currentClosest) && !team2[index].isDead())
                {
                    currentClosest = team2[index];
                }
            }
            return currentClosest;
        }
        
        //team 2
        else
        {
            Unit currentClosest = null;
            
            int i = 0;
            while (currentClosest == null)
            {
                if (!team1[i].isDead())
                {
                    currentClosest = team1[i];
                }
                i++;
            }
            
            for (int index = 0; index < team1.length; index++)
            {
                if (currentUnit.calculateDistanceFrom(team1[index]) < currentUnit.calculateDistanceFrom(currentClosest) && !team1[index].isDead())
                {
                    currentClosest = team1[index];
                }
            }
            return currentClosest;
        }
    }
    
    public void analyzeResults()
    {
        //check which team has run out of units. Print that the other team has won.
        if (team1Size == 0)
        {
            System.out.println("Team 2 Wins!");
        }
        
        else if (team2Size == 0)
        {
            System.out.println("Team 1 Wins!");
        }
        
        //creates a new unordered list of Units
        //this will be used to store the surviving units.
        UnorderedListADT<Unit> survivors = new UnorderedArrayList<Unit>();
        
        //iterate through all units, if they are still alive add them to the survivor list.
        for (Unit currentUnit: allUnits)
        {
            if (!currentUnit.isDead())
            {
                survivors.addToFront(currentUnit);
            }
        }
        
        //ints representing how many of each unit type survived.
        int survivingInfantry = 0;
        int survivingCavalry = 0;
        int survivingArchers = 0;
        int survivingKnights = 0;
        
        //iterates through the survivor list, checking what type of unit each survivor is.
        for (Unit currentUnit: survivors)
        {
            if (currentUnit.getUnitType().equals("Infantry"))
            {
                survivingInfantry++;
            }
            
            if (currentUnit.getUnitType().equals("Cavalry"))
            {
                survivingCavalry++;
            }
            
            if (currentUnit.getUnitType().equals("Archer"))
            {
                survivingArchers++;
            }
            
            if (currentUnit.getUnitType().equals("Heavy Knight"))
            {
                survivingKnights++;
            }
        }
        
        //print the numbers of surviving units.
        System.out.println("\nSurviving Units:\n");
        System.out.println("Infantry: " + survivingInfantry);
        System.out.println("Cavalry: " + survivingCavalry);
        System.out.println("Archers: " + survivingArchers);
        System.out.println("Heavy Knights: " + survivingKnights);
        
        
        //POINTS LOST
        
        int team1PointsLost = 0;
        int team2PointsLost = 0;
        
        //iterate over all units
        for (Unit currentUnit: allUnits)
        {
            //team 1
            if (currentUnit.getTeam() == 1)
            {
                //calculates and adds the number of points this unit lost to its team's total.
                team1PointsLost += ((1 - (currentUnit.getHealth() / currentUnit.getMaxHealth())) * currentUnit.getPointValue());
            }
            
            //team 2
            else if (currentUnit.getTeam() == 2)
            {
                //calculates and adds the number of points this unit lost to its team's total.
                team2PointsLost += ((1 - (currentUnit.getHealth() / currentUnit.getMaxHealth())) * currentUnit.getPointValue());
            }
        }
        
        //print points lost
        System.out.println("\nTeam 1 Points Lost: " + team1PointsLost);
        System.out.println("Team 2 Points Lost: " + team2PointsLost);
        
        
        //creates a new Unit array which will hold all units, and will be sorted by DamageDone.
        Unit[] compareDamageDone = new Unit[2000];
        
        //copy allUnits OrderedList into the new array.
        int index = 0;
        for (Unit currentUnit: allUnits)
        {
            compareDamageDone[index] = currentUnit;
            index++;
        }
        
        //sort the new array by damage done.
        quickSortDamageDealt(compareDamageDone);
        
        //the unit which did the most damage will be at the end of the new array.
        Unit mostDamageDealt = compareDamageDone[compareDamageDone.length - 1];
        
        //print this unit using toString.
        System.out.println("\nUnit that dealt most damage:\n\n" + mostDamageDealt.toString());
        
        
        
        
        //creates a new Unit array which will hold all units, and will be sorted by unitsKilled.
        Unit[] compareEnemiesKilled = new Unit[2000];
        
        //copy allUnits OrderedList into the new array.
        int index2 = 0;
        for (Unit currentUnit: allUnits)
        {
            compareEnemiesKilled[index2] = currentUnit;
            index2++;
        }
        
        //sort the new array by the number of Units killed.
        quickSortUnitsKilled(compareEnemiesKilled);
        
        //the unit which killed the most enemies will be at the end of the new array.
        Unit mostUnitsKilled = compareEnemiesKilled[compareEnemiesKilled.length - 1];
        
        //print a toString representation of the unit.
        System.out.println("\nUnit that killed the most enemies:\n\n" + mostUnitsKilled.toString());
    }
    
    //SORTING METHODS
    
    //sorts a Unit array by x Position.
    //originally I used this to find which units were in range.
    private void quickSortXPosition(Unit[] data)
    {
        quickSortXPosition(data, 0, data.length - 1);
    }
    
    private static void quickSortXPosition(Unit[] data, int min, int max)
    {
        if (min < max)
        {
            int indexofpartition = partitionXPosition(data, min, max);
            
            quickSortXPosition(data, min, indexofpartition - 1);
            
            quickSortXPosition(data, indexofpartition + 1, max);
        }
    }
    
    private static int partitionXPosition(Unit[] data, int min, int max)
    {
        Unit partitionelement;
        int left, right;
        int middle = (min + max)/2;
        
        partitionelement = data[middle];
        
        swap(data, middle, min);
        left = min;
        right = max;
        
        while (left < right)
        {
            while (left < right && data[left].getX().compareTo(partitionelement.getX()) <= 0)
            {
                left++;
            }
            
            while (data[right].getX().compareTo(partitionelement.getX()) > 0)
            {
                right--;
            }
            
            if (left < right)
            {
                swap(data, left, right);
            }
        }
        
        swap(data, min, right);
        return right;
    }
    
    private static void swap(Unit[] data, int index1, int index2)
    {
        Unit temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    
    
    
    
    //sorts a Unit array by y Position.
    //originally I used this to find which units were in range.
    private void quickSortYPosition(Unit[] data)
    {
        quickSortYPosition(data, 0, data.length - 1);
    }
    
    private static void quickSortYPosition(Unit[] data, int min, int max)
    {
        if (min < max)
        {
            int indexofpartition = partitionYPosition(data, min, max);
            
            quickSortYPosition(data, min, indexofpartition - 1);
            
            quickSortYPosition(data, indexofpartition + 1, max);
        }
    }
    
    private static int partitionYPosition(Unit[] data, int min, int max)
    {
        Unit partitionelement;
        int left, right;
        int middle = (min + max)/2;
        
        partitionelement = data[middle];
        
        swap(data, middle, min);
        left = min;
        right = max;
        
        while (left < right)
        {
            while (left < right && data[left].getY().compareTo(partitionelement.getY()) <= 0)
            {
                left++;
            }
            
            while (data[right].getY().compareTo(partitionelement.getY()) > 0)
            {
                right--;
            }
            
            if (left < right)
            {
                swap(data, left, right);
            }
        }
        
        swap(data, min, right);
        return right;
    }
    
    
    //sorts a Unit array by damageDealt Position.
    //originally I used this to find which units were in range.
    private void quickSortDamageDealt(Unit[] data)
    {
        quickSortDamageDealt(data, 0, data.length - 1);
    }
    
    private static void quickSortDamageDealt(Unit[] data, int min, int max)
    {
        if (min < max)
        {
            int indexofpartition = partitionDamageDealt(data, min, max);
            
            quickSortDamageDealt(data, min, indexofpartition - 1);
            
            quickSortDamageDealt(data, indexofpartition + 1, max);
        }
    }
    
    private static int partitionDamageDealt(Unit[] data, int min, int max)
    {
        Unit partitionelement;
        int left, right;
        int middle = (min + max)/2;
        
        partitionelement = data[middle];
        
        swap(data, middle, min);
        left = min;
        right = max;
        
        while (left < right)
        {
            while (left < right && data[left].getDamageDealt().compareTo(partitionelement.getDamageDealt()) <= 0)
            {
                left++;
            }
            
            while (data[right].getDamageDealt().compareTo(partitionelement.getDamageDealt()) > 0)
            {
                right--;
            }
            
            if (left < right)
            {
                swap(data, left, right);
            }
        }
        
        swap(data, min, right);
        return right;
    }
    
    
    //sorts a Unit array by enemies killed Position.
    //originally I used this to find which units were in range.
    private void quickSortUnitsKilled(Unit[] data)
    {
        quickSortUnitsKilled(data, 0, data.length - 1);
    }
    
    private static void quickSortUnitsKilled(Unit[] data, int min, int max)
    {
        if (min < max)
        {
            int indexofpartition = partitionUnitsKilled(data, min, max);
            
            quickSortUnitsKilled(data, min, indexofpartition - 1);
            
            quickSortUnitsKilled(data, indexofpartition + 1, max);
        }
    }
    
    private static int partitionUnitsKilled(Unit[] data, int min, int max)
    {
        Unit partitionelement;
        int left, right;
        int middle = (min + max)/2;
        
        partitionelement = data[middle];
        
        swap(data, middle, min);
        left = min;
        right = max;
        
        while (left < right)
        {
            while (left < right && data[left].getUnitsKilled().compareTo(partitionelement.getUnitsKilled()) <= 0)
            {
                left++;
            }
            
            while (data[right].getUnitsKilled().compareTo(partitionelement.getUnitsKilled()) > 0)
            {
                right--;
            }
            
            if (left < right)
            {
                swap(data, left, right);
            }
        }
        
        swap(data, min, right);
        return right;
    }
    
}

