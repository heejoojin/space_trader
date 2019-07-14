package Driver;

import Battle.Battle;

/**
 *
 * @author JaredWicklein
 */
public class Driver
{
    public static void main(String[] args) throws Exception
    {
        //create a new battle
        Battle testBattle = new Battle();
        
        //run the simulation on the battle
        testBattle.runSimulation();
    }
    
}
