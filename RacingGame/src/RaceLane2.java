
/**
 * RaceLane2
 * The user will be asked to input how many cars should enter the race. The array cars is created to store each car and its size will depend on the user's input.
 * Next, the user will also input the number of laps in the race, the name of each car, and its max speed.
 * When entering the max speeds, the user enters a do-while loop to make sure the typed speed is between 2 and 7.
 * 
 * Variables winner, CurrentCars, and NumCrash are created to keep track of the amount of winners, current cars, and crashed cars on the field.
 * - Winners will increase by 1 every time a car reaches or surpasses all laps (*100 in units)
 * - NumCrash will increase every time a car's crashed property turns true
 * - CurrentCars is initialized at the amount of cars inputed, but will decrease by the amount of winners and crashed cars there are on the field
 * 
 * The race is formed in a do-while loop
 * The variable units will keep track of how much of the track has been raced. One lap covers 100 units.
 * Cars will continue to accelerate and move and their progress will be displayed at every iteration. If the crashed variable is true for a car, it will no longer accelerate. 
 * At 100 units, crash detection starts:
 * 		If three cars have the same max speed, their crashed property will equal true to indicate that they have crashed.
 * 		The reason for this is that every car has been accelerating by 1 since the beginning of the race. Therefore those with the same speed will have the same location.
 * 		These cars will be stopped using the stop() method and will no longer accelerate because of their crashed property.
 * Cars that pass through all laps are winners. They will then stop and will also have the crashed property true so they no longer accelerate.
 * The loop goes on until no participants are left or we obtain three winners.
 * After the loop, winners are displayed if there are any. Otherwise this means all cars have crashed and a message saying this will display.
 * 
 * @author David Bodromian
 */

import java.util.Scanner;

public class RaceLane2 {

	public static void main(String[] args) {
		Scanner myKeyboard = new Scanner(System.in);
		
		//variables that the user will input for each car
		String model;
		int maxSpeed;
		
		//Creating an array which will store the cars
		System.out.println("How many cars are going to race:");
		int Participants = myKeyboard.nextInt();
		Car[] cars = new Car[Participants];
		
		//number of laps inputed by user.
		System.out.println("How many laps:");
		int laps = myKeyboard.nextInt();
		
		//for-loop to create the car objects stored in the cars array
		for(int i = 0; i < cars.length; i++) {
			System.out.println("Please enter the model of car " + i);
			model = myKeyboard.next();
			
			//do-while loop to specify max speed within bounds
			do {	
				System.out.println("Please enter the max speed of the car " + i);
				maxSpeed = myKeyboard.nextInt();
			}while(maxSpeed < 2 || maxSpeed > 7);
			
			//car object created
			cars[i] = new Car(model, maxSpeed);
			
		}
		
		
		//winner variable that will increase by one every time a car finishes the race
		int winner = 0;
		
		
		//NumCrash will keep track of all cars involved in a crash
		int NumCrash = 0;
		
		//CurrentCars will keep track of all cars still participating in the race
		int CurrentCars = Participants; 
		
		//Race begins
		do {
			
			//tracking units progressed
			int units = 0;
			for(int i = 0; i < cars.length; i++) {
				if(cars[i].getLocation() > units)
					units = cars[i].getLocation();
			}
			
			//crash detection
			if(units >= 100) {
				int count = 0;
				int crashSpeed = 0;
				
				//each cars' maxSpeed will be compared to every other car's
				for(int i = 0; i < Participants; i++) {
					//reset count to 0 if at least 2 other cars do not have the same maxSpeed as the car they are being compared to
					count = 0;
					
					for(int j = 0; j < Participants; j++) {
						if(cars[j].getMaxSpeed() == cars[i].getMaxSpeed()) {
							count++;
							crashSpeed = cars[j].getMaxSpeed();
							}
						
						//if 3 or more cars have the same maxSpeed, they crash
						if(count >= 3)
							for(int k = 0; k < Participants; k++) {
								if(cars[k].getMaxSpeed() == crashSpeed &&  cars[k].getCrashed() != true) {
									//Crash() method will make the crashed boolean variable = true
									cars[k].Crash();
									CurrentCars--;
									NumCrash++;
									
									}
								}
						}
					}
			}
			
			//Use Crash() method on cars that have completed the race to stop them from accelerating or moving any further.
			for(int i = 0; i < Participants; i++) {
				if(cars[i].getLocation() > (laps*100) && cars[i].getCrashed() != true) {
					cars[i].Crash();
					winner++;
					CurrentCars--;
				}
			}
			
			//after the first lap, the number of cars crashed this loop and the cars still participating are displayed every iteration
			if(units >= 100) {
				System.out.println("Num of crashed cars: " + NumCrash);
				System.out.println("Number of current cars in race " + CurrentCars);
			}
			
			//Accelerate, move, and display cars racing (cars crashed or winners will not accelerate)
			for(int i = 0; i < Participants; i++) {
				cars[i].Accelerate();
				cars[i].move();
				System.out.println(cars[i].toString());
			}
			
			//reset NumCrash for next iteration
			NumCrash = 0;
			
			//if we have 3 winners the race stops
			if(winner >= 3)
				CurrentCars = 0;
		//do-while loop will end once there are no more cars racing
		}while(CurrentCars > 0);
		
		if(winner >= 1) {
			System.out.println("The winners are: ");
			for(int i = 0; i < cars.length; i++) {
				if(cars[i].getLocation() >= laps*100)
					System.out.println(cars[i].toString());
			}
		}
		else
			System.out.println("All cars have crashed.");
		
		myKeyboard.close();
	}
}
