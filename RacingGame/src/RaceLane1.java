
/**
 * RaceLane1
 * The user will input the model, location, and max speed for two cars. 
 * Their properties will be displayed using the toString() method once.
 * The cars will then turn around using the turnAround() method once and will be displayed again.
 * Afterwards, a do-while loop will cause the cars to continue moving and turning until they reach the same location, at which point they crash and the loop breaks. 
 * 
 * 	The car that is ahead will be the one to turn around. This will decrease its location while the other car catches up.
 * 	If the car that is behind passes the other without reaching the same location, this action will repeat.
 * 
 * Once the cars crash and exit the loop, a message will display "Boom!!" to illustrate that they have crashed. 
 * 
 * @author David Bodromian
 */

import java.util.Scanner;

public class RaceLane1 {

	public static void main(String[] args) {
		Scanner myKeyboard = new Scanner(System.in);
		
		String model;
		int location;
		int maxSpeed;
		
		//user inputs for first car model, location, and max speed
		System.out.println("Please enter the model of the first car");
		model = myKeyboard.next();
		
		//making sure the inputed location is not negative (same for Car 2)
		do {
			System.out.println("Please enter the location of the first car");
			location = myKeyboard.nextInt();
		}while(location < 0);
		
		System.out.println("Please enter the Speed of the first car");
		maxSpeed = myKeyboard.nextInt();
		
		//creating the first car object
		Car C1 = new Car(model, maxSpeed, location);
		
		//user inputs for second car model, location, and max speed
		System.out.println("Please enter the model of the second car");
		model = myKeyboard.next();
		
		do {
			System.out.println("Please enter the location of the second car");
			location = myKeyboard.nextInt();
		}while(location < 0);
		
		System.out.println("Please enter the Speed of the second car");
		maxSpeed = myKeyboard.nextInt();
		
		//creating the second car object
		Car C2 = new Car(model, maxSpeed, location);
		
		//check states of each car
		System.out.println(C1.toString());
		System.out.println(C2.toString());
		
		//determine car to the left (smaller location means left)
		if(C1.getLocation() > C2.getLocation()) {
			C1.turnAround();
		}
		else {
			C2.turnAround();
		}
		
		//check states of each car
		System.out.println(C1.toString());
		System.out.println(C2.toString());
		
		//start each car
		C1.go();
		C2.go();
		
		//do-while loop to keep cars moving until cars collide
		do {
			if(C1.getLocation() > C2.getLocation())
				C1.turnAround();
			else
				C2.turnAround();
			
			C1.move();
			C2.move();
			System.out.println(C1.toString());
			System.out.println(C2.toString());
		}while(C1.getLocation() != C2.getLocation());
		//Boom message once do-while loop breaks
		System.out.println("Boom!!");
		
		myKeyboard.close();
	}

}
