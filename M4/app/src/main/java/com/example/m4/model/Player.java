package com.example.m4.model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This class represents a player object
 */
public class Player {

    /** this player's credits */
    private int credits;

    /** this player's pilot skill points */
    private int pilotPoints;

    /** this player's fighter skill points */
    private int fighterPoints;

    /** this player's trader skill points */
    private int traderPoints;

    /** this player's trader skill points */
    private int engineerPoints;

    /** this player's name */
    private String name;

    /** this player's ship */
    private String ship;

    private String specialWeapon;

    private Difficulty difficulty;

    private int fuel;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

//    /**
//     * Default constructor required for calls to DataSnapshot.getValue(Player.class)
//     */
//    public Player() {
//        // Default constructor required for calls to DataSnapshot.getValue(User.class)
//    }

    /**
     * Constructor that sets up the inital player information
     * @param name name of the player
     * @param pilotPoints number of points the user put into pilot
     * @param fighterPoints number of points the user put into fighter
     * @param traderPoints number of points the user put into trader
     * @param engineerPoints number of points the user put into engineer
     */
    public Player(String name, int pilotPoints, int fighterPoints,
                  int traderPoints, int engineerPoints) {
        if ((pilotPoints + fighterPoints
                + traderPoints + engineerPoints) >16) {
            throw new IllegalArgumentException("Total skill points"
                    + "cannot exceed 16");
        }
        this.credits = 1000;
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = "Gnat";
        this.specialWeapon = "No Special Weapon";
        this.fuel = 3203760;
        // private DatabaseReference databaseReference =
        // FirebaseDatabase.getInstance().getReference();
        databaseReference.child("user").
                child("name").setValue(this.name);

//        databaseReference.child("user").
//                child("difficulty").setValue(this.difficulty.toString());

        databaseReference.child("user").
                child("credits").setValue(this.credits);

        databaseReference.child("user").
                child("pilot").setValue(this.pilotPoints);

        databaseReference.child("user").
                child("trader").setValue(this.traderPoints);

        databaseReference.child("user").
                child("engineer").setValue(this.engineerPoints);

        databaseReference.child("user").
                child("fighter").setValue(this.fighterPoints);

        databaseReference.child("user").
                child("ship").setValue(this.ship);

        databaseReference.child("user").
                child("fuel").setValue(this.fuel);

        databaseReference.child("user").
                child("special weapon").setValue(this.specialWeapon);
    }

    //Getters and setters required for accessing the fields

    /**
     * get Fuel
     * @return int of fuel
     */
    public int getFuel() { return this.fuel; }

    /**
     * get Credits
     * @return int of credits
     */
    public int getCredits() { return this.credits; }

    /**
     * get Pilot Points
     * @return int pilot points
     */
    public int getPilotPoints() { return this.pilotPoints; }

    /**
     * get Fighter Points
     * @return int fighter Points
     */
    public int getFighterPoints() { return this.fighterPoints; }

    /**
     * get Trader Points
     * @return int trader points
     */
    public int getTraderPoints() { return this.traderPoints; }

    /**
     * get engineer points
     * @return int engineer points
     */
    public int getEngineerPoints() {return this.engineerPoints; }

    /**
     * get Name
     * @return string of name
     */
    public String getName() {return this.name; }

    /**
     * get ship
     * @return string of ship
     */
    public String getShip() {return this.ship;}

    /**
     * get speicalWeapon
     * @return string speicalWeapon
     */
    public String getSpecialWeapon() {return this.specialWeapon;}

    /**
     * get difficulty
     * @return Difficulty enum
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * set credits
     * @param credits int
     */
    public void setCredits(int credits) {
        this.credits = credits;
        databaseReference.child("user").
                child("credits").setValue(this.credits);

    }

    /**
     * set pilot points
     * @param pilotPoints int
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
        databaseReference.child("user").
                child("pilot").setValue(this.pilotPoints);
    }

    /**
     * set Fighter Points
     * @param fighterPoints int
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
        databaseReference.child("user").
                child("fighter").setValue(this.fighterPoints);


    }

    /**
     * set trader points
     * @param traderPoints int
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
        databaseReference.child("user").
                child("trader").setValue(this.traderPoints);
    }

    /**
     * set engineer points
     * @param engineerPoints int
     */
    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
        databaseReference.child("user").
                child("engineer").setValue(this.engineerPoints);
    }

    /**
     * set name
     * @param name string of name
     */
    public void setName(String name) {
        this.name = name;
        databaseReference.child("user").
                child("name").setValue(this.name);
    }

    /**
     * set ship
     * @param ship string of ship
     */
    public void setShip(String ship) {
        this.ship = ship;
        databaseReference.child("user").
                child("ship").setValue(this.ship);
    }

    /**
     * set speical weapon
     * @param specialWeapon string special weapon
     */
    public void setSpecialWeapon(String specialWeapon) {
        this.specialWeapon = specialWeapon;
        databaseReference.child("user").
                child("special weapon").setValue(this.specialWeapon);
    }

    /**
     * set difficulty
     * @param difficulty Difficulty enum
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        databaseReference.child("user").
                child("difficulty").setValue(this.difficulty.toString());
    }

    /**
     * set Fuel
     * @param fuel int of fuel
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
        databaseReference.child("user").
                child("fuel").setValue(this.fuel);
    }


}