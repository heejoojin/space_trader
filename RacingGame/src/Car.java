
/** 
 * Class Car
 * Stores the properties and methods for RaceLane1 and RaceLane2.
 * 
 * Each car object is determined by its model, location, current speed, direction, and its max speed. 
 * 	location is an integer variable because it will store a car's placement on the race track.
 * 	boolean crashed will only be used in RaceLane2. This variable will hold true if a car crashes during the race.
 * Three constructors exist: A default constructor, a three argument constructor for RaceLane1, and a two argument constructor for RaceLane2.
 * 
 * List of methods:
 * 		getModel(), getDirection(), and getLocation() methods return the model, direction, and location point of a car respectively
 * 		go() will make a car run at its max speed, stop() will perform a full stop (current speed will be 0), turnAround() will change a car's direction
 * 		move() will change a car's location; a car's location will increase by its current speed if it is facing forward and will decrease if it is going backward
 * 		the toString() method will display a car's properties in a structured manner
 * 
 * Methods only for RaceLane2:
 * Accelerate() will increase a car's current speed by one. However, if a car has crashed, its speed will remain unchanged.
 * brake() will reduce a car's current speed by 1. This will not apply if its speed is 0.
 * 
 * 	Added methods:
 * 		getMaxSpeed() will return a car's max speed
 * 		Crash() will change a car's crashed variable to true
 * 		getCrashed() will return a car's boolean crashed property
 * 
 * @author David Bodromian
 */

public class Car {
	private String model;
	private int location;
	private int currentSpeed;
	private boolean movingForward;
	private int maxSpeed;
	
	//Added field for crash detection
	private boolean crashed;
	
	//default constructor
	public Car() {
		model = null;
		location = 0;
		currentSpeed = 0;
		movingForward = false;
		maxSpeed = 0;
	}
	
	//three argument constructor
	public Car(String model, int maxSpeed, int location) {
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.location = location;
		movingForward = true;
		currentSpeed = 0;
	}
	
	//methods
	public String getModel() {
		return model;
	}
	
	public String getDirection() {
		if(movingForward != false) 
			return "forward";
		else 
			return "backwards";
		
	}
	
	public int getLocation() {
		return location;
	}
	
	public int go() {
		currentSpeed = maxSpeed;
		return currentSpeed;
	}
	
	public int stop() {
		currentSpeed = 0;
		return currentSpeed;
	}
	
	public boolean turnAround() {
		movingForward = !movingForward;
		return movingForward;
	}
	
	public int move() {
		if(movingForward == true)
			location += currentSpeed;
		else
			location -= currentSpeed;
		
		return location;
	}
	
	public String toString() {
		if(currentSpeed != 0) 
			return model + " Located at: " + location + ", facing " + this.getDirection() + ", and moving at " + currentSpeed + " speed";
		else 
			return model + " Located at: " + location + ", facing " + this.getDirection() + ", not moving";
	}
	
	//Part 2
	
	//two argument constructor
	public Car(String model, int maxSpeed) {
		this.model = model;
		this.maxSpeed = maxSpeed;
		location = 0;
		movingForward = true;
		currentSpeed = 0;
		
		//crashed is false by default
		crashed = false;
	}
	
	//new methods
	public int Accelerate() {
		if(crashed == false && currentSpeed != maxSpeed) 
			currentSpeed += 1;
		if(crashed == true)
			currentSpeed = 0;
		
		return currentSpeed;
	}
	
	public int brake() {
		if(currentSpeed != 0)
			currentSpeed -= 1;
		return currentSpeed;
	}
	
	//Added methods
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public boolean Crash() {
		crashed = true;
		return crashed;
	}
	
	public boolean getCrashed() {
		return crashed;
	}

}
