import java.util.Scanner;
//Project from high school AP Comp Sci course

public class Piggy {
		static int swapPlayer(int player) {
   			if (player == 0)
				return 1;
			else
				return 0;
  		}
		
		static void printPoints(int player, int points) {
			System.out.println("P"+ (player + 1) +"'s Total Points: " + points +"\n\n");
		}
	
		public static void main(String[] args) {
			Scanner scan = new Scanner (System.in);
			
			int currentP = 0; //0 if it's player 1's turn, 1 if it's player 2's turn
			int player[] = {1, 2};
			boolean game = true;
			
			int roundPts[] = {0, 0};
			int totalPts[] = {0, 0};
			
			int []roll = new int[4]; //player rolls two dice at a time
			
			System.out.println("Welcome to Piggy!");
			System.out.println("\nHow to Play:\nRoll the two dice to get points.");
			System.out.println("You can either keep rolling (Enter 1), or pass the dice to the next player (Enter 0).");
			System.out.println("BUT if you roll a SINGLE six, you lose all your points for that round.");
			System.out.println("And if you roll DOUBLE sixes, you lose ALL of your total points!");
			System.out.println("First player to 100 points wins!\n");
			
			while (game == true) {
		
				System.out.println("\nPlayer " + player[currentP] + "'s turn. (Press enter to roll)");
				scan.nextLine();
			
				roll[0] = (int)(Math.random()*(5)+1); 
				roll[1] = (int)(Math.random()*(5)+1);

				roundPts[currentP] += roll[0] + roll[1];
			
				System.out.println(roll[0] +", " +roll[1] +" -> You rolled " +(roll[0] + roll[1]) +"\n");
			
				if (roundPts[currentP] + totalPts[currentP] >= 100) {
					totalPts[currentP] += roundPts[currentP];
					System.out.println("Player "+  player[currentP] +"'s Total Points: " +totalPts[currentP] +"\nPlayer "+ (currentP + 1) +" wins!");
					game = false;
					break;
				}
			
				System.out.println("Player "+  player[currentP] +"'s round points: " +roundPts[currentP]);
			
				System.out.println("Roll again (Enter 1) or pass (Enter 0)?");
				while (!scan.hasNextInt()) {
					System.out.println("That's not 0 or 1! Roll again (Enter 1) or pass (Enter 0)?");
					scan.next();
				}
				int reRoll = scan.nextInt();
			
				if (reRoll == 0) { //switch player
					totalPts[currentP] += roundPts[currentP]; //add roundPts to total
					roundPts[currentP] = 0;
					printPoints(currentP, totalPts[currentP]);
					currentP = swapPlayer(currentP);
				}
			
				while (reRoll == 1) { //to keep rolling as player 1
					roll[2] = (int)(Math.random()*(6)+1);
					roll[3] = (int)(Math.random()*(6)+1);
			
					System.out.print(roll[2] +", " +roll[3] +" -> You rolled " + (roll[2] + roll[3]) + "\n"); //show rolls
				
					roundPts[currentP] += roll[2] + roll[3];
				
					if (roll[2] == 6 && roll[3] == 6) { // if rolled double 6
						roundPts[currentP] = 0;
						totalPts[currentP] = 0;
						System.out.println("You lost all of your points!!");
						printPoints(currentP, totalPts[currentP]);
						currentP = swapPlayer(currentP);
						break;
					}
				
					if (roll[2] == 6 || roll[3] == 6) { // if rolled one six
						roundPts[currentP] = 0;
						System.out.println("You lost all your round points!");
						printPoints(currentP, totalPts[currentP]);
						currentP = swapPlayer(currentP);
						break;
					}
				
					System.out.print((roll[2] + roll[3]) +"\n"); //extra formatting
					System.out.println("P"+  player[currentP] +"'s round points: " +roundPts[currentP]);//display points
				
					if (roundPts[currentP] + totalPts[currentP] >= 100) { //if player wins
						totalPts[currentP] += roundPts[currentP];
						printPoints(currentP, totalPts[currentP]);
						System.out.println("\nPlayer"+ (currentP + 1) +" wins!");
						game = false;
						currentP = swapPlayer(currentP);
						break;
					}
				
					System.out.println("Roll again (Enter 1) or pass (Enter 0)?"); //pass?
					while (!scan.hasNextInt()) {
						System.out.println("That's not a number! Roll again (Enter any number) or pass (Enter 0)?");
						scan.next();
					}
					reRoll = scan.nextInt();
				
					if (reRoll == 0) {
						totalPts[currentP] += roundPts[currentP];
						roundPts[currentP] = 0;
						printPoints(currentP, totalPts[currentP]);
						currentP = swapPlayer(currentP);
					}
				} //while rerolling
			
			} //game true
			int winner = totalPts[0] >= 100 ? 0 : 1;
			System.out.println("Player "+  player[winner] +" wins!!");
			scan.close();
		}

	}
