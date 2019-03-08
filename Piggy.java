import java.util.Scanner;

public class Piggy {

		public static void main(String[] args) {
	Scanner scan = new Scanner (System.in);
			
			int player = 1;
			boolean game = true;
			
			int roundPts1 = 0;
			int total1 = 0;
			int roundPts2 = 0;
			int total2 = 0;
			
			int roll1;
			int roll2;
			int roll3;
			int roll4;
			
			System.out.println("Pig");
			System.out.println("\nHow to Play:\nRoll the two dice to get points.");
			System.out.println("You can either keep rolling (1), or pass the dice to the next player (0).");
			System.out.println("BUT if you roll a SINGLE six, you lose all your points for that round.");
			System.out.println("And if you roll DOUBLE sixes, you lose ALL of your total points!");
			System.out.println("First player to 100 points wins!");
			
			while (game == true) {
		
			if (player == 1) {
			System.out.println("\nPlayer 1's turn. (Press enter to roll)");
			scan.nextLine();
			
			roll1 = (int)(Math.random()*(5)+1); 
			roll2 = (int)(Math.random()*(5)+1);

			roundPts1 += roll1 + roll2;
			
			System.out.println(roll1 +", " +roll2 +" -> " +(roll1 + roll2) +"\n"); // show rolls
			
			if (roundPts1 + total1 >= 100) {
				total1 += roundPts1;
				System.out.println("P1's Total Points: " +total1 +"\nP1 wins!");
				game = false;
				player = 0;
				break;
			}
			
			System.out.println("P1's round points: " +roundPts1); //show round points
			
			System.out.println("Roll again (Press 1) or pass (Press 0)?"); //pass or roll again?
			while (!scan.hasNextInt()) {
				System.out.println("That's not 0 or 1! Roll again (Press 1) or pass (Press 0)?");
				scan.next();
			}
			int	reRoll = scan.nextInt();
			
			if (reRoll == 0) { //switch player
				total1 += roundPts1; //add roundPts to total
				roundPts1 = 0;
				System.out.println("P1's Total Points: " +total1 +"\n\n");
				player = 2;
			}
			
			while (reRoll == 1) { //to keep rolling as player 1
				roll3 = (int)(Math.random()*(6)+1);
				roll4 = (int)(Math.random()*(6)+1);
			
				System.out.print(roll3 +", " +roll4 +" -> "); //show rolls
				
				roundPts1 += roll3 + roll4;
				
				if (roll3 == 6 && roll4 == 6) { // if rolled double 6
					roundPts1 = 0;
					total1 = 0;
					System.out.println("You lost all of your points!!");
					System.out.println("P1's Total Points: " +total1 +"\n\n");
					player = 2;
					break;
				}
				
				if (roll3 == 6 || roll4 == 6) { // if rolled one six
					roundPts1 = 0;
					System.out.println("You lost all your round points!");
					System.out.println("P1's Total Points: " +total1 +"\n\n");
					player = 2;
					break;
				}
				
				System.out.print((roll3 + roll4) +"\n"); //extra formatting
				System.out.println("P1's round points: " +roundPts1);//display points
				
				if (roundPts1 + total1 >= 100) { //if p1 wins
					total1 += roundPts1;
					System.out.println("P1's total points: " + total1 + "\nP1 wins!");
					game = false;
					player = 0;
					break;
				}
				
				System.out.println("Roll again (Press 1) or pass (Press 0)?"); //pass?
				while (!scan.hasNextInt()) {
					System.out.println("That's not 0 or 1! Roll again (Press 1) or pass (Press 0)?");
					scan.next();
				}
				reRoll = scan.nextInt();
				
				if (reRoll == 0) {
					total1 += roundPts1;
					roundPts1 = 0;
					System.out.println("P1's Total Points: " +total1 +"\n\n");
					player = 2;
				}
			} //while ends
				
			} //if player 1
				
			if(player == 2) {
				
				System.out.println("\nPlayer 2's turn. (Press enter to roll)"); //EDIT TEXT
				scan.nextLine();
				
				roll1 = (int)(Math.random()*(5)+1);
				roll2 = (int)(Math.random()*(5)+1);
			
				roundPts2 += roll1 + roll2;
				
				System.out.println(roll1 +", " +roll2 +" -> " +(roll1 + roll2) +"\n"); 
				
				if (roundPts2 + total2 >= 100) {
					total2 += roundPts2;
					System.out.println("P2's Total Points: " +total2 +"\nP2 wins!");
					game = false;
					player = 0;
					break;
				}
				
				System.out.println("P2's round points: " +roundPts2); //display rolls
				
				System.out.println("Roll again (Press 1) or pass (Press 0)?"); //pass?
				while (!scan.hasNextInt()) {
					System.out.println("That's not 0 or 1! Roll again (Press 1) or pass (Press 0)?");
					scan.next();
				}
				int	reRoll = scan.nextInt();
				
				if (reRoll == 0) { // switch player
					total2 += roundPts2;
					roundPts2 = 0;
					System.out.println("P2's Total Points: " +total2 +"\n\n");
					player = 1;
				}
			
				while (reRoll == 1) { //player 2
					roll3 = (int)(Math.random()*(6)+1);
					roll4 = (int)(Math.random()*(6)+1);

					System.out.print(roll3 +", " +roll4 +" -> ");
					
					roundPts2 += roll3 + roll4;

					if (roll3 == 6 && roll4 == 6) {
						roundPts2 = 0;
						total2 = 0;
						System.out.println("You lost all of your points!!");
						System.out.println("P2's Total Points: " +total2 +"\n\n");
						player = 1;
						break;
					}
					
					if (roll3 == 6 || roll4 == 6) {
						roundPts2 = 0;
						System.out.println("You lost all your round points!");
						System.out.println("P2's Total Points: " +total2 +"\n\n");
						player = 1;
						break;
					}
					
					System.out.print((roll3 + roll4) +"\n");
					System.out.println("P2's round points: " +roundPts2);
					
					if (roundPts2 + total2 >= 100) {
						total2 += roundPts2;
						System.out.println("P2's total points: " + total2 +"\nP2 wins!");
						game = false;
						player = 0;
						break;
					}
					
					System.out.println("Roll again (Press 1) or pass (Press 0)?"); //pass?
					while (!scan.hasNextInt()) {
						System.out.println("That's not 0 or 1! Roll again (Press 1) or pass (Press 0)?");
						scan.next();
					}
					reRoll = scan.nextInt();
					
					if (reRoll == 0) {
						total2 += roundPts2;
						roundPts2 = 0;
						System.out.println("P2's Total Points: " +total2 +"\n\n");
						player = 1;
					}
				}
					
				}
			
			} //game true
			
		}

	}
